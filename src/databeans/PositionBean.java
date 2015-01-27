package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("customerId,fundId")
public class PositionBean {
	private int fundId;
	private int customerId;
	private long share;
	private long originalPrice;
	
	public int getFundId() 	   { return fundId;     }
	public int getCustomerId() { return customerId; }
	public long getShare()     { return share;      }
	public long getOriginalPrice()     { return originalPrice;  }
	
	public void setFundId(int i)     { fundId      = i; }
	public void setCustomerId(int i) { customerId  = i; }
	public void setShare(long l)     { share       = l; }
	public void setOriginalPrice(long l)     { originalPrice       = l; }
	 
 
}
