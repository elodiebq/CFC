package databeans;
import org.genericdao.PrimaryKey;

@PrimaryKey("transactionId")
public class TransactionBean {
		private int transactionId;
		private int fundId;
		private int customerId;
		private int share;
		private long amout;
		private int date;
		private boolean type;

		public int     getTransactionId() { return transactionId; }
		public int     getFundId()   	  { return fundId;        }
		public int     getCustomerId()    { return customerId;    }
		public int     getShare()   	  { return share;		  }
		public long  getAmount()          { return amout;		  }
		public int     getDate()          { return date;          }
		public boolean isBuy()            { return type;          }

		public void setTransacitonId(int i)   { transactionId = i; }
		public void setFundId(int i)	      {	fundId        = i; }
		public void setCustomerId(int i) 	  {	customerId    = i; }
		public void setShare(int i) 	      {	share         = i; }
		public void setAmount(long l)		  { amout         = l; }
		public void setDate(int i) 		  	  {	date          = i; }
	    public void setType(boolean b) 	      {	type          = b; }
}
