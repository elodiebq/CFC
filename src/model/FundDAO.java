package model;


import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.FundBean;

public class FundDAO extends GenericDAO<FundBean> {
	public FundDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(FundBean.class, tableName, pool);
	}	

	public FundBean[] getAllFunds( ) throws RollbackException {
		FundBean[] allfund = match();
		return allfund;
	}
	public FundBean readBySymbol(String symbol) throws RollbackException {
		try {
			Transaction.begin();
			FundBean[] dbUser = match(MatchArg.equals("symbol", symbol));
			FundBean fundbean = null;
			if (dbUser.length == 0) {
				// throw new
				// RollbackException("User "+email+" no longer exists");
			} else {
				fundbean = dbUser[0];
			}

			Transaction.commit();
			return fundbean;
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
	public FundBean readByName(String name) throws RollbackException {
		try {
			Transaction.begin();
			FundBean[] dbUser = match(MatchArg.equals("fundName", name));
			FundBean fundbean = null;
			if (dbUser.length == 0) {
				// throw new
				// RollbackException("User "+email+" no longer exists");
			} else {
				fundbean = dbUser[0];
			}

			Transaction.commit();
			return fundbean;
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}
}
