/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Rodri
 */
public class ExpertoGestionarUsuario {

    Usuario usuario = new Usuario();

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

    public void nuevoUsuario(String nombreIngres,String passwordIngres,String tipoUsuarioSelec ) {
        
        

    }

    public List<DTOTipoUsuario> setearComboTipoUsuario() {
        List<DTOCriterio> criterios = new ArrayList<>();

        DTOCriterio criterio = new DTOCriterio("fechaHoraInhabilitacionTipoUsuario", "IS", null);
        criterios.add(criterio);
        List tipoUsuarioHabilitado = FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios);

        List<DTOTipoUsuario> listado = new ArrayList<>();
        for (int i = 0; i < tipoUsuarioHabilitado.size(); i++) {
            TipoUsuario tipoUsuario = (TipoUsuario) tipoUsuarioHabilitado.get(i);
            listado.add(ConvertDTO.getInstance().convertTipoUsuario(tipoUsuario));

        }

        return listado;
    }
}
