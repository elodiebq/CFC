/* Biqiu Li
   biqiul
   task7
   1-20-2015 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.CustomerDAO;
import databeans.CustomerBean;
import formbeans.ChangePwdForm;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class CustomerChangePwdAction extends Action {
	private FormBeanFactory<ChangePwdForm> formBeanFactory = FormBeanFactory
			.getInstance(ChangePwdForm.class);

	private CustomerDAO customerDAO;

	public CustomerChangePwdAction(Model model) {
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "customer_change_pwd.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);
		try {
			ChangePwdForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "customer_changepassword.jsp";
			}


			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "customer_changepassword.jsp";
			}

			// Look up the user
			CustomerBean customer = (CustomerBean) request.getSession(false)
					.getAttribute("customer");
			if (customer == null) {
				return "login.do";
			}
		
			// Check the password

			/*if (customer.checkPassword(form.getOldPassword())) {
				errors.add("Incorrect password");
				return "customer_changepassword.jsp";
			}*/
			customer.setPassword(form.getNewPassword());
			try {

				customerDAO.setPassword(customer);
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Attach (this copy of) the user bean to the session

			request.setAttribute("message",
					"Password changed for " + customer.getFirstName() + " "
							+ customer.getLastName());
			return "customer_changepassword.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
