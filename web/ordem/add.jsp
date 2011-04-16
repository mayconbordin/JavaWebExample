<%-- 
    Document   : new
    Created on : Apr 6, 2011, 10:09:29 PM
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
        <h1>Adicionar Ordem</h1>

        <div>
            <s:form action="add" namespace="/ordem">
                <s:include value="form.jsp" />
            </s:form>
        </div>
    </body>
</html>
