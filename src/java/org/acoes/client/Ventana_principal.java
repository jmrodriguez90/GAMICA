/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.acoes.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author manuel
 */
public class Ventana_principal extends Composite {
    
    private static Ventana_principalUiBinder uiBinder = GWT.create(Ventana_principalUiBinder.class);
    
    interface Ventana_principalUiBinder extends UiBinder<Widget, Ventana_principal> {
    }
    
    public Ventana_principal() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
