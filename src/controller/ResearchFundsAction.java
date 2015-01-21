/* Biqiu Li
   biqiul
   task7
   1-20-2015 */
package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.FundDAO;
import model.Model;
import model.CustomerDAO;
import databeans.CustomerBean;
import databeans.FundBean;
import formbeans.ChangePwdForm;
import formbeans.SearchFundsForm;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class ResearchFundsAction extends Action {
    private FormBeanFactory<SearchFundsForm> formBeanFactory = FormBeanFactory
            .getInstance(SearchFundsForm.class);

    private FundDAO fundDAO;

    public ResearchFundsAction(Model model) {
        fundDAO = model.getFundDAO();
    }

    public String getName() {
        return "research_funds.do";
    }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            SearchFundsForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // If no params were passed, return with no errors so that the form
            // will be
            // presented (we assume for the first time).
            if (!form.isPresent()) {
                return "customer_searchfund.jsp";
            }

            // Any validation errors?
            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "customer_searchfund.jsp";
            }

            FundBean[] funds = null;
            try {
                funds = fundDAO
                        .match(MatchArg.or(
                                MatchArg.containsIgnoreCase("fundName",
                                        form.getfundKeyWord()),
                                MatchArg.containsIgnoreCase("symbol",
                                        form.getfundKeyWord())));
            } catch (RollbackException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            

            request.setAttribute("searchedfunds",funds);
            return "search_result.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
