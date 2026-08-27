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
public class Pedido {
    private int codigo;
    private String data, status;
    private float total;
    private Entregador entregador;
    private Cliente cliente;
    private Prato prato;
    private Bebida bebida;
    private Sobremesa sobremesa;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Sobremesa getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(Sobremesa sobremesa) {
        this.sobremesa = sobremesa;
    }

    public Pedido() {
    }

    public Pedido(int codigo, String data, String status, float total, Entregador entregador, Cliente cliente, Prato prato, Bebida bebida, Sobremesa sobremesa) {
        this.codigo = codigo;
        this.data = data;
        this.status = status;
        this.total = total;
        this.entregador = entregador;
        this.cliente = cliente;
        this.prato = prato;
        this.bebida = bebida;
        this.sobremesa = sobremesa;
    }

    @Override
    public String toString() {
        return    "\nDADOS DO PEDIDO"
                + "\nCodigo: " + getCodigo()  
                + "\nData: " + getData()
                + "\nStatus: " + getStatus() 
                + "\nTotal: " + getTotal() 
                + getEntregador() + 
                getCliente() +
                getPrato() + getBebida() + getSobremesa();
    }
    
    
}
