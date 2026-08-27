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
public class Sobremesa extends Produto {
    private String sabor;
    private float peso;

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Sobremesa(String sabor, float peso, int codigo, String nome, float preco, Fornecedor fornecedor) {
        super(codigo, nome, preco, fornecedor);
        this.sabor = sabor;
        this.peso = peso;
    }

    public Sobremesa() {
    }
    
    public String toString(){
        return  "\n-----------------------------------" +
                "\nDADOS DA SOBREMESA" + 
                "\nCódigo: " + getCodigo() + 
                "\nNome do prato: " + getNome() + 
                "\nPreço: " + getPreco() + 
                "\nSabor: " + getSabor() + 
                "\nPeso: " + getPeso() + 
                getFornecedor();
    }
}
