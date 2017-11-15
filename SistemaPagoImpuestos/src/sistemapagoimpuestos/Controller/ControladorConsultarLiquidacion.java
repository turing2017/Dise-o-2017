/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Controller;

import exceptions.ExcepcionGenerica;
import exceptions.Excepciones;
import java.util.Date;
import java.util.List;
import sistemapagoimpuestos.Dto.DTOExporteLiquidacion;
import sistemapagoimpuestos.Dto.DTOLiquidacionesConsultarLiquidaciones;

import sistemapagoimpuestos.Dto.DTOTipoImpuesto;
import sistemapagoimpuestos.Expert.ExpertoConsultarLiquidacion;
import sistemapagoimpuestos.Fabricas.FabricaExpertos;
import sistemapagoimpuestos.Utils.UIExportar;
import sistemapagoimpuestos.Utils.UIExportarExcel;
import sistemapagoimpuestos.Utils.UIExportarTxt;
import sistemapagoimpuestos.View.Empresa.ConsultarLiquidacion.IUConsultarLiquidacion;
import sistemapagoimpuestos.View.Empresa.ConsultarLiquidacion.IUMostrar;


/**
 *
 * @author Dario
 */
public class ControladorConsultarLiquidacion {
 
    private ExpertoConsultarLiquidacion experto = (ExpertoConsultarLiquidacion) FabricaExpertos.getInstancia().crearExperto("CU18");

    public ControladorConsultarLiquidacion() {
    }
   
    public List<DTOTipoImpuesto> obtenerTipoImpuestos() {
        return experto.obtenerTipoImpuestos();
    }

    public List<DTOLiquidacionesConsultarLiquidaciones> buscarLiquidacionConFiltro(String itemAt, String text, Date fechadesde, Date fechahasta) {
        return experto.buscarLiquidacionConFiltro(itemAt, text, fechadesde, fechahasta);
    }

    public void validarUsuario() {
        try {
            experto.validarUsuario();
            IUConsultarLiquidacion UIConsultarLiquidacion= new IUConsultarLiquidacion();
            UIConsultarLiquidacion.setVisible(true);
            UIConsultarLiquidacion.setLocationRelativeTo(null);
            UIConsultarLiquidacion.setTitle("Consultar Liquidación - EMPRESA");

        } catch (ExcepcionGenerica e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "El usuario no corresponde a un usuario de Empresa");
        } catch (Exception e) {
            Excepciones.getInstance().errorGenerico("Error: Usuario", "No se pudo verificar el tipo de usuario.");
        }
    }

    public void mostrar(String nliquidacion) {
        IUMostrar mostrar = new IUMostrar(nliquidacion);
        mostrar.setVisible(true);
    }

    public DTOLiquidacionesConsultarLiquidaciones buscardetalleLiquidacion(String numeroLiquidacion) {
        return experto.buscardetalleLiquidacion(numeroLiquidacion);
    }

    public void exportarLiquidacion(DTOExporteLiquidacion dtoExporteLiquidacion, String tipoArchivo) {

        UIExportar uiExportar;
        switch (tipoArchivo) {
            case "Excel":
                uiExportar = new UIExportarExcel();
                uiExportar.exportarLiquidacion(dtoExporteLiquidacion);
                break;
            case "Txt":
                uiExportar = new UIExportarTxt();
                uiExportar.exportarLiquidacion(dtoExporteLiquidacion);
        }
    }

}
