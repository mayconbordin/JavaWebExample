<%-- 
    Document   : edit
    Created on : Apr 6, 2011, 2:32:03 PM
    Author     : maycon
--%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editando Ordem ${id}</h1>

        <div>
            <s:form action="edit" namespace="/ordem">
                <s:include value="form.jsp" />
            </s:form>
        </div>
    </body>
</html>
