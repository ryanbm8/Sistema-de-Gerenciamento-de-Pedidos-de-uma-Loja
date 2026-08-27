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
public class Fornecedor {
    private String nome, cnpj;
    private int numeroContrato;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    

    public Fornecedor(String nome, String cnpj, int numeroContrato) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.numeroContrato = numeroContrato;
    }

    public Fornecedor() {
    }
    
    public String toString(){
        return "\n------------------------------------"
                + "\nDADOS DO FORNECEDOR"
                + "\nNome: " + getNome() +
                "\nCNPJ: " + getCnpj() + 
                "\nNúmero Contrato: " + getNumeroContrato();
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }
}
