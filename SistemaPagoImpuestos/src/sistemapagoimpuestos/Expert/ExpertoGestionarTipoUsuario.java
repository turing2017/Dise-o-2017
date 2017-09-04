/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import exceptions.Excepciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOTipoUsuario;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.ConvertDTO;
import sistemapagoimpuestos.Utils.FachadaPersistencia;
import static sistemapagoimpuestos.Utils.Utils.existeDato;

/**
 *
 * @author Rodri
 */
public class ExpertoGestionarTipoUsuario {

    Usuario usuario = new Usuario();

    public String iniciar() {

        return "Administrador";
    }

    public ArrayList<DTOTipoUsuario> obtenerTipoUsuario() {

        List<Object> listObject = FachadaPersistencia.getInstance().buscar("TipoUsuario", null);
        ArrayList<DTOTipoUsuario> listDtoTipoUsuario = new ArrayList<DTOTipoUsuario>();
        for (Object obj : listObject) {
            TipoUsuario tipoUsuario = (TipoUsuario) obj;
            listDtoTipoUsuario.add(ConvertDTO.getInstance().convertTipoUsuario(tipoUsuario));
        }
        return listDtoTipoUsuario;

    }

    public void nuevoTipoUsuario(String nombreTipoUsuarioIngres) {

        List<DTOCriterio> criteriosNombre = new ArrayList<>();

        DTOCriterio criterioNombre = new DTOCriterio("nombreTipoUsuario", "=", nombreTipoUsuarioIngres);
        criteriosNombre.add(criterioNombre);

        if (!existeDato("TipoUsuario", criteriosNombre)) {
            System.out.println("Nombre Ingresado No Encontrado");
            TipoUsuario tipoUsuario = new TipoUsuario();
            tipoUsuario.setNombreTipoUsuario(nombreTipoUsuarioIngres);
            tipoUsuario.setFechaHoraInhabilitacionTipoUsuario(null);
            FachadaPersistencia.getInstance().guardar(tipoUsuario);
        } else {
            Excepciones.getInstance().objetoExistente("Nombre");

        }

    }

    public List<DTOTipoUsuario> obtenerTipoUsuario(String codigo) {
        // De alguna forma devuelvo el TipoImpuesto de la DB
        try {
            List<DTOCriterio> criterios = new ArrayList<>();

            DTOCriterio criterio1 = new DTOCriterio();
            criterio1.setAtributo("nombreTipoUsuario");
            criterio1.setOperacion("=");
            criterio1.setValor(codigo);
            criterios.add(criterio1);
            TipoUsuario tipoUsuario = (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
            List<DTOTipoUsuario> listadoTipoUsuario = new ArrayList();
            listadoTipoUsuario.add(new DTOTipoUsuario(tipoUsuario.getNombreTipoUsuario(), tipoUsuario.getFechaHoraInhabilitacionTipoUsuario()));

            return listadoTipoUsuario;

        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Codigo Ingresado No Encontrado");
            new Excepciones().datoNoEncontrado("Tipo Usuario");
            return null;
        }

    }

    public void modificarTipoUsuario(String nombreActualTipoUsuario) {

              
        List<DTOCriterio> criterios = new ArrayList<>();
        DTOCriterio criterio1 = new DTOCriterio();
        criterio1.setAtributo("nombreTipoUsuario");
        criterio1.setOperacion("=");
        criterio1.setValor(nombreActualTipoUsuario);
        criterios.add(criterio1);
       
        
        TipoUsuario tipoUsuario = (TipoUsuario) FachadaPersistencia.getInstance().buscar("TipoUsuario", criterios).get(0);
        if(tipoUsuario.getFechaHoraInhabilitacionTipoUsuario() == null){
            tipoUsuario.setFechaHoraInhabilitacionTipoUsuario(new Date());
        }else{
            tipoUsuario.setFechaHoraInhabilitacionTipoUsuario(null);
        }
        FachadaPersistencia.getInstance().guardar(tipoUsuario);
        System.out.println("Guardando en la DB: " + tipoUsuario.getNombreTipoUsuario());
    }
}
