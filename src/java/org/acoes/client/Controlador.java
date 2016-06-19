/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.client;

import com.google.gwt.user.client.ui.RootPanel;

/**
 *
 * @author manuel
 */
public class Controlador {
    private RootPanel panel_Principal;
    private Ventana_principal ventana_Principal;

    Controlador(RootPanel get) {
        panel_Principal=get;
    }

    void comenzar() {
        ventana_Principal = new Ventana_principal();
        panel_Principal.add(ventana_Principal);
    }
    
    
    
}
