
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    java.util.List<String> errors = (java.util.List) request.getAttribute("errors");
    if (errors != null && errors.size() > 0) {
        out.println("<h4 style=\"color:red\">");
        for (String error : errors) {
            out.println(error+"<br/>");
        }
        out.println("</h4>");
    }
%>
