/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Expert;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOCriterio;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOUsuario;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Entity.EmpresaTipoImpuesto;
import sistemapagoimpuestos.Entity.TipoImpuesto;
import sistemapagoimpuestos.Entity.TipoUsuario;
import sistemapagoimpuestos.Entity.Usuario;
import sistemapagoimpuestos.Utils.FachadaPersistencia;

/**
 *
 * @author Dario
 */
public class ExpertoConsultarLiquidacion {
   
    Usuario usuario = new Usuario();
    TipoUsuario uAdmin = new TipoUsuario(0, "Administrador", null);
    TipoUsuario uCliente = new TipoUsuario(1, "Cliente", null);
    TipoUsuario uEmpresa = new TipoUsuario(2, "Empresa", null);

    public ExpertoConsultarLiquidacion() {
        usuario.setTipoUsuario(uEmpresa);
    }
    // Metodo iniciar

    public String iniciar() {
        return "Empresa";
    }

    public ArrayList<DTOEmpresaTipoImpuesto> consultarLiquidacion(DTOUsuario usuario) {
            //Buscamos la empresa com el cuit del usuario.
            String cuit = usuario.getEmpresaDTOUsuario();
            String nombreEmpresa;
            List<DTOCriterio> criterios = new ArrayList();
            criterios.add(new DTOCriterio("cuitEmpresa", "=", cuit));
            Empresa empresa = (Empresa) FachadaPersistencia.getInstance().buscar("Empresa", criterios).get(0);
            nombreEmpresa = empresa.getNombreEmpresa();
            criterios.clear();
            criterios.add(new DTOCriterio("Empresa", "=", empresa));
            List<DTOEmpresaTipoImpuesto> listDTOempresaTI = new ArrayList<>();
            List<Object> empresasTipoImpuesto = FachadaPersistencia.getInstance().buscar("EmpresaTipoImpuesto", criterios);
            //Comentar Someday
              for (Object obj : empresasTipoImpuesto) {
                DTOEmpresaTipoImpuesto dtoEmpresaTi = null;
                EmpresaTipoImpuesto empresaTi = (EmpresaTipoImpuesto) obj;
                DTOEmpresa dtoEmpresa = new DTOEmpresa();
                dtoEmpresa.setNombreEmpresa(empresaTi.getEmpresa().getNombreEmpresa());
                DTOTipoImpuesto dtoImpuesto = new DTOTipoImpuesto();
                dtoImpuesto.setNombreDTOTipoImpuesto(empresaTi.getTipoImpuesto().getNombreTipoImpuesto());
                dtoEmpresaTi.setdTOempresa(dtoEmpresa);
                dtoEmpresaTi.setdTOtipoImpuesto(dtoImpuesto);
                listDTOempresaTI.add(dtoEmpresaTi);
              
            }
            System.out.print(listDTOempresaTI.size());
            return null;
    }
}
