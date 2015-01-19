package databeans;

import org.genericdao.PrimaryKey;

@PrimaryKey("fundId")
public class FundBean {	
		private int fundId;
		private String fundName;
		private String symbol;

		public int    getFundId()   { return fundId;   }
		public String getFundName() { return fundName; }
		public String getSymbol()   { return symbol;   }

		public void setFundId(int i) 	  {	fundId   = i; }
		public void setFundName(String s) {	fundName = s; }
	    public void setSymbol(String s)   {	symbol   = s; }
	}

