/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entity.Claro;
import Entity.Dgr;
import com.sun.net.httpserver.HttpServer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;
import ws.*;
import javax.xml.ws.*;
import ws.wsImpl.ClaroWSImpl;
import ws.wsImpl.DgrWSImpl;
import ws.wsImpl.EmpresasWSImpl;

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
            
            
            //DgrWSImpl dgrWSImpl = new DgrWSImpl();
            //claroWSImpl.create(new Claro("test", "test", 2.3, 1.2, "test", 1, new Date()));
            //List<Dgr> c = dgrWSImpl.findAll();
            //System.out.println(c);
            //Endpoint.publish("http://localhost:3030/ws/dgr", new DgrWSImpl());
            //Endpoint.publish("http://localhost:3030/ws/claro", new ClaroWSImpl());       
            Endpoint.publish("http://localhost:3030/ws/empresas", new EmpresasWSImpl());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
