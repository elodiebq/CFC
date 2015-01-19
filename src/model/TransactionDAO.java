package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.TransactionBean;

public class TransactionDAO extends GenericDAO<TransactionBean> {
	public TransactionDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(TransactionBean.class, tableName, pool);
	}
	
	public TransactionBean[] getTransactions() throws RollbackException {
		TransactionBean[] transactions = match();
		Arrays.sort(transactions); 
		return transactions;
	}
	
	public TransactionBean[] getTransactionsByCustomer(int customerId) throws RollbackException {
		TransactionBean[] transactions = match(MatchArg.equals("customerId", customerId));
		Arrays.sort(transactions); 
		return transactions;
	}
	
//	public void setPassword(String email, String password) throws RollbackException {
//        try {
//        	Transaction.begin();
//			CustomerBean dbCustomer = read(email);
//			
//			if (dbCustomer == null) {
//				throw new RollbackException("Email Address "+ email +" no longer exists");
//			}
//			
//			dbCustomer.setPassword(password);
//			
//			update(dbCustomer);
//			Transaction.commit();
//		} finally {
//			if (Transaction.isActive()) Transaction.rollback();
//		}
//	}

}
