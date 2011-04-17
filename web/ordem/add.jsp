<%@taglib uri="/struts-tags" prefix="s"%>

        <h1>Adicionar Ordem</h1>

        <div>
            <s:form action="add" namespace="/ordem">
                <s:include value="form.jsp" />
            </s:form>
        </div>