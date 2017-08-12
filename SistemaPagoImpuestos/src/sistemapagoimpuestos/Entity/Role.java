/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;


import sistemapagoimpuestos.Entity.Entity;
/**
 *
 * @author Markz
 */
public class Role extends Entity{

    private int id;
    private String rolename;    
    private String description;

    public Role() {
    }

    public Role( String rolename, String description) {
        this.rolename = rolename;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    
    
    
}
