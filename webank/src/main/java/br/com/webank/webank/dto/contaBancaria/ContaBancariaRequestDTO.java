package br.com.webank.webank.dto.contaBancaria;


public class ContaBancariaRequestDTO {
    private String agencia;
    private String numero; 
    private double saldo;
    private Long idTitular;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Long getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(Long idTitular) {
        this.idTitular = idTitular;
    }    
}
