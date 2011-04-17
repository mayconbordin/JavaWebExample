<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<div style="margin: 50px;text-align: center; font-size:18pt;">
    <s:url id="ordemIndex" action="index" namespace="/ordem"></s:url>
    <s:a href="%{ordemIndex}">Ordens de Serviço</s:a>
</div>

<s:url id="ajax" action="index" namespace="/userinfo"/>
<sj:dialog id="myremotedialog" href="%{ajax}" title="Informações do Usuário" />