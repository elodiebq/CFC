package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("fundId")
public class FundBean {	
		private int fundId;
		private String fundName;
		private String symbol;

		public int    getFundID()   	{ return fundId;}
		public String getFirstName()    { return fundName; }
		public String getLastName()     { return symbol;  }

		public void setCustomerId(int i) 	  {	fundId   = i; }
		public void setEmail(String s) 		  {	fundName = s; }
	    public void setFirstName(String s) 	  {	symbol   = s; }
	}

