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
import model.PriceDAO;
import databeans.FundBean;
import databeans.PriceBean;
import formbeans.SearchFundsForm;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class ResearchFundsAction extends Action {
    private FormBeanFactory<SearchFundsForm> formBeanFactory = FormBeanFactory
            .getInstance(SearchFundsForm.class);

    private FundDAO fundDAO;
    private PriceDAO priceDAO;

    public ResearchFundsAction(Model model) {
        fundDAO = model.getFundDAO();
        priceDAO = model.getPriceDAO();
    }

    public String getName() {
        return "research_funds.do";
    }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            SearchFundsForm form = formBeanFactory.create(request);

            int fundid = 0;
            FundBean[] funds = null;
            FundBean fund0 = null;
            PriceBean[] prices = null;
            // If no params were passed, return with no errors so that the form
            // will be
            // presented (we assume for the first time).
            if (!form.isPresent()) {
                if (request.getParameter("fundId") == null)
                    fundid = 1;
                else
                    fundid = Integer.parseInt(request.getParameter("fundId"));
                try {
                    funds = fundDAO.match();
                } catch (RollbackException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    fund0 = fundDAO.read(fundid);
                    prices = priceDAO.match(MatchArg.equals("fundId", fund0.getFundId()));

                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (RollbackException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                // Any validation errors?
                errors.addAll(form.getValidationErrors());
                if (errors.size() != 0) {
                    return "customer_searchfund.jsp";
                }

                try {
                    funds = fundDAO.match(MatchArg.or(
                            MatchArg.containsIgnoreCase("fundName",
                                    form.getfundKeyWord()),
                            MatchArg.containsIgnoreCase("symbol",
                                    form.getfundKeyWord())));
                } catch (RollbackException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if (funds.length > 0) {
                    try {
                        fund0 = fundDAO.read(funds[0].getFundId());
                        prices = priceDAO.match(MatchArg.equals("fundId", fund0.getFundId()));
                    } catch (RollbackException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }

            request.setAttribute("funds", funds);
            request.setAttribute("fund0", fund0);
            request.setAttribute("prices", prices);
            return "customer_searchfund.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
