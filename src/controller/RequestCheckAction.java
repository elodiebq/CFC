package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import model.Model;
import model.TransactionDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.CustomerBean;
import databeans.TransactionBean;
import formbeans.RequestCheckForm;

public class RequestCheckAction extends Action {
	private FormBeanFactory<RequestCheckForm> formBeanFactory = FormBeanFactory
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
			// request.setAttribute("customer", CustomerDAO.getUsers());
			RequestCheckForm form = formBeanFactory.create(request);

			// If no params were passed, return with no errors so that the form
			// will be
			// presented (we assume for the first time).

			// Any validation errors?

			CustomerBean customer = (CustomerBean) request.getSession(false)
					.getAttribute("customer");
			if (customer == null) {
				return "login.do";
			}
			CustomerBean customerbean = customerDAO.read(customer.getEmail());
			
			Long cash = customerbean.getCash();
			Double pagebalance = cash.doubleValue();
			request.setAttribute("cash", String.valueOf(pagebalance/100));
			if (!form.isPresent()) {
				return "customer_requestCheck.jsp";
			}
			System.out.println("2");
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "customer_requestCheck.jsp";
			}
			System.out.println("3");

			Long amount = new Double(
					Double.parseDouble(form.getAmount()) * 100).longValue();
			Long balance = customer.getCash();

			System.out.println("Amount" + form.getAmount());
			System.out.println("Balance" + balance);

			if (amount <= balance) {
				// Transaction.begin();
				balance = balance - amount;

				TransactionBean requestcheck = new TransactionBean();
				requestcheck.setCustomerId(customer.getCustomerId());
				requestcheck.setAmount(amount);
				requestcheck.setType("requestcheck");

				transactionDAO.create(requestcheck);

				customer.setCash(balance);

				customerDAO.setCash(customer.getCustomerId(), balance);
				// Transaction.commit();

				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				request.setAttribute("message", "You have made $" + amount/100
	                    + " check.");
			} else {
				errors.add("Amount should less than cash balance");
				return "customer_requestCheck.jsp";
			}
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            request.setAttribute("msg", "You have request $" + amount / 100
                    + " for a check.");
            cash = customer.getCash();
            pagebalance = cash.doubleValue();
            request.setAttribute("cash", String.valueOf(pagebalance / 100));
			return "customer_requestCheck.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "customer_requestCheck.jsp";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "customer_requestCheck.jsp";
		}
	}
}
