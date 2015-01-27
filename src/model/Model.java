package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

public class Model {
	private CustomerDAO 	customerDAO;
	private FundDAO     	fundDAO;
	private PositionDAO 	positionDAO;
	private PriceDAO    	priceDAO;
	private TransactionDAO  transactionDAO; 
	

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			customerDAO     = new CustomerDAO("customer", pool);
			fundDAO 	    = new FundDAO("fund", pool);
			positionDAO     = new PositionDAO("position", pool);
			priceDAO        = new PriceDAO("price", pool);
			transactionDAO  = new TransactionDAO("transaction", pool);
			
		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	public CustomerDAO    getCustomerDAO()    { return customerDAO;    }
	public FundDAO        getFundDAO()  		  { return fundDAO;  	   }
	public PositionDAO    getPositionDAO()    { return positionDAO;    }
	public PriceDAO  	  getPriceDAO()  	  { return priceDAO;       }
	public TransactionDAO getTransactionDAO() { return transactionDAO; }
}
