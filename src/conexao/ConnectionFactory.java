/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC_LENOVO
 */
public class ConnectionFactory {
    
    private static final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    
    public  EntityManager  conectar(){
        
    return  emf.createEntityManager();
        
    }
    
  
    
}
