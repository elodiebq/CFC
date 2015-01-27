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

public class RequestCheckForm extends FormBean {
	private String amount;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String s) {
		amount = s.trim();
	}

	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (amount == null || amount.length() == 0) {
			errors.add("Please enter an amount");
		}

		if (amount.length() != 0) {
			try {
				double amountcheck = Double.parseDouble(amount.trim());
			} catch (Exception e) {
				errors.add("Amount must be a number");
			}
		}

		return errors;
	}
}
