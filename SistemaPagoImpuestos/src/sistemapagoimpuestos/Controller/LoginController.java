/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import javax.swing.JTextField;
import sistemapagoimpuestos.Dto.DtoRole;
import sistemapagoimpuestos.Entity.Role;
import sistemapagoimpuestos.Expert.LoginExpert;
import sistemapagoimpuestos.Repository.RoleRepository;


/**
 *
 * @author Markz
 */
public class LoginController {
    private LoginExpert loginExpert;
    public DtoRole validateLogin(String username, String password){
        //loginExpert.validateLogin(username, password);
        RoleRepository roleRepository = new RoleRepository();
        roleRepository.addRole(new Role(username, password));
        System.out.println("guardado");
        System.out.println(roleRepository.findRole(2));
        System.out.println(username+ " " + password);
        return null;
//       return new LoginExpert().validateLogin(username, password);
    }
    
}
