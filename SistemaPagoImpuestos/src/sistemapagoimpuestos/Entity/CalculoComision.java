/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemapagoimpuestos.Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author vande
 */
public class CalculoComision {
    Date fechaCalculoComision;
    double valorTotalCalculoComision;
    List<CalculoComisionEstado> listCalculoCOmisionEstado;
    List<Comision> listComision;
   
}
