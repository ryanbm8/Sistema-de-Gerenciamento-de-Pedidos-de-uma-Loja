/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PC
 */
public class Prato extends Produto {
    private String descricao, tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Prato() {
    }

    public Prato(String descricao, String tipo, int codigo, String nome, float preco, Fornecedor fornecedor) {
        super(codigo, nome, preco, fornecedor);
        this.descricao = descricao;
        this.tipo = tipo;
    }
    
    public String toString(){
        return  "\n-----------------------------------" +
                "\nDADOS DO PRATO" + 
                "\nCódigo: " + getCodigo() + 
                "\nNome do prato: " + getNome() + 
                "\nPreço: " + getPreco() + 
                "\nDescrição do prato: " + getDescricao() + 
                "\nTipo: " + getTipo() + 
                getFornecedor();
    }
}
