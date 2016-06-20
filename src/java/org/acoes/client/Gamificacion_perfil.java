/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.client;

import bdclases.Gamiacumulacion;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialLink;

/**
 *
 * @author manuel
 */
public class Gamificacion_perfil extends Composite {
    
//    @UiField MaterialLink puntuacion;
//    @UiField MaterialLink medallas;
    private Controlador controlador;

    public Gamificacion_perfil(Controlador aThis) {
        controlador=aThis;
    }
    
//    @UiHandler("puntuacion")
//    public void pulsarPuntuacion(ClickEvent event){
//       //  cargarPuntuacionYMedallas();
//       controlador.VentanaGamificacionPerfilPulsadoPuntuacion(event);
//    }
    
    private static Gamificacion_perfilUiBinder uiBinder = GWT.create(Gamificacion_perfilUiBinder.class);
    
    interface Gamificacion_perfilUiBinder extends UiBinder<Widget, Gamificacion_perfil> {
    }
    
    public Gamificacion_perfil() {
        initWidget(uiBinder.createAndBindUi(this));
//        controlador.VentanaGamificacionPerfilPulsadoPuntuacion(null);
    }
//    
//    public void cargarPuntuacionYMedallas(Gamiacumulacion result) {
//        puntuacion.setText("" + result.getCantidad());
//        medallas.setText("" + result.getId_GamiCat());
//    }
//    
//    public static ServicioGWTGamificacionAsync getService() {
//        // Create the client proxy. Note that although you are creating the
//        // service interface proper, you cast the result to the asynchronous
//        // version of the interface. The cast is always safe because the
//        // generated proxy implements the asynchronous interface automatically.
//
//        return GWT.create(ServicioGWTGamificacion.class);
//    }
    
}
