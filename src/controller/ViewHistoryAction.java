package controller;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.CustomerBean;
import databeans.TransactionBean;
import databeans.ViewHistoryForm;
import model.Model;
import model.FundDAO;
import model.PriceDAO;
import model.TransactionDAO;

public class ViewHistoryAction extends Action{
	
	// private FormBeanFactory<UserForm> formBeanFactory =
	// FormBeanFactory.getInstance(UserForm.class);


	private TransactionDAO transactionDAO;
//	private CustomerDAO customerDAO;
	private FundDAO fundDAO;
	private PriceDAO priceDAO;

	
	public ViewHistoryAction(Model model) {

		transactionDAO = model.getTransactionDAO();
//		customerDAO = model.getCustomerDAO();
		fundDAO = model.getFundDAO();
		priceDAO = model.getPriceDAO();
		transactionDAO = model.getTransactionDAO();
	}

	public String getName() {
		return "viewTransactionHistory.do";
	}

	public String perform(HttpServletRequest request) {
		// Set up the request attributes (the errors list and the form bean so
		// we can just return to the jsp with the form if the request isn't
		// correct)
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			
			CustomerBean customer = (CustomerBean) request.getSession(false)
					.getAttribute("customer");
			
			if (customer == null) {
				errors.add("Invalid user");
	
				return "login.jsp";
			}
			
			int customerId = customer.getCustomerId();
			String customerName = customer.getFirstName() + " " + customer.getLastName();
			TransactionBean[] transactions = transactionDAO.getTransactionsByCustomer(customerId);
			ArrayList<ViewHistoryForm> records = new ArrayList<ViewHistoryForm>();
			
			//System.out.println("transaction"+ transction);
		
			for (int i = 0; i < transactions.length; i++) {
				ViewHistoryForm record = new ViewHistoryForm();
				
				int fundId = transactions[i].getFundId();
				int transactionId = transactions[i].getTransactionId();
				record.setTransactionId(transactionId);
				if (fundId != 0) {
					String fundName = fundDAO.read(fundId).getFundName();
					record.setFundName(fundName);
				}
//				System.out.println("type: " + transactions[i].getType());
				record.setType(transactions[i].getType());
       

				double share = (double) transactions[i].getShare() / 1000;
				DecimalFormat df = new DecimalFormat("0.000");
				String formattedShare = df.format(share);
				record.setShare(formattedShare);

//				System.out.println("Here1: " + priceDAO.getLastDayByFund(fundId));
				DecimalFormat df2 = new DecimalFormat("0.00");

				double amount = transactions[i].getAmount() / 100;
				String formattedAmount = df2.format(amount);
				record.setAmount(formattedAmount);

				Date date = transactions[i].getDate();
				if (date == null) {
					record.setDate("pending");
					record.setPrice(null);

				} else {
					SimpleDateFormat dsf = new SimpleDateFormat("MM/dd/yyyy");
					record.setDate(dsf.format(date));
					
					double lastPrice = (double)priceDAO.getFundPrice(fundId,date) / 100;
				
					String formattedLastPrice = df2.format(lastPrice);
					record.setPrice(formattedLastPrice);
				}
				records.add(record);
			}
			request.setAttribute("msg", "This is the transaction history of " + customerName);
			request.setAttribute("records", records);
			
			
			request.setAttribute("TransactionHistory", transactions);
			return "customer_viewTransactionHistory.jsp";
		} catch (RollbackException e) {
			errors.add(e.getMessage());
			return "error.jsp";
		}
	}
}
