package model;

import java.sql.Date;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.PriceBean;

public class PriceDAO extends GenericDAO<PriceBean>{

	public PriceDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(PriceBean.class, tableName, pool);
	}
	
	public PriceBean[] getAllPrices( ) throws RollbackException {
		PriceBean[] prices = match();
		return prices;
	}
	
	public Date getLastDay() throws RollbackException {
		PriceBean[] prices = getAllPrices();
		if (prices.length == 0) return null;
		Date d = new Date(0);
		for (PriceBean p : prices) {
			if (p.getDate().compareTo(d) > 0) d.setTime(p.getDate().getTime());		
		}
		return d;
	}
	
	public PriceBean[] getLastDayPrices() throws RollbackException {
		Date lastDay = getLastDay();
		if (lastDay == null) return null;
		PriceBean[] lastDayPrices = match(MatchArg.equals("date", lastDay));
		return lastDayPrices;
	} 
	
	public long getLastDayByFund(int fundId) throws RollbackException {
		Date lastDay = getLastDay();
		if (lastDay == null) return 0;

		PriceBean lastDayPrice = read(fundId, lastDay);
		if (lastDayPrice == null) return 0;
//		System.out.println("fundId" + fundId);
//		System.out.println("lastDayPrice" + lastDayPrice);
		
		return lastDayPrice.getPrice();
	} 
	
	public long getFundPrice(int fundId, Date date) throws RollbackException {
		if (fundId == 0) return 0;
		Date lastDay = getLastDay();
		
		if (date == null)
			return 0;
		if (date.after(lastDay))
			return 0;
		
		else {
			PriceBean lastDayPrice = read(fundId, date);
			return lastDayPrice.getPrice();
		}
	}
}
