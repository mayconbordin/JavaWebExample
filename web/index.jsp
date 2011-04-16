<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib uri="http://htmlcompressor.googlecode.com/taglib/compressor" prefix="compress" %>
<compress:html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <sj:head/>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div style="text-align: center">
            <s:url id="ordemIndex" action="index" namespace="/ordem"></s:url>
            <s:a href="%{ordemIndex}">Formulário</s:a>
        </div>

        <s:url id="ajax" action="index" namespace="/userinfo"/>
        <sj:dialog id="myremotedialog" href="%{ajax}" title="User info" />
    </body>
</html>
</compress:html>