/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.HashSet;
import java.util.Set;
import sistemapagoimpuestos.Dto.DtoRole;
import sistemapagoimpuestos.Entity.Role;
import sistemapagoimpuestos.Entity.User;

/**
 *
 * @author Markz
 */
public class LoginExpert {
    
    public DtoRole validateLogin(String username, String password){
        
        //codigo de validacion BD
        
        Role role = new Role("Admin", "Administrador");
        Set<Role> roleList = null;
        roleList.add(role);
        User user = new User( "Marcos", "123456", roleList);
        
            
        
        return null;
    }
}
