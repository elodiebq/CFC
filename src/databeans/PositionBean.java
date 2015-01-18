package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("customerId, fundId")
public class PositionBean {
	private int fundId;
	private int customerId;
	private double share;
	
	public int getFundId() 	   { return fundId;     }
	public int getCustomerId() { return customerId; }
	public double getShare()   { return share;      }
	
	public void setFundId(int i)     { fundId      = i; }
	public void setCustomerId(int i) { customerId  = i; }
	public void setShare(double d)   { share       = d; }
 
}
