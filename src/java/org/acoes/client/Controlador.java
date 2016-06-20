/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.client;

import bdclases.Gamiacumulacion;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import gwt.material.design.client.ui.MaterialToast;
//import static org.acoes.client.Gamificacion_perfil.getService;

/**
 *
 * @author manuel
 */
public class Controlador {

    private RootPanel panel_principal;
    private Ventana_principal ventana_principal;
    private Gamificacion_perfil gamificacion_perfil;

    Controlador(RootPanel get) {
        panel_principal = get;
    }

    void comenzar() {
        ventana_principal = new Ventana_principal();
        panel_principal.add(ventana_principal);

//        gamificacion_perfil = new Gamificacion_perfil();
//        panel_principal.add(gamificacion_perfil);

    }

//    void VentanaGamificacionPerfilPulsadoPuntuacion(ClickEvent event) {
//        getService().obtenerDatosGamificacion(id, new AsyncCallback<Gamiacumulacion>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                MaterialToast.fireToast("No se pudo obtener la puntuación del servidor.");
//            }
//
//            @Override
//            public void onSuccess(Gamiacumulacion result) {
//                gamificacion_perfil.cargarPuntuacionYMedallas(result);
//            }
//        });
//
//    }

}
