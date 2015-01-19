package databeans;

import java.sql.Date;
import org.genericdao.PrimaryKey;

@PrimaryKey("fundId, date")
public class PriceBean {

	private int  fundId;
	private long price;
	private Date date;

		public int    getFundID()   { return fundId;}
		public long   getPrice()   	{ return price; }
		public Date   getDate()     { return date;  }

		public void setFundId(int i) 	{ fundId = i; }
		public void setPrice(long l) 	{ price  = l; }
	    public void setDate(Date d) 	{ date   = d; }
}
