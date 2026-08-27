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
public class Cliente extends Pessoa {
    private String cpf;
    private String dataCadastro;
    private int idade;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cliente(String cpf, String dataCadastro) {
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }

    public Cliente() {
    }
    
    public String toString(){
        return  "\n-----------------------------------"+
                "\nDADOS DO CLIENTE" +
                "\nMNome: " + getNome()+
                "\nEndereço: " + getEndereco() + 
                "\nIdade: " + getIdade() +
                "\nTelefone: " + getTelefone() + 
                "\nE-mail: " + getEmail()+
                "\nCPF: " + getCpf() + 
                "\nCadastrado no sistema desde: " + getDataCadastro();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
