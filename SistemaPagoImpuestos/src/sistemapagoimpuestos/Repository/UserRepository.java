/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sistemapagoimpuestos.Entity.User;
import sistemapagoimpuestos.Utils.HibernateUtil;

/**
 *
 * @author Markz
 */
public class UserRepository {
    private Session session;
   public void addUser(User user){
      
       try{
        session = HibernateUtil.getSessionFactory().openSession();
        session.save(user);
        session.getTransaction().commit();
        session.close();  
       }catch(Exception e){
           System.out.println(e.getMessage());
           System.out.println("Error al crear el Usuario");
       }
       
   } 
}
