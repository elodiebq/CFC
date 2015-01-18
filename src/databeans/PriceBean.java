package databeans;

import java.sql.Date;
import org.genericdao.PrimaryKey;

@PrimaryKey("fundId")
public class PriceBean {

	private int fundId;
	private double price;
	private Date date;

		public int    getFundID()   { return fundId;}
		public double getPrice()   	{ return price; }
		public Date   getDate()     { return date;  }

		public void setFundId(int i) 	{ fundId = i; }
		public void setPrice(double d) 	{ price  = d; }
	    public void setDate(Date d) 	{ date   = d; }
}
