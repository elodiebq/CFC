package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.PositionBean;

public class PositionDAO extends GenericDAO<PositionBean> {
	public PositionDAO(String tableName, ConnectionPool pool)
			throws DAOException {
		super(PositionBean.class, tableName, pool);
	}

	public PositionBean[] getPositions() throws RollbackException {
		PositionBean[] positions = match();
		Arrays.sort(positions); // We want them sorted by last and first names
								// (as per Customer.compareTo());
		return positions;
	}

	public PositionBean[] getPositionByCustomer(int customerId) throws RollbackException {
		PositionBean[] positions = match(MatchArg.equals("customerId", customerId));
		return positions;
	}

	public void setShare(int customerid, int fundid, long share) throws RollbackException {
		try {
			Transaction.begin();
			PositionBean dbPosition = read(customerid,fundid);

			if (dbPosition == null) {
				throw new RollbackException("Email Address " + customerid
						+ " no longer exists");
			}

			dbPosition.setShare(share);

			update(dbPosition);
			Transaction.commit();
		} finally {
			if (Transaction.isActive())
				Transaction.rollback();
		}
	}

	public long getShareByCustomerIDandFundID(int customerId, int fundID)
			throws RollbackException {
		PositionBean position = read(customerId, fundID);
		if(position==null)
		    return -1;
		long share = position.getShare();
		return share;
	}

}
