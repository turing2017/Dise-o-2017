/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entity.Claro;
import java.util.Date;
import java.util.List;
import ws.*;
import javax.xml.ws.*;
import ws.wsImpl.ClaroWSImpl;

/**
 *
 * @author mviss
 */
public class AppPIWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //ClaroWSImpl claroWSImpl = new ClaroWSImpl();
            //claroWSImpl.create(new Claro("test", "test", 2.3, 1.2, "test", 1, new Date()));
            //List<Claro> c = claroWSImpl.buscarComprobantesCodigo("test");
            //System.out.println(c);
            Endpoint.publish("http://localhost:3030/ws/claro", new ClaroWSImpl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
