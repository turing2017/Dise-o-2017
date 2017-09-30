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
            Endpoint.publish("http://localhost:3030/ws/empresas", new EmpresasWSImpl());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
