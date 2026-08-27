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
public class Entregador extends Pessoa {
    private int matricula;
    private String veiculo;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Entregador(int matricula, String veiculo) {
        this.matricula = matricula;
        this.veiculo = veiculo;
    }

    public Entregador() {
    }
    
    public String toString(){
        return "\n-----------------------------------"+
                "\nDADOS DO ENTREGADOR" +
                "\nNome: " + getNome()+
                "\nEndereço: " + getEndereco() + 
                "\nTelefone: " + getTelefone() + 
                "\nE-mail: " + getEmail()+
                "\nMatricula: " + getMatricula() + 
                "\nVeículo: " + getVeiculo();
    }
}
