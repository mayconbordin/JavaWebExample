<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-jquery-tags" prefix="sj" %>

        <h1>Lista de Ordens</h1>

        <s:if test="status=='success'">
            <s:text name="status.success" />
        </s:if>
        <s:if test="status=='error'">
            <s:text name="status.error" />
        </s:if>

        <s:actionerror />

        <p><s:url id="addURL" action="add" namespace="/ordem" />
           <s:a href="%{addURL}">Adicionar</s:a></p>

        <sj:dialog
            id="successRemove"
            buttons="{
                    'OK':function() { $(this).dialog('close'); }
                    }"
            autoOpen="false"
            modal="true"
            title="Ordem removida!"
        >
        Ordem removida com sucesso!
        </sj:dialog>

        <table border="1">
            <thead>
                <tr>
                    <th><s:text name="label.codigo" /></th>
                    <th><s:text name="label.cliente" /></th>
                    <th><s:text name="label.endereco" /></th>
                    <th><s:text name="label.descricao" /></th>
                    <th><s:text name="label.valorMaoObra" /></th>
                    <th><s:text name="label.valorMaterial" /></th>
                    <th><s:text name="label.total" /></th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
            <s:if test="ordemList.size() > 0">
                <s:iterator value="ordemList" >
                <tr>
                    <td><s:property value="codigo" /></td>
                    <td><s:property value="cliente" /></td>
                    <td><s:property value="endereco" /></td>
                    <td><s:property value="descricao" /></td>
                    <td><s:property value="valorMaoObra" /></td>
                    <td><s:property value="valorMaterial" /></td>
                    <td><s:property value="total" /></td>
                    <td>
                        <s:url id="editURL" action="edit" namespace="/ordem">
                            <s:param name="id" value="%{codigo}"></s:param>
                        </s:url>
                        <s:url id="deleteURL" action="delete" namespace="/ordem">
                            <s:param name="id" value="%{codigo}"></s:param>
                        </s:url>
                        
                        <s:a href="%{editURL}">Editar</s:a>

                        <sj:dialog
                            id="deletar%{codigo}"
                            buttons="{
                                    'Sim':function() {
                                        $.post('%{deleteURL}', function(data) {
                                            $('#deletar%{codigo}').dialog('close');
                                            $('#successRemove').dialog('open');
                                        });
                                     },
                                    'Não':function() { $(this).dialog('close'); }
                                    }"
                            autoOpen="false"
                            modal="true"
                            title="Deletar Ordem"
                        >
                        Deseja deletar a ordem ${codigo}?
                        </sj:dialog>

                        <sj:submit
                            openDialog="deletar%{codigo}"
                            value="Deletar"
                            button="true"
                        />
                    </td>
                </tr>
                </s:iterator>
            </s:if>
            </tbody>
        </table>