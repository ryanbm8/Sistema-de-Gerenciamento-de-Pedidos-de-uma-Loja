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
public class Bebida extends Produto {
    private int volume;
    private String alcoolica;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(String alcoolica) {
        this.alcoolica = alcoolica;
    }

    public Bebida() {
    }

    public Bebida(int volume, String alcoolica, int codigo, String nome, float preco, Fornecedor fornecedor) {
        super(codigo, nome, preco, fornecedor);
        this.volume = volume;
        this.alcoolica = alcoolica;
    }
    
    public String toString(){
        return "\n---------------------------------" +
                "\nBEBIDA" +
                "\nCódigo: " + getCodigo() +
                "\nNome: " + getNome() + 
                "\nPreço: R$" + getPreco()+
                "\nVolume: " + getVolume() +
                "\nA bebida é alcoólica ? " + getAlcoolica() + 
                getFornecedor();
    }
}
