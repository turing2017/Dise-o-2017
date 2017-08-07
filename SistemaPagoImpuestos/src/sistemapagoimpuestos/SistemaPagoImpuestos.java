/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos;

import sistemapagoimpuestos.View.Login;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration; 
import sistemapagoimpuestos.Entity.Role;
/**
 *
 * @author Markz
 */
public class SistemaPagoImpuestos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
  
 Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating seession factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
   /*         
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    Role role=new Role();  
    role.setRolename("Test");  
    role.setDescription("Test descro");  
      
    session.persist(role);//persisting the object  
      
    t.commit();//transaction is commited  
    session.close();  
     */ 
    System.out.println("successfully saved");  
        
        
        
        Login l = new Login();
        l.setSize ( 500, 300 );
        l.setLocationRelativeTo ( null );
        l.setVisible(true);
    }
    
}
