
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.genericdao.RollbackException;

import databeans.CustomerBean;
import model.CustomerDAO;
import model.Model;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		Model model = new Model(getServletConfig());
		//create sample customer
//		try {
//			createsample(model);
//		} catch (RollbackException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Action.add(new LoginAction(model));
		Action.add(new LogoutAction(model));
		//Action.add(new ManageAction(model));
		Action.add(new BuyFundAction(model));
		Action.add(new CustomerChangePwdAction(model));
		Action.add(new RequestCheckAction(model));
		Action.add(new ResearchFundsAction(model));
		Action.add(new ViewAccountAction(model));
		Action.add(new ViewHistoryAction(model));
		Action.add(new SellFundAction(model));

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = null;
		try {
			nextPage = performTheAction(request);
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendToNextPage(nextPage, request, response);
	}

	/*
	 * Extracts the requested action and (depending on whether the user is
	 * logged in) perform it (or make the user login).
	 * 
	 * @param request
	 * 
	 * @return the next page (the view)
	 */
	private String performTheAction(HttpServletRequest request) throws RollbackException {
		HttpSession session = request.getSession(true);
		String servletPath = request.getServletPath();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		String action = getActionName(servletPath);

		if (customer == null && action.equals("manage.do")) {
			// If the user hasn't logged in, so login is the only option
			return Action.perform("login.do", request);
		}

		if (action.equals("welcome")) {
			// User is logged in, but at the root of our web app
			return Action.perform("manage.do", request);
		}

		// Let the logged in user run his chosen action
		return Action.perform(action, request);
	}

	/*
	 * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
	 * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
	 * page (the view) This is the common case
	 */
	private void sendToNextPage(String nextPage, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND,
					request.getServletPath());
			return;
		}

		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
		}

		if (nextPage.endsWith(".jsp")) {
			RequestDispatcher d = request.getRequestDispatcher("WEB-INF/"
					+ nextPage);
			d.forward(request, response);
			return;
		}

		if (!nextPage.isEmpty()) {
			if (nextPage.startsWith("http://")) {
				response.sendRedirect(nextPage);
			} else {
				response.sendRedirect("http://" + nextPage);
			}
			return;
		}

		throw new ServletException(Controller.class.getName()
				+ ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
	}

	/*
	 * Returns the path component after the last slash removing any "extension"
	 * if present.
	 */
	private String getActionName(String path) {
		// We're guaranteed that the path will start with a slash
		int slash = path.lastIndexOf('/');
		return path.substring(slash + 1);
	}
	
	private void createsample(Model model) throws RollbackException {
		CustomerDAO customerDAO;

		customerDAO = model.getCustomerDAO();
		for (int i = 1; i < 2; i++) {
			
			CustomerBean userbean = new CustomerBean();
			userbean.setEmail("user" + i+"@gmail.com");
			userbean.setFirstName("Firstname" + i + "");
			userbean.setLastName("Lastname" + i + "");
			userbean.setPassword("user" + i);
			userbean.setCash(50000);
			userbean.setAddrLine1("5939 fifth");
			userbean.setAddrLine2("Ave");
			userbean.setCity("Pitt");
			userbean.setZip("15232");

			CustomerBean userck = customerDAO.read("sample" + i);

			if (userck != null) {
			} else {
				customerDAO.create(userbean);
			}
		}

	}
	
}
