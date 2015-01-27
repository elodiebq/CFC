package controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.CustomerBean;
import databeans.FundBean;
import databeans.PositionBean;
import databeans.ViewAccountForm;
import model.CustomerDAO;
import model.FundDAO;
import model.Model;
import model.PositionDAO;
import model.PriceDAO;

public class ViewAccountAction extends Action {
	// private FormBeanFactory<EmailForm> formBeanFactory = FormBeanFactory
	// .getInstance(EmailForm.class);

	private FundDAO fundDAO;
	private PositionDAO positionDAO;
	private PriceDAO priceDAO;
	private CustomerDAO customerDAO;

	public ViewAccountAction(Model model) {
		fundDAO = model.getFundDAO();
		priceDAO = model.getPriceDAO();
		positionDAO = model.getPositionDAO();
		customerDAO = model.getCustomerDAO();
	}

	public String getName() {
		return "viewAccount.do";
	}

	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors", errors);

		try {
			CustomerBean customer = (CustomerBean) request.getSession(false)
					.getAttribute("customer");
			if (customer == null) {
				return "login.do";
			}

			CustomerBean customerbean = customerDAO.read(customer.getEmail());
			if (errors.size() != 0)
				return "customer_viewaccount.jsp";

			PositionBean[] positions = positionDAO
					.getPositionByCustomer(customer.getCustomerId());
			String formattedCash = null;
			double cash = customerbean.getCash() / 100;
			DecimalFormat df0 = new DecimalFormat("0.00");
			formattedCash = df0.format(cash);

			System.out.println("Im here! + customerid"
					+ customer.getCustomerId());

			ViewAccountForm[] records = new ViewAccountForm[positions.length];

			for (int i = 0; i < records.length; i++) {
				records[i] = new ViewAccountForm();
				int fundId = positions[i].getFundId();
				if (fundId != 0) {
				FundBean fund = null;
				try {
					fund = fundDAO.read(fundId);
				} catch (RollbackException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				records[i].setFundName(fund.getFundName());
				records[i].setSymbol(fund.getSymbol());
				}

				double share = (double) positions[i].getShare() / 1000;
				DecimalFormat df = new DecimalFormat("0.000");
				String formattedShare = df.format(share);
				records[i].setShare(formattedShare);

				double lastPrice = (double) priceDAO.getLastDayByFund(fundId) / 100;
				DecimalFormat df2 = new DecimalFormat("0.00");
				String formattedLastPrice = df2.format(lastPrice);
				records[i].setLastPrice(formattedLastPrice);
			}
			request.setAttribute("msg", "This is the account information of "
					+ customer.getFirstName() + customer.getLastName());
			request.setAttribute("customer", customer);
			request.setAttribute("records", records);
			request.setAttribute("cash", formattedCash);

			//System.out.println("Im here! record" + records[0].getFundName());

		} catch (RollbackException e) {
			e.printStackTrace();
		}

		return "customer_viewaccount.jsp";
	}
}
