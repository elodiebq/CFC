/*
Jike Li
Andrew ID:jikel
08-600
Homework #9
Date: Nov. 29, 2014
 */
package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class BuyFundForm extends FormBean {
	private String symbol;
	private String amount;
	
	public String getSymbol() { return symbol; }
	public String getAmount()     { return amount;     }
	
	public void setSymbol(String s) { symbol = s.trim(); }
	public void setAmount(String s)     { amount     = s.trim(); }

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (symbol == null || symbol.length() == 0)
			errors.add("Symbol is required");
		if (amount == null || amount.length() == 0)
			errors.add("Amount is required");

		if (amount.trim().length() != 0) {
			try {
				double amountcheck = Double.parseDouble(amount.trim());
			} catch (Exception e) {
				errors.add("Amount should be a number");
			}
		}
		return errors;
	}
	
}

