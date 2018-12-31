/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import model.entity.ContaCorrente;
import model.entity.Lancamento;

/**
 *
 * @author PC_LENOVO
 */
public class OperacoesBancarias {
    
    
    public ContaCorrente atualizarSaldo(ContaCorrente c){
         Double saldo = c.getSaldo() ;
       for(Lancamento lancamento: c.getLancamentos()){
            saldo  +=  lancamento.getValorLancamento();
           c.setSaldo(saldo);
          
       }
        
        
        return c;
    }
    
    
}
