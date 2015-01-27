package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.CustomerBean;


public class CustomerDAO extends GenericDAO<CustomerBean> {
	

	public CustomerDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(CustomerBean.class, tableName, pool);
	}
	
	public CustomerBean[] getCustomers() throws RollbackException {
		CustomerBean[] customers = match();
		Arrays.sort(customers);  // We want them sorted by last and first names (as per Customer.compareTo());
		return customers;
	}
	
	public void setPassword(CustomerBean customer) throws RollbackException {
        try {
			update(customer);
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public void setCash(int customerid, Long newbalance)
			throws RollbackException {
		try {
			Transaction.begin();
			CustomerBean dbUser = read(customerid);

			if (dbUser == null) {
				throw new RollbackException("User " + customerid
						+ " no longer exists");
			}

			dbUser.setCash(newbalance);

			update(dbUser);
			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
	public CustomerBean read(String username) throws RollbackException {
		try {
			Transaction.begin();
			CustomerBean[] dbUser = match(MatchArg.equals("email", username));
			CustomerBean user = null;
			if (dbUser.length == 0) {
				// throw new
				// RollbackException("User "+email+" no longer exists");
			} else {
				user = dbUser[0];
			}

			Transaction.commit();
			return user;
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
	
}
