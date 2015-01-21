package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Model;
import model.CustomerDAO;
import databeans.CustomerBean;
import formbeans.ChangePwdForm;
import formbeans.LoginForm;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

public class CustomerChangePwdAction extends Action{
    private FormBeanFactory<ChangePwdForm> formBeanFactory = FormBeanFactory.getInstance(ChangePwdForm.class);

    private CustomerDAO customerDAO;

    public CustomerChangePwdAction(Model model) {
        customerDAO = model.getCustomerDAO();
    }

    public String getName() {
        return "customer_change_pwd.do";
    }

    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);

        try {
            ChangePwdForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // If no params were passed, return with no errors so that the form
            // will be
            // presented (we assume for the first time).
            if (!form.isPresent()) {
                return "customer_changepassword.jsp";
            }

            // Any validation errors?
            errors.addAll(form.getValidationErrors());
            if (errors.size() != 0) {
                return "customer_changepassword.jsp";
            }

            // Look up the user
            CustomerBean customer =  (CustomerBean)request.getSession().getAttribute("user");
        

            if (customer == null) {
                errors.add("You have to login first.");
                return "customer_login.jsp";
            }

            // Check the password
         
            if (!(customer.getPassword().equals(form.getOldPassword()))) {
                errors.add("Incorrect password");
                return "customer_changepassword.jsp";
            }
            
            try {
                customerDAO.setPassword(customer.getEmail(),form.getNewPassword());
            } catch (RollbackException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // Attach (this copy of) the user bean to the session
            
            request.setAttribute("message","Password changed for "+customer.getFirstName()+" "+customer.getLastName());
            return "success.jsp";
        } catch (FormBeanException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}

