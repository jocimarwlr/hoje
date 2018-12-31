/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

/**
 *
 * @author PC_LENOVO
 */
@Entity
public class ContaCorrente {
    
    
    @Id
    private Integer agencia;
    
    
    @Id
    private Long conta;
    
    
    private Double saldo;

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    
    
    @OneToMany(mappedBy = "contaCorrente",cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "conta_corrente_agencia"),@JoinColumn(name = "conta_corrente_conta")})
    
    List<Lancamento> lancamentos;

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(List<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
    
    
}
