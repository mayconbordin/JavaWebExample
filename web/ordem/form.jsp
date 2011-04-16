<%@taglib uri="/struts-tags" prefix="s"%>

            <s:actionerror />
            <s:push value="ordem">
                <s:hidden name="codigo" />
                <p>
                    <s:label key="label.cliente" />
                    <s:textfield name="cliente" />
                    <s:fielderror fieldName="cliente" />
                </p>
                <p>
                    <s:label key="label.endereco" />
                    <s:textfield name="endereco" />
                    <s:fielderror fieldName="endereco" />
                </p>
                <p>
                    <s:label key="label.descricao" />
                    <s:textarea name="descricao" />
                    <s:fielderror fieldName="descricao" />
                </p>
                <p>
                    <s:label key="label.valorMaoObra" />
                    <s:textfield name="valorMaoObra" />
                    <s:fielderror fieldName="valorMaoObra" />
                </p>
                <p>
                    <s:label key="label.valorMaterial" />
                    <s:textfield name="valorMaterial" />
                    <s:fielderror fieldName="valorMaterial" />
                </p>
                <p>
                    <s:hidden name="save" value="true" />
                    <s:submit key="label.salvar" name="" />
                </p>
            </s:push>