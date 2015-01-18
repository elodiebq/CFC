package model;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import databeans.FundBean;

public class FundDAO extends GenericDAO<FundBean> {
	public FundDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(FundBean.class, tableName, pool);
	}	

}
