/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.client;

import bdclases.Gamiacumulacion;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author manuel
 */
public interface ServicioGWTGamificacion {
    
    public void myMethod(String s, AsyncCallback<String> callback);

    public void obtenerDatosGamificacion(int id, AsyncCallback<Gamiacumulacion> asyncCallback);
    
}
