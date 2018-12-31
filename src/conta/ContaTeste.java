
import dao.ContaCorrenteDAO;
import java.util.ArrayList;
import java.util.List;
import model.entity.ContaCorrente;
import model.entity.Lancamento;
import model.model.OperacoesBancarias;
import util.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC_LENOVO
 */
public class ContaTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        List<ContaCorrente> listaDeConta = new ArrayList<>();
        List<Lancamento> listaLancamento = new ArrayList<>();
        OperacoesBancarias operacao = new OperacoesBancarias();
        Lancamento lancamento1 = new Lancamento();
        Lancamento lancamento2 = new Lancamento();
        ContaCorrenteDAO contaDAO  = new ContaCorrenteDAO();
        ContaCorrente  contaCorrente = new ContaCorrente();
        
        contaCorrente.setAgencia(3848);
        contaCorrente.setConta(Long.parseLong("215295"));
        listaDeConta=contaDAO.buscarPorParametro(contaCorrente);
       
        
        
        if(listaDeConta.size()>0){
        for(ContaCorrente conta: listaDeConta){
              contaCorrente.setSaldo(conta.getSaldo());
        }
        } else{
                  
            contaCorrente.setSaldo(0.00);

        }
        
        lancamento1.setTipoLancamento("credito");
        lancamento1.setValorLancamento(2.00);
        lancamento1.setData(Utils.getDataAtualFormatoMysql());
        lancamento1.setDocumento("fff78787fr");
        lancamento1.setContaCorrente(contaCorrente);
        listaLancamento.add(lancamento1);
        
        
        lancamento2.setTipoLancamento("debito");
        lancamento2.setValorLancamento(36.00);
        lancamento2.setDocumento("fgg5454");
        lancamento2.setData(Utils.getDataAtualFormatoMysql());
        lancamento2.setContaCorrente(contaCorrente);
        listaLancamento.add(lancamento2);
        
        contaCorrente.setLancamentos(listaLancamento);
        
        
        operacao.atualizarSaldo(contaCorrente);
        
        contaDAO.salvar(contaCorrente);
        
        
        
        
        
        
       
        
        
        
        
        
    }
    
}
