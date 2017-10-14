/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPrueba;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Entity.Cliente;
import sistemapagoimpuestos.Entity.CuentaBancaria;
import sistemapagoimpuestos.Entity.DetalleOperacion;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Item;
import sistemapagoimpuestos.Entity.ItemEmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.Operacion;
import sistemapagoimpuestos.Entity.TipoCuenta;
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
        generarTipoEmpresa();
        FachadaInterna.getInstance().finalizarTransaccion();
        FachadaInterna.getInstance().iniciarTransaccion();
        generarEmpresa();
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

        
         FachadaInterna.getInstance().iniciarTransaccion();
        generarTipoImpuesto();
        FachadaInterna.getInstance().finalizarTransaccion();
        
    }
    
    public static void generarUsuarioCliente(){
        FachadaInterna.getInstance().iniciarTransaccion();
        Usuario u = new Usuario();
        u.setNombreUsuario("eluna");
        u.setPasswordUsuario("123456");
        List<DTOCriterio> criterios = new ArrayList<>();
        criterios.add(new DTOCriterio("cuilCuitCliente", "=", "10000000"));
        Cliente cliente = (Cliente) FachadaPersistencia.getInstance().buscar("Cliente", criterios).get(0);   
        criterios.clear();
        criterios.add(new DTOCriterio("nombreTipoUsuario", "=", "Cliente"));
        TipoUsuario tipoUsuario = (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
        u.setCliente(cliente);
        u.setTipoUsuario(tipoUsuario);
        FachadaPersistencia.getInstance().guardar(u);
        FachadaInterna.getInstance().finalizarTransaccion();
        
    }
    public static void buscarCliente(){
        FachadaInterna.getInstance().iniciarTransaccion();
        List<DTOCriterio> criterios = new ArrayList<>();
        criterios.add(new DTOCriterio("nombreUsuario", "=", "eluna"));
        Usuario u = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criterios).get(0);
        FachadaInterna.getInstance().finalizarTransaccion();

    }
    
    
    public static void generarTipoDatoItem(){
        TipoDatoItem  tipoDatoItem1 =new TipoDatoItem(1, "Dato Item 1");
        TipoDatoItem  tipoDatoItem2 =new TipoDatoItem(2, "Dato Item 2");
        TipoDatoItem  tipoDatoItem3 =new TipoDatoItem(3, "Dato Item 3");
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
    
    
    public static void generarEmpresa(){
       
        List<Object> listTipoEmpresa =  FachadaPersistencia.getInstance().buscar("TipoEmpresa", null);
        
        int couter = 0;
        
        for(Object tipoEmpresaObject : listTipoEmpresa){
            TipoEmpresa tipoEmpresa = (TipoEmpresa)tipoEmpresaObject;
            if(couter > 0){
                Empresa  empresa3 =new Empresa("23-85562343-3", "Empresa 3", "Direccion Empresa 3", null);
                FachadaPersistencia.getInstance().guardar(empresa3);
                break;
            }

            Empresa  empresa1 =new Empresa("23-85562365-3", "Empresa 1", "Direccion Empresa 1", null);
            Empresa  empresa2 =new Empresa("23-85562323-3", "Empresa 2", "Direccion Empresa 2", null);
            FachadaPersistencia.getInstance().guardar(empresa1);
            FachadaPersistencia.getInstance().guardar(empresa2);
            couter++ ;
        }
        
        


        System.out.println("Guardado: Empresa");

    }
    
    public static void generarTipoEmpresa(){
        TipoEmpresa  tipoEmpresa1 =new TipoEmpresa("Tipo Empresa 1", null);
        TipoEmpresa  tipoEmpresa2 =new TipoEmpresa("Tipo Empresa 2", null);
        TipoEmpresa  tipoEmpresa3 =new TipoEmpresa("Tipo Empresa 3", null);
        FachadaPersistencia.getInstance().guardar(tipoEmpresa1);
        FachadaPersistencia.getInstance().guardar(tipoEmpresa2);
        FachadaPersistencia.getInstance().guardar(tipoEmpresa3);

        System.out.println("Guardado: Tipo Empresa");
    }
    
    
    public static void generarTipoImpuesto(){
        TipoImpuesto  tipoImpuesto1 =new TipoImpuesto(1, true, null, "Tipo Impuesto 1");
        TipoImpuesto  tipoImpuesto2 =new TipoImpuesto(2, true, null, "Tipo Impuesto 2");
        TipoImpuesto  tipoImpuesto3 =new TipoImpuesto(3, false, null, "Tipo Impuesto 3");
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
                Item  item =new Item("2", "Item 2", 5, true, null, tipoDatoItem);
                FachadaPersistencia.getInstance().guardar(item);
                break;
            }

            Item  item =new Item("1", "Item 1", 4, true, null, tipoDatoItem);
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

        ItemEmpresaTipoImpuesto  itemEmpresaTipoImpuesto =new ItemEmpresaTipoImpuesto(1, null, item,true, empresaTipoImpuesto);
        
        FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
        
        System.out.println("Guardado: Item Empresa Tipo Impuesto");
    }
    /*
    public static void createOperation(){
        Operacion operacion = new Operacion();
        operacion.setLiquidadaOperacion(true);
        operacion.setCodigoPagoElectrionicoOperacion("2331");
        operacion.setCuentaBancaria(new CuentaBancaria("23",
                                                    "3124223",
                                                    null,
                                                    new TipoCuenta(10,
                                                            "Tipo test", 
                                                            false, 
                                                            null), 
                                                    new Cliente("321231",
                                                            "test", 
                                                            "test", 
                                                            "32123", 
                                                            null
                                                    )));
        Set<DetalleOperacion> detalleOperacionList = new HashSet<DetalleOperacion>();
        detalleOperacionList.add(new DetalleOperacion("Test Detalle"));
        operacion.setEmpresa(new  Empresa("3212123", "test", "test", null));
        operacion.setEmpresaTipoImpuesto(null);
        operacion.setFechaHoraOperacion(new Date());
        operacion.setImportePagadoOperacion(23);
        operacion.setNumeroOperacion(2);
        operacion.setListDetalleOperacion(detalleOperacionList);
        operacion.setValorComisionOperacion(2);
        
        FachadaPersistencia.getInstance().guardar(operacion);
    }
*/
}
