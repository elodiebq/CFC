package formbeans;

public class TransactionRecordForm {
	
	private String fundName;
	private String share;
	private String lastPrice;
	private String originalPrice;
	
	public void setFundName(String s)		{ fundName      = s; }
	public void setShare(String s) 			{ share         = s; }
	public void setLastPrice(String s) 		{ lastPrice     = s; }
	public void setOriginalPrice(String s) 	{ originalPrice = s; }
	
	public String getFundName() 	 { return fundName;      }
	public String getShare() 		 { return share;         }
	public String getLastPrice()     { return lastPrice;     }
	public String getOriginalPrice() { return originalPrice; }

}
