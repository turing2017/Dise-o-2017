/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Decorators;

import java.util.ArrayList;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOEmpresa;
import sistemapagoimpuestos.Dto.DTOEmpresaTipoImpuesto;
import sistemapagoimpuestos.Dto.DTOOperacion;
import sistemapagoimpuestos.Dto.DTORangoFecha;
import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Entity.Empresa;
import sistemapagoimpuestos.Expert.ExpertoConsultarOperacionesBancarias;
import sistemapagoimpuestos.Utils.FachadaInterna;

/**
 *
 * @author Tongas
 */
public class DecoradorConsultarOperacionesBancarias extends ExpertoConsultarOperacionesBancarias{

    @Override
    public ArrayList<DTOOperacion> consultarOperaciones(DTORangoFecha dtoRF) {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOOperacion> listDTOO = super.consultarOperaciones(dtoRF); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return listDTOO;
    }

    @Override
    public ArrayList<DTOEmpresaTipoImpuesto> obtenerTipoImpuestosAsociados() {
        FachadaInterna.getInstance().iniciarTransaccion();
        ArrayList<DTOEmpresaTipoImpuesto> dtoETI= super.obtenerTipoImpuestosAsociados(); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoETI;
    }

    @Override
    public DTOEmpresa verificarEmpresa(String cuitEmpresa) {
        FachadaInterna.getInstance().iniciarTransaccion();
        DTOEmpresa dtoE = super.verificarEmpresa(cuitEmpresa); //To change body of generated methods, choose Tools | Templates.
        FachadaInterna.getInstance().finalizarTransaccion();
        return dtoE;
    }


    
    
}
