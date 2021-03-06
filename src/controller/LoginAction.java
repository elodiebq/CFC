
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.CustomerDAO;
import databeans.CustomerBean;
import formbeans.LoginForm;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class LoginAction extends Action {
	private FormBeanFactory<LoginForm> formBeanFactory = FormBeanFactory.getInstance(LoginForm.class);

	private CustomerDAO customerDAO;

	public LoginAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "login.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			LoginForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "customer_login.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "customer_login.jsp";
			}

			// Look up the user
			CustomerBean customer = null;
			try {
				customer = customerDAO.read(form.getEmail());
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (customer == null) {
				errors.add("Email address not found");
				return "customer_login.jsp";
			}

			//check password
			if (!customer.checkPassword(form.getPassword())) {
				errors.add("Incorrect password");
				return "customer_login.jsp";
			}

			// Attach (this copy of) the user bean to the session
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);

			return "research_funds.do";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}