package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.FundDAO;
import model.Model;
import model.CustomerDAO;
import model.TransactionDAO;
import databeans.CustomerBean;
import databeans.FundBean;
import databeans.PositionBean;
import databeans.TransactionBean;
import formbeans.BuyFundForm;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class BuyFundAction extends Action {
    private FormBeanFactory<BuyFundForm> formBeanFactory = FormBeanFactory
            .getInstance(BuyFundForm.class);

    private CustomerDAO customerDAO;
    private TransactionDAO transactionDAO;
    private FundDAO fundDAO;

    public BuyFundAction(Model model) {
        customerDAO = model.getCustomerDAO();
        transactionDAO = model.getTransactionDAO();
        fundDAO = model.getFundDAO();
    }

    public String getName() {
        return "buyfund.do";
    }

    public String perform(HttpServletRequest request) throws RollbackException {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            BuyFundForm form = formBeanFactory.create(request);
            CustomerBean customer = (CustomerBean) request.getSession(false)
                    .getAttribute("customer");
            if (customer == null) {
                return "login.do";
            }
			CustomerBean customerbean = customerDAO.read(customer.getEmail());
            Long cash = customerbean.getCash();
            Double pagebalance = cash.doubleValue();
            request.setAttribute("cash", String.valueOf(pagebalance / 100));

            FundBean[] fundList = fundDAO.getAllFunds();
            request.setAttribute("funds", fundList);

            String symbol = null;
            Long amount = null;
            FundBean fundbean = null;

            if (!form.isPresent()) {
                return "customer_buyfund.jsp";
            }

            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "customer_buyfund.jsp";
            }
            // Any validation errors?

            // request.setAttribute("customer", customerDAO.getCustomers());

            try {
                symbol = form.getSymbol();
                amount = new Double(Double.parseDouble(form.getAmount()) * 100)
                        .longValue();

                fundbean = fundDAO.readBySymbol(symbol);
                if (fundbean == null) {
                    fundbean = fundDAO.readByName(symbol);
                    if (fundbean == null) {
                        errors.add("No fund found! Please check input.");
                        return "customer_buyfund.jsp";
                    }
                }

            } catch (RollbackException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if (amount <= customer.getCash()) {
                Long balance = customer.getCash() - amount;

                TransactionBean buyfund = new TransactionBean();
                buyfund.setFundId(fundbean.getFundId());
                buyfund.setCustomerId(customer.getCustomerId());
                buyfund.setAmount(amount);
                buyfund.setType("buy");

                transactionDAO.create(buyfund);

                customer.setCash(balance);
                customerDAO.setCash(customer.getCustomerId(), balance);

            } else {
                errors.add("Amount must less than cash balance");
                return "customer_buyfund.jsp";
            }
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            request.setAttribute("msg", "You have bought $" + amount / 100
                    + " for " + fundbean.getFundName() + ".");
            cash = customer.getCash();
            pagebalance = cash.doubleValue();
            request.setAttribute("cash", String.valueOf(pagebalance / 100));
            return "customer_buyfund.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}