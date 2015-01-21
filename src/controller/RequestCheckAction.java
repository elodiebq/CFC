package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.Model;
import model.TransactionDAO;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.CustomerBean;
import databeans.TransactionBean;
import formbeans.RegisterForm;

public class RequestCheckAction extends Action {
	private FormBeanFactory<RequestCheckForm> requestcheckFactory = FormBeanFactory
			.getInstance(RequestCheckForm.class);

	private TransactionDAO transactionDAO;
	private CustomerDAO customerDAO;

	public RequestCheckAction(Model model) {
		transactionDAO = model.getTransactionDAO();
		customerDAO = model.getCustomerDAO();
		
	}

	public String getName() {
		return "requestcheck.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			//request.setAttribute("customer", CustomerDAO.getUsers());
			RequestCheckForm form = formBeanFactory.create(request);
			request.setAttribute("form", form);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).
			if (!form.isPresent()) {
				return "requestcheck.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "register.jsp";
			}
			
			CustomerBean customer = (CustomerBean) request.getSession(false).getAttribute(
					"customer");
			if (customer == null){
				return "login.do";
			}
			
			double balance = customer.getCash();
			
			if(form.getAmount() <= balance){
				Transaction.begin();
				balance = balance - form.getAmount();
				
				TransactionBean requestcheck = new TransactionBean();
				requestcheck.setCustomerId(customer.getCustomerId());
				requestcheck.setAmount(form.getAmount());
				requestcheck.setType("requestcheck");
				
				transactionDAO.create(requestcheck);
				
				customer.setCash(balance);
				
				customerDAO.setCash(customer.getCustomerId(), balance);
				Transaction.commit();
				
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
			}

			return "requestcheck.do";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "requestcheck.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "requestcheck.jsp";
		}
	}
}

