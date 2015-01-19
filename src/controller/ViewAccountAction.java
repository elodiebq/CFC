package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import databeans.CustomerBean;
import databeans.PositionBean;
import formbeans.TransactionRecordBean;
import model.CustomerDAO;
import model.FundDAO;
import model.Model;
import model.PositionDAO;
import model.PriceDAO;
import model.TransactionDAO;

public class ViewAccountAction extends Action {
	
	private CustomerDAO customerDAO;
	private FundDAO fundDAO;
	private PositionDAO positionDAO;
	private PriceDAO priceDAO;
	private TransactionDAO transactionDAO;
	
	public ViewAccountAction(Model model) {
		customerDAO = model.getCustomerDAO();
		fundDAO = model.geFundDAO();
		priceDAO = model.getPriceDAO();
		transactionDAO = model.getTransactionDAO();
		positionDAO = model.getPositionDAO();
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "viewAccount.do";
	}

	public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
        
        CustomerBean customer = (CustomerBean) request.getSession().getAttribute("customer");
		
		if (customer == null) {
			errors.add("Invalid user");
			return "error.jsp";
		}
		
		PositionBean[] positions = null;
		
		try {
			positions =  positionDAO.getPositionByCustomer(customer.getCustomerId());
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TransactionRecordBean[] records = new TransactionRecordBean[positions.length];
		
		for (int i = 0 ; i < records.length; i++) {
			int fundId = positions[i].getFundId();
			records[i].setFundName(fundDAO.read(fundId).);
			records[i].setShare();
		}
		
		
		return null;
	}

}