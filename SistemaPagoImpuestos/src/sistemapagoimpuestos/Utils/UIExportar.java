/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Utils;

import sistemapagoimpuestos.Dto.DTOExportar;
import sistemapagoimpuestos.Dto.DTOExporteLiquidacion;


/**
 *
 * @author Gabriel
 */
public interface UIExportar {
    public void exportarOperaciones(DTOExportar dto);
    public void exportarLiquidacion(DTOExporteLiquidacion dto);
}