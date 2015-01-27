
package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SearchFundsForm extends FormBean{
    private String fundKeyWord;
    
    public void setfundKeyWord(String s)    { fundKeyWord    = trimAndConvert(s,"<>\"");                 }

    public String getfundKeyWord()    { return fundKeyWord;    }


    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (fundKeyWord == null || fundKeyWord.length() == 0)
            errors.add("Fund name or ticker or id is required");

        if (errors.size() > 0)
            return errors;
        if (fundKeyWord.matches(".*[<>\"].*"))
            errors.add("Fund name/ticker may not contain angle brackets or quotes");

        return errors;
    }
}
