package controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import databeans.CustomerBean;
import databeans.TransactionBean;
import formbeans.TransactionRecordBean;

import model.Model;

import model.TransactionDAO;

public class ViewHistoryAction extends Action{
	
	// private FormBeanFactory<UserForm> formBeanFactory =
	// FormBeanFactory.getInstance(UserForm.class);


	private TransactionDAO transactionDAO;

	
	public ViewHistoryAction(Model model) {

		transactionDAO = model.getTransactionDAO();

	}

	public String getName() {
		return "ViewHistory.do";
	}

	public String perform(HttpServletRequest request) {
		// Set up the request attributes (the errors list and the form bean so
		// we can just return to the jsp with the form if the request isn't
		// correct)
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			
			HttpSession session = request.getSession();
			CustomerBean customer = (CustomerBean) session.getAttribute("user");
			if (customer == null) {
				errors.add("Invalid user");
				return "error.jsp";
			}
			int customerId = customer.getCustomerId();

			TransactionBean[] transactionHistory = transactionDAO.getTransactionsByCustomer(customerId);
			request.setAttribute("TransactionHistory", transactionHistory);
			return "customer_viewTransactionHistory.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
