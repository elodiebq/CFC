/*
Jike Li
Andrew ID:jikel
08-600
Homework #9
Date: Nov. 29, 2014
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CustomerDAO;
import model.FundDAO;
import model.Model;
import model.PositionDAO;
import model.PriceDAO;
import model.TransactionDAO;
import databeans.CustomerBean;
import databeans.UserBean;

public class ManageAction extends Action {

	private CustomerDAO customerDAO;
	private FundDAO     fundDAO;
	private PositionDAO     positionDAO;
	private PriceDAO     priceDAO;
	private TransactionDAO     transactionDAO;

	public ManageAction(Model model) {
		customerDAO = model.getCustomerDAO();
    	fundDAO     = model.getFundDAO();
    	positionDAO     = model.getPositionDAO();
    	priceDAO     = model.getPriceDAO();
    	transactionDAO     = model.getTransactionDAO();
	}

	public String getName() { return "manage.do"; }

	public String perform(HttpServletRequest request) {
        // Set up the errors list
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		// Set up user list for nav bar
		try {
        	CustomerBean[] customerList = CustomerDAO.getAllUsers();
			request.setAttribute("userList",userList);
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UserBean user = (UserBean) request.getSession(false).getAttribute("user");
		FavoriteBean[] favorites = null;
		try {
			favorites = favoriteDAO.getUserFavorites(user.getUserID());
		} catch (MyDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("favorites",favorites);

		return "manage.jsp";
    }
}
