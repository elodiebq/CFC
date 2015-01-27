package databeans;
import org.genericdao.PrimaryKey;
import java.sql.Date;
@PrimaryKey("transactionId")
public class TransactionBean {
		private int transactionId;
		private int fundId;
		private int customerId;
		private long share;
		private long amout;
		private Date date;
		private String type;

		public int     getTransactionId() { return transactionId; }
		public int     getFundId()   	  { return fundId;        }
		public int     getCustomerId()    { return customerId;    }
		public long     getShare()   	  { return share;		  }
		public long    getAmount()        { return amout;		  }
		public Date     getDate()          { return date;          }
		public String  getType()          { return type;          }

		public void setTransactionId(int i)   { transactionId = i; }
		public void setFundId(int i)	      {	fundId        = i; }
		public void setCustomerId(int i) 	  {	customerId    = i; }
		public void setShare(long i) 	      {	share         = i; }
		public void setAmount(long l)		  { amout         = l; }
		public void setDate(Date i) 		  {	date          = i; }
	    public void setType(String s) 	      {	type          = s; }
}
