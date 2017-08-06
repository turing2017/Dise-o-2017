/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import sistemapagoimpuestos.Dto.DtoRole;
import sistemapagoimpuestos.Expert.LoginExpert;


/**
 *
 * @author Markz
 */
public class LoginController {
    
    public DtoRole validateLogin(String username, String password){
       return new LoginExpert().validateLogin(username, password);
    }
    
}
