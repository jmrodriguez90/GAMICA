/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

/**
 *
 * @author manuel
 */

public class Resultado {
    int id_Resultado;
    String Resultado;

    public Resultado(int id_Resultado, String Resultado) {
        this.id_Resultado = id_Resultado;
        this.Resultado = Resultado;
    }

    public Resultado() {
        
    }

    public int getId_Resultado() {
        return id_Resultado;
    }

    public void setId_Resultado(int id_Resultado) {
        this.id_Resultado = id_Resultado;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
    
    
    
}
