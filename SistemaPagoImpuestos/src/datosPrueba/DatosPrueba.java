/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosPrueba;

import java.util.List;
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
        generarTipoEmpresa();
        generarEmpresa();
        generarTipoDatoItem();
        generarTipoImpuesto();
        generarEmpresaTipoImpuesto();
        generarItem();
        generarItemEmpresaTipoImpuesto();
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
        List<Object> listEmpresaObject =  FachadaPersistencia.getInstance().buscar(Empresa.class, null);
        Object tipoImpuestoObject =  FachadaPersistencia.getInstance().buscar(TipoImpuesto.class, null).get(0);

        int couter = 0;

        for(Object tipoEmpresaObject : listEmpresaObject){
            Empresa empresa = (Empresa)tipoEmpresaObject;
            TipoImpuesto tipoImpuesto = (TipoImpuesto) tipoImpuestoObject;
            if(couter > 0){
                EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto("url 2", null, tipoImpuesto , empresa);
                FachadaPersistencia.getInstance().guardar(empresaTipoImpuesto);
                break;
            }
            
            EmpresaTipoImpuesto empresaTipoImpuesto = new EmpresaTipoImpuesto("url 1", null, tipoImpuesto , empresa);
            FachadaPersistencia.getInstance().guardar(empresaTipoImpuesto);
            couter++ ;
        }

        
        
    }
    
    
    public static void generarEmpresa(){
       
        List<Object> listTipoEmpresa =  FachadaPersistencia.getInstance().buscar(TipoEmpresa.class, null);
        
        int couter = 0;
        
        for(Object tipoEmpresaObject : listTipoEmpresa){
            TipoEmpresa tipoEmpresa = (TipoEmpresa)tipoEmpresaObject;
            if(couter > 0){
                Empresa  empresa3 =new Empresa("23-85562343-3", "Empresa 3", "Direccion Empresa 3", null, tipoEmpresa);
                FachadaPersistencia.getInstance().guardar(empresa3);
                break;
            }

            Empresa  empresa1 =new Empresa("23-85562365-3", "Empresa 1", "Direccion Empresa 1", null, tipoEmpresa);
            Empresa  empresa2 =new Empresa("23-85562323-3", "Empresa 2", "Direccion Empresa 2", null, tipoEmpresa);
            FachadaPersistencia.getInstance().guardar(empresa1);
            FachadaPersistencia.getInstance().guardar(empresa2);
            couter++ ;
        }
        
        


        System.out.println("Guardado: Empresa");

    }
    
    public static void generarTipoEmpresa(){
        TipoEmpresa  tipoEmpresa1 =new TipoEmpresa("Tipo Empresa 1", null);
        TipoEmpresa  tipoEmpresa2 =new TipoEmpresa("Tipo Empresa 1", null);
        TipoEmpresa  tipoEmpresa3 =new TipoEmpresa("Tipo Empresa 1", null);
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

        List<Object> listTipoDatoItem =  FachadaPersistencia.getInstance().buscar(TipoDatoItem.class, null);
        
           
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

        List<Object> listEmpresaTipoImpuesto =  FachadaPersistencia.getInstance().buscar(EmpresaTipoImpuesto.class, null);
        List<Object> listItem =  FachadaPersistencia.getInstance().buscar(Item.class, null);
        EmpresaTipoImpuesto empresaTipoImpuesto = (EmpresaTipoImpuesto) listEmpresaTipoImpuesto.get(0);

        Item item = (Item) listItem.get(0);

        ItemEmpresaTipoImpuesto  itemEmpresaTipoImpuesto =new ItemEmpresaTipoImpuesto(1, null, item, empresaTipoImpuesto);
        
        FachadaPersistencia.getInstance().guardar(itemEmpresaTipoImpuesto);
        
        System.out.println("Guardado: Item Empresa Tipo Impuesto");
    }
}
