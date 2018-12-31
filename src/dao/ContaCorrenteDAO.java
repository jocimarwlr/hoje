/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.entity.ContaCorrente;


/**
 *
 * @author PC_LENOVO
 */
public class ContaCorrenteDAO {
    
    public  ContaCorrente  salvar(ContaCorrente c){
        
        EntityManager em  = new  ConnectionFactory().conectar();
          em.getTransaction().begin();
        try{
            
            if(c.getAgencia() == null){
                em.persist(c);
  
            } else {
                em.merge(c);
            }
            
            
        
          em.getTransaction().commit();
            
        }catch(Exception e){
            System.err.println("");
            em.getTransaction().rollback();
        }finally{
            
            em.close();
        }
        
        
        
        
        return c;
        
            
        
        
    }
    
    
    
     public List<ContaCorrente> buscarTodos(){
        EntityManager em = new ConnectionFactory().conectar();
        
        List<ContaCorrente>  listaConta = new ArrayList<>();
        
        try{
          listaConta = em.createQuery("from ContaCorrente c").getResultList();
            
            
            
            
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
        em.close();
        }
       
        return  listaConta;
        
    }
    
     
      public List<ContaCorrente> buscarPorParametro(ContaCorrente c){
        EntityManager em = new ConnectionFactory().conectar();
        
        List<ContaCorrente>  listaConta = new ArrayList<>();
        
        try{
          listaConta = em.createQuery("from ContaCorrente c  WHERE  c.conta=  "+ c.getConta() + " AND c.agencia=" + c.getAgencia()).getResultList();
            
            
            
            
            
        }catch(Exception ex){
            System.err.println(ex);
        }finally{
        em.close();
        }
       
        return  listaConta;
        
    }
    
    
    
    
}
