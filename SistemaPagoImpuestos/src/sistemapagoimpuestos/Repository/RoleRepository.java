/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import sistemapagoimpuestos.Dto.DtoRole;
import sistemapagoimpuestos.Entity.Role;
import sistemapagoimpuestos.Utils.HibernateUtil;

/**
 *
 * @author Markz
 */
public class RoleRepository {

    private Session session;
   public void addRole(Role role){
      
       try{
        session = HibernateUtil.getSessionFactory().openSession();
        session.save(role);//persisting the object  
        session.getTransaction().commit();
        session.close();  
       }catch(Exception e){
           System.out.println("Error al crear el Rol");
       }
       
   } 

    public Role findRole(int id){
        Role role = new Role();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
             role = (Role) session.get(Role.class, id);
        }catch(Exception e){
            System.out.println("Rol no encontrado");
        }finally{
        }
        return role;
    }
}
