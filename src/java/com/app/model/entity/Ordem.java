package com.app.model.entity;

import com.app.util.validator.constraints.NotNull;
import com.app.util.validator.constraints.XSSFilter;
import java.io.Serializable;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author maycon
 */
public class Ordem implements Serializable {
    private int codigo;
    private String cliente;
    private String endereco;
    private String descricao;
    private double valorMaoObra;
    private double valorMaterial;
    private double total;

    /**
     * @return the cliente
     */
    @NotNull
    @XSSFilter
    @Length(max = 80)
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the endereco
     */
    @NotNull
    @Length(max = 100)
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the descricao
     */
    @NotNull
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valorMaoObra
     */
    @NotNull
    public double getValorMaoObra() {
        return valorMaoObra;
    }

    /**
     * @param valorMaoObra the valorMaoObra to set
     */
    public void setValorMaoObra(double valorMaoObra) {
        this.valorMaoObra = valorMaoObra;
    }

    /**
     * @return the valorMaterial
     */
    @NotNull
    public double getValorMaterial() {
        return valorMaterial;
    }

    /**
     * @param valorMaterial the valorMaterial to set
     */
    public void setValorMaterial(double valorMaterial) {
        this.valorMaterial = valorMaterial;
    }

    /**
     * @return the total
     */
    @NotNull
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public void calcularTotal() {
        setTotal( getValorMaoObra() + getValorMaterial() );
    }

    /**
     * @return the codigo
     */
    @NotNull
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}