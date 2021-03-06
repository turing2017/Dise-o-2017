/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Rodri
 */
public class ExpertoGestionarUsuario {

    //Usuario usuario = new Usuario();

    public String iniciar() {

        return "Administrador";
    }

    public ArrayList<DTOUsuario> obtenerUsuario() {

        List<Object> listObject = FachadaPersistencia.getInstance().buscar("Usuario", null);
        ArrayList<DTOUsuario> listDtoUsuario = new ArrayList<DTOUsuario>();
        for (Object obj : listObject) {
            Usuario user = (Usuario) obj;
            listDtoUsuario.add(ConvertDTO.getInstance().convertUsuario(user));
        }
        return listDtoUsuario;
    }

    public List<DTOUsuario> obtenerUsuario(String codigo) {
        // De alguna forma devuelvo el TipoImpuesto de la DB
        try {
            List<DTOCriterio> criterios = new ArrayList<>();

            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("nombreUsuario");
            criterio1.setOperacion("=");
            criterio1.setValor(codigo);
            criterios.add(criterio1);
            Usuario u = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criterios).get(0);
            List<DTOUsuario> listadoUsuario = new ArrayList();
            listadoUsuario.add(new DTOUsuario(u.getNombreUsuario(),
                    u.getPasswordUsuario(),
                    u.getFechaHoraInhabilitacionUsuario(),
                    u.getFechaHoraUltimoIngresoSistemaUsuario(),
                    u.tipoUsuario.getNombreTipoUsuario(),
                    u.empresa.getNombreEmpresa()));
            return listadoUsuario;

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Usuario");
            return null;
        }

    }

    public void nuevoUsuario(String nombreIngres,String passwordIngres,String tipoUsuarioSelec, String empresaSelec) {
        Usuario nuevoUsuario = new Usuario();
        
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio = new DTOCriterio("nombreTipoUsuario", "=", tipoUsuarioSelec);
        criterios.add(criterio);
        List resultado = FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios);
        
        nuevoUsuario.setNombreUsuario(nombreIngres);
        nuevoUsuario.setPasswordUsuario(passwordIngres);
        nuevoUsuario.setTipoUsuario((TipoUsuario) resultado.get(0));
        if (tipoUsuarioSelec.equals("Responsable")){
            List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
            criteriosEmpresa.add(new DTOCriterio("nombreEmpresa", "=", empresaSelec));
            List resultadoEmpresa = FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa);
            
            nuevoUsuario.setEmpresa((Empresa) resultadoEmpresa.get(0));
        } else {
            nuevoUsuario.setEmpresa(null);
        }
        
        FachadaPersistencia.getInstance().guardar(nuevoUsuario);
    }

    public List<DTOTipoUsuario> setearComboTipoUsuario() {
        List<DTOCriterio> criterios = new ArrayList<>();
        criterios.add(new DTOCriterio("fechaHoraInhabilitacionTipoUsuario", "IS", null));
        criterios.add(new DTOCriterio("nombreTipoUsuario", "<>", "Cliente"));
        List tipoUsuarioHabilitado = FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios);

        List<DTOTipoUsuario> listado = new ArrayList<>();
        for (int i = 0; i < tipoUsuarioHabilitado.size(); i++) {
            TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioHabilitado.get(i);
            listado.add(ConvertDTO.getInstance().convertTipoUsuario(tipoUsuario));
        }

        return listado;
    }

    public List<DTOEmpresa> setearComboEmpresa() {
        List<DTOCriterio> criterios = new ArrayList<>();

        DTOCriterio criterio = new DTOCriterio("fechaHoraInhabilitacionEmpresa", "IS", null);
        criterios.add(criterio);
        List empresaHabilitada = FachadaPersistencia.getInstance().buscar("Empresa", criterios);

        List<DTOEmpresa> listado = new ArrayList<>();
        for (int i = 0; i < empresaHabilitada.size(); i++) {
            Empresa empresa = (Empresa) empresaHabilitada.get(i);
            listado.add(ConvertDTO.getInstance().convertEmpresa(empresa));
        }

        return listado;
    }

    public void modificarDatosUsuario(String nombreUsuario, String contraseñaNueva, boolean esHabilitado, String tipoUsuarioSelec, String empresaSelec) {
        List<DTOCriterio> criterio = new ArrayList<>();
        criterio.add(new DTOCriterio("nombreUsuario", "=", nombreUsuario));
        List resultado = FachadaPersistencia.getInstance().buscar("Usuario", criterio);
        
        List<DTOCriterio> criteriosTipoUsuario = new ArrayList<>();
        criteriosTipoUsuario.add(new DTOCriterio("nombreTipoUsuario", "=", tipoUsuarioSelec));
        List resultadoTipoUsuario = FachadaPersistencia.getInstance().buscar("TipoUsuario", criteriosTipoUsuario);
        
        Usuario usuarioSelec = (Usuario) resultado.get(0);
        
        if(contraseñaNueva != null){
            usuarioSelec.setPasswordUsuario(contraseñaNueva);
        }
        
        if (esHabilitado == false){
            usuarioSelec.setFechaHoraInhabilitacionUsuario(new Date());
        }
        else{
            usuarioSelec.setFechaHoraInhabilitacionUsuario(null);
        }
        
        usuarioSelec.setTipoUsuario((TipoUsuario) resultadoTipoUsuario.get(0));
        
        if (tipoUsuarioSelec.equals("Responsable")){
            List<DTOCriterio> criteriosEmpresa = new ArrayList<>();
            criteriosEmpresa.add(new DTOCriterio("nombreEmpresa", "=", empresaSelec));
            List resultadoEmpresa = FachadaPersistencia.getInstance().buscar("Empresa", criteriosEmpresa);
            
            usuarioSelec.setEmpresa((Empresa) resultadoEmpresa.get(0));
        } else {
            usuarioSelec.setEmpresa(null);
        }
        
        FachadaPersistencia.getInstance().guardar(usuarioSelec);
    }
}
