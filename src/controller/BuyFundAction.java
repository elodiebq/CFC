package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FundDAO;
import model.Model;
import model.CustomerDAO;
import model.TransactionDAO;
import databeans.CustomerBean;
import databeans.FundBean;
import databeans.TransactionBean;
import formbeans.BuyFundForm;

import org.genericdao.RollbackException;
import org.genericdao.Transaction;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class BuyFundAction extends Action {
	private FormBeanFactory<BuyFundForm> formBeanFactory = FormBeanFactory
			.getInstance(BuyFundForm.class);

	private CustomerDAO customerDAO;
	private TransactionDAO transactionDAO;
	private FundDAO fundDAO;

	public BuyFundAction(Model model) {
		customerDAO = model.getCustomerDAO();
		transactionDAO = model.getTransactionDAO();
		fundDAO = model.getFundDAO();
	}

	public String getName() {
		return "buyfund.do";
	}

	public String perform(HttpServletRequest request) throws RollbackException {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			BuyFundForm form = formBeanFactory.create(request);
			request.setAttribute("buyfundform", form);
			
			if (!form.isPresent()) {
				return "login.jsp";
			}

			// Any validation errors?
			errors.addAll(form.getValidationErrors());
			if (errors.size() != 0) {
				return "login.jsp";
			}

			// request.setAttribute("customer", customerDAO.getCustomers());

			CustomerBean customer = (CustomerBean) request.getSession(false)
					.getAttribute("customer");
			if (customer == null) {
				return "login.do";
			}

			FundBean[] fundList = fundDAO.getAllFunds();
			request.setAttribute("fundList", fundList);

			String symbol = null;
			Long amount = null;
			FundBean fundbean = null;

			try {
				symbol = form.getSymbol();
				amount = Long.parseLong(form.getAmount());

				fundbean = fundDAO.readBySymbol(symbol);
				if (fundbean == null) {
					fundbean = fundDAO.readByName(symbol);
					if (fundbean == null) {
						// return err.add();
					}
				}

			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (amount <= customer.getCash()) {
				Transaction.begin();
				Long balance = customer.getCash() - amount;

				TransactionBean buyfund = new TransactionBean();
				buyfund.setFundId(fundbean.getFundId());
				buyfund.setCustomerId(customer.getCustomerId());
				buyfund.setAmount(amount);
				buyfund.setType("buy");

				transactionDAO.create(buyfund);

				customer.setCash(balance);
				customerDAO.setCash(customer.getCustomerId(), balance);

				Transaction.commit();
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
			} else {
				// err.add("not enough money");
			}

			return "buyfund.do";
		} catch (FormBeanException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}