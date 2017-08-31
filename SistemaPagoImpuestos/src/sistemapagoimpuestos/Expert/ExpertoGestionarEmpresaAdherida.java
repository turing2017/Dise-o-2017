/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresaExistente;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import java.util.Date;
import sistemapagoimpuestos.Controller.ControladorGestionarEmpresaAdherida;
import sistemapagoimpuestos.Dto.DTOConsultarEmpresas;
import sistemapagoimpuestos.Dto.DTOEmpresaHabilitada;
import sistemapagoimpuestos.Dto.DTOEmpresaInhabilitada;

/**
 *
 * @author Tongas
 */
public class ExpertoGestionarEmpresaAdherida {
    
    protected Empresa empresa;

    public String iniciar() {

        /*TipoUsuario tipoUsuario = usuario.getTipoUsuario();
        String nombreTipoUsuario = tipoUsuario.getNombreTipoUsuario();
        System.out.println("1");
        if (nombreTipoUsuario != "Adminstrador") {
            System.out.println("Debe ser Cliente para realizar esta acción");
        }*/
        return "Administrador";
    }

    public void ingresarDatosEmpresa(String cuitEmpresa, String nombreEmpresa, String direccionEmpresa) {
        try {

            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("fechaHoraInhabilitacionEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(null);
            criterios.add(criterio1);
            //Se arma el criterio de busqueda para la condicion fechaHoraInhabilitacionEmpresa = null
            DTOCriterio criterio2 = new DTOCriterio();
            criterio1.setAtributo("cuitEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(cuitEmpresa);
            criterios.add(criterio2);
            //Se arma el criterio de busqueda para la condicion cuitEmpresa = cuitEmpresa ingresado
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            System.out.println("El cuit ya existe");//En el caso de que exista, tira mensaje   

        } catch (IndexOutOfBoundsException exception) {//Si no encuentra Empresa con ese cuit, la crea
            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa(nombreEmpresa);
            empresa.setCuitEmpresa(cuitEmpresa);
            empresa.setDireccionEmpresa(direccionEmpresa);
            empresa.setFechaHoraInhabilitacionEmpresa(null);
            FachadaPersistencia.getInstance().guardar(empresa);
            System.out.println("La empresa fue creada con éxito");
           
        }

    }

    public List<DTOEmpresaExistente> ingresarNroCuit(String cuitEmpresa) {
        ArrayList<DTOEmpresaExistente> listDTOEmpresaExistente = new ArrayList<DTOEmpresaExistente>();
        try {

            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("cuit");
            criterio1.setOperacion("=");
            criterio1.setValor(cuitEmpresa);
            criterios.add(criterio1);
            //Se arma el criterio de busqueda para la condicion fechaHoraInhabilitacionEmpresa = null
            DTOCriterio criterio2 = new DTOCriterio();
            criterio1.setAtributo("fechaHoraInhabilitacionEmpresa");
            criterio1.setOperacion("=");
            criterio1.setValor(null);
            criterios.add(criterio2);
            //Se arma el criterio de busqueda para la condicion cuitEmpresa = cuitEmpresa ingresado
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            DTOEmpresaExistente dtoEmpresaExistente = new DTOEmpresaExistente();
            dtoEmpresaExistente.setNombreEmpresa(empresa.getNombreEmpresa());
            dtoEmpresaExistente.setCuitEmpresa(cuitEmpresa);
            dtoEmpresaExistente.setDireccionEmpresa(empresa.getDireccionEmpresa());
            listDTOEmpresaExistente.add(dtoEmpresaExistente);

        } catch (IndexOutOfBoundsException exception) {//Si no encuentra Empresa con ese cuit, la crea
            System.out.println("El cuit no existe");

        }
        return listDTOEmpresaExistente;
    }

    public Empresa conseguirEmpresa(String cuitEmpresa) {

        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("cuitEmpresa");
        criterio1.setOperacion("=");
        criterio1.setValor(cuitEmpresa);
        criterios.add(criterio1);
        empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

        String cuit = empresa.getCuitEmpresa();
        String nombre = empresa.getNombreEmpresa();
        String direccion = empresa.getDireccionEmpresa();
        
        return empresa;
    
    }
    
    public void seleccionarModificar (String nombreEmpresa, String direccionEmpresa){
        empresa.setNombreEmpresa(nombreEmpresa);
        empresa.setDireccionEmpresa(direccionEmpresa);
        FachadaPersistencia.getInstance().guardar(empresa);
        System.out.print("La modificación se realizó con éxito");
        
    }

    public void seleccionarEliminar(String cuitEmpresa) {

        java.util.Date fechaActual = new Date();
        empresa.setFechaHoraInhabilitacionEmpresa(fechaActual);
        FachadaPersistencia.getInstance().guardar(empresa);
        System.out.print("La empresa fue eliminada con exito");

    }

    public DTOConsultarEmpresas ingresarOpcion(String opcion) {
        if ("EmpresasExistentes".equals(opcion)) {

            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("fechaHoraInhabilitacionEmpresaAdherida");
            criterio1.setOperacion("==");
            criterio1.setValor(null);
            criterios.add(criterio1);
            List<Empresa> listaEmpresa = (List<Empresa>) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

            DTOConsultarEmpresas dtoConsultarEmp = new DTOConsultarEmpresas();

            for (int i = 0; i < listaEmpresa.size(); i++) {
                DTOEmpresaHabilitada dtoEmp = new DTOEmpresaHabilitada();
                dtoEmp.setCuitEmpresa(listaEmpresa.get(i).getCuitEmpresa());
                dtoEmp.setNombreEmpresa(listaEmpresa.get(i).getNombreEmpresa());
                dtoEmp.setDireccionEmpresa(listaEmpresa.get(i).getDireccionEmpresa());
                dtoConsultarEmp.add(dtoEmp);
            }
            return dtoConsultarEmp;

        } else {
            List<DTOCriterio> criterios = new ArrayList<>();
            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("fechaHoraInhabilitacionEmpresaAdherida");
            criterio1.setOperacion("!=");
            criterio1.setValor(null);
            criterios.add(criterio1);
            List<Empresa> listaEmpresa = (List<Empresa>) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);

           DTOConsultarEmpresas dtoConsultarEmp = new DTOConsultarEmpresas();

            for (int i = 0; i < listaEmpresa.size(); i++) {
                DTOEmpresaInhabilitada dtoEmpIn = new DTOEmpresaInhabilitada();
                dtoEmpIn.setCuitEmpresa(listaEmpresa.get(i).getCuitEmpresa());
                dtoEmpIn.setNombreEmpresa(listaEmpresa.get(i).getNombreEmpresa());
                dtoEmpIn.setDireccionEmpresa(listaEmpresa.get(i).getDireccionEmpresa());
                dtoEmpIn.setFechaHoraInhabilitacionEmpresa(listaEmpresa.get(i).getFechaHoraInhabilitacionEmpresa());
                dtoConsultarEmp.add(dtoEmpIn);
            }
            return dtoConsultarEmp;
        }
    }
}
