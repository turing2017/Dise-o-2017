/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPrueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Cliente;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoDatoItem;
import sistemapagoimpuestos.Entity.TipoEmpresa;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaInterna;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Markz
 */
public class DatosPrueba {
    public static void generarDatosPrueba(){
        
        FachadaInterna.getInstance().iniciarTransaccion();
        generarTipoUsuario();
        FachadaInterna.getInstance().finalizarTransaccion();
        
        FachadaInterna.getInstance().iniciarTransaccion();
        generarCliente();
        FachadaInterna.getInstance().finalizarTransaccion();
        
        FachadaInterna.getInstance().iniciarTransaccion();
        generarTipoEmpresa();
        FachadaInterna.getInstance().finalizarTransaccion();
        FachadaInterna.getInstance().iniciarTransaccion();
        generarEmpresa();
        FachadaInterna.getInstance().finalizarTransaccion();
        
        FachadaInterna.getInstance().iniciarTransaccion();
        generarUsuario();
        FachadaInterna.getInstance().finalizarTransaccion();
        
        FachadaInterna.getInstance().iniciarTransaccion();
        generarTipoDatoItem();
        FachadaInterna.getInstance().finalizarTransaccion();
        FachadaInterna.getInstance().iniciarTransaccion();
        generarTipoImpuesto();
        FachadaInterna.getInstance().finalizarTransaccion();
        FachadaInterna.getInstance().iniciarTransaccion();
        generarEmpresaTipoImpuesto();
        FachadaInterna.getInstance().finalizarTransaccion();
        FachadaInterna.getInstance().iniciarTransaccion();
        generarItem();
        FachadaInterna.getInstance().finalizarTransaccion();
        FachadaInterna.getInstance().iniciarTransaccion();
        generarItemEmpresaTipoImpuesto();
        FachadaInterna.getInstance().finalizarTransaccion();
    }
    
    public static void generarTipoDatoItem(){
        TipoDatoItem  tipoDatoItem1 =new TipoDatoItem(1, "Expensas");
        TipoDatoItem  tipoDatoItem2 =new TipoDatoItem(2, "comisiones");
        TipoDatoItem  tipoDatoItem3 =new TipoDatoItem(3, "recargo");
        FachadaPersistencia.getInstance().guardar(tipoDatoItem1);
        FachadaPersistencia.getInstance().guardar(tipoDatoItem2);
        FachadaPersistencia.getInstance().guardar(tipoDatoItem3);

        System.out.println("Guardado: Tipo Dato Item");

    }
    
    public static void generarEmpresaTipoImpuesto(){
        List<Object> listEmpresaObject = FachadaPersistencia.getInstance().buscar("Empresa", null);
        Object tipoImpuestoObject =  FachadaPersistencia.getInstance().buscar("TipoImpuesto", null).get(0);
        Object tipoEmpresaObject =  FachadaPersistencia.getInstance().buscar("TipoEmpresa", null).get(0);

        int couter = 0;

        for(Object empresaObject : listEmpresaObject){
            Empresa empresa = (Empresa)empresaObject;
            TipoEmpresa tipoEmpresa = (TipoEmpresa) tipoEmpresaObject;
            TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestoObject;
            if(couter > 0){
                EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto(new Date(), null, 2, tipoImpuesto, empresa, tipoEmpresa);
                FachadaPersistencia.getInstance().guardar(empresaTipoImpuesto);
                break;
            }
            
            EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto(new Date(), null, 2, tipoImpuesto, empresa, tipoEmpresa);
                FachadaPersistencia.getInstance().guardar(empresaTipoImpuesto);
            couter++ ;
        }

        
        
    }
    public static void generarUsuario(){
        List<DTOCriterio> criterios = new ArrayList<>();
        criterios.add(new DTOCriterio("nombreTipoUsuario", "=", "Empresa"));
        TipoUsuario tipoUsuarioEmpresa =  (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
        criterios.clear();
        
        criterios.add(new DTOCriterio("nombreTipoUsuario", "=", "Cliente"));
        TipoUsuario tipoUsuarioCliente =  (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
        criterios.clear();
        
        criterios.add(new DTOCriterio("nombreTipoUsuario", "=", "Administrador"));
        TipoUsuario tipoUsuarioAdministrador =  (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
        criterios.clear();
        
        criterios.add(new DTOCriterio("cuilCuitCliente", "=", "23-23212323-9"));
        Cliente cliente = (Cliente) FachadaPersistencia.getInstance().buscar("Cliente", criterios).get(0);
        criterios.clear();
        criterios.add(new DTOCriterio("nombreEmpresa", "=", "Claro"));    
        Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
        
        Usuario usuarioEmpresa = new Usuario("claro", "claro", null, null, tipoUsuarioEmpresa, null, empresa);
        Usuario usuarioAministrador = new Usuario("admin", "admin", null, null, tipoUsuarioAdministrador, null, null);
        Usuario usuarioCliente = new Usuario("jperez", "jperez", null, null, tipoUsuarioCliente, cliente, null);
        
        FachadaPersistencia.getInstance().guardar(usuarioEmpresa);
        FachadaPersistencia.getInstance().guardar(usuarioAministrador);
        FachadaPersistencia.getInstance().guardar(usuarioCliente);

        
    }
    public static void generarTipoUsuario(){
        TipoUsuario  tipoUsuario1 =new TipoUsuario(1, "Administrador", null);
        TipoUsuario  tipoUsuario2 =new TipoUsuario(1, "Empresa", null);
        TipoUsuario  tipoUsuario3 =new TipoUsuario(1, "Cliente", null);
        FachadaPersistencia.getInstance().guardar(tipoUsuario1);
        FachadaPersistencia.getInstance().guardar(tipoUsuario2);
        FachadaPersistencia.getInstance().guardar(tipoUsuario3);

        System.out.println("Guardado: Tipo Usuario");
    }
    
    public static void generarCliente(){
        Cliente  cliente1 =new Cliente("23-23212323-9", "Perez", "Juan", "23212323", null);
        Cliente  cliente2 =new Cliente("20-8951454-2", "Palacios", "Pedro", "8951454", null);
        Cliente  cliente3 =new Cliente("27-12562545-6", "Virga", "Pablo", "12562545", null);
        FachadaPersistencia.getInstance().guardar(cliente1);
        FachadaPersistencia.getInstance().guardar(cliente2);
        FachadaPersistencia.getInstance().guardar(cliente3);

        System.out.println("Guardado: Tipo Usuario");
    }
    
    public static void generarEmpresa(){
       
        List<Object> listTipoEmpresa =  FachadaPersistencia.getInstance().buscar("TipoEmpresa", null);
        
        int couter = 0;
        
        for(Object tipoEmpresaObject : listTipoEmpresa){
            TipoEmpresa tipoEmpresa = (TipoEmpresa)tipoEmpresaObject;
            if(couter > 0){
                Empresa  empresa3 =new Empresa("23-85562343-3", "Claro", "Direccion Empresa 3", null);
                FachadaPersistencia.getInstance().guardar(empresa3);
                break;
            }

            Empresa  empresa1 =new Empresa("23-85562365-3", "Telefonica", "Direccion Empresa 1", null);
            Empresa  empresa2 =new Empresa("23-85562323-3", "Directv", "Direccion Empresa 2", null);
            FachadaPersistencia.getInstance().guardar(empresa1);
            FachadaPersistencia.getInstance().guardar(empresa2);
            couter++ ;
        }
        
        


        System.out.println("Guardado: Empresa");

    }
    
    public static void generarTipoEmpresa(){
        TipoEmpresa  tipoEmpresa1 =new TipoEmpresa("Telefonia Celular", null);
        TipoEmpresa  tipoEmpresa2 =new TipoEmpresa("ISP Internet", null);
        FachadaPersistencia.getInstance().guardar(tipoEmpresa1);
        FachadaPersistencia.getInstance().guardar(tipoEmpresa2);

        System.out.println("Guardado: Tipo Empresa");
    }
    
    
    public static void generarTipoImpuesto(){
        TipoImpuesto  tipoImpuesto1 =new TipoImpuesto(1, true, null, "Telefonia");
        TipoImpuesto  tipoImpuesto2 =new TipoImpuesto(2, true, null, "Gas, Luz y Telefono");
        TipoImpuesto  tipoImpuesto3 =new TipoImpuesto(3, false, null, "Varios");
        FachadaPersistencia.getInstance().guardar(tipoImpuesto1);
        FachadaPersistencia.getInstance().guardar(tipoImpuesto2);
        FachadaPersistencia.getInstance().guardar(tipoImpuesto3);

        System.out.println("Guardado: Tipo Impuesto");
    }
    
    public static void generarItem(){

        List<Object> listTipoDatoItem =  FachadaPersistencia.getInstance().buscar("TipoDatoItem", null);
        
           
        int couter = 0;
        
        for(Object tipoDatoItemObject : listTipoDatoItem){
            TipoDatoItem tipoDatoItem = (TipoDatoItem) tipoDatoItemObject;
            if(couter > 0){
                Item  item =new Item("2", "Iva", 5, true, null, tipoDatoItem);
                FachadaPersistencia.getInstance().guardar(item);
                break;
            }

            Item  item =new Item("1", "Plus", 4, true, null, tipoDatoItem);
            FachadaPersistencia.getInstance().guardar(item);
            couter++ ;
        }
        System.out.println("Guardado: Item");
    }
    
    public static void generarItemEmpresaTipoImpuesto(){

        List<Object> listEmpresaTipoImpuesto =  FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", null);
        List<Object> listItem =  FachadaPersistencia.getInstance().buscar("Item", null);
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) listEmpresaTipoImpuesto.get(0);

        Item item = (Item) listItem.get(0);

        ItemEmpresaTipoImpuesto  itemEmpresaTipoImpuesto =new ItemEmpresaTipoImpuesto(1, null, item, empresaTipoImpuesto);
        
        FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
        
        System.out.println("Guardado: Item Empresa Tipo Impuesto");
    }
}
