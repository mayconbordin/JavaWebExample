<%@taglib uri="/struts-tags" prefix="s"%>

        <h1>Editando Ordem ${id}</h1>

        <div>
            <s:form action="edit" namespace="/ordem">
                <s:include value="form.jsp" />
            </s:form>
        </div>