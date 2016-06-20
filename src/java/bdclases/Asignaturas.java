/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclases;

public class Asignaturas{
    
    int id_Asignatura;
    String Nombre;

    public Asignaturas(int id_Asignatura, String Nombre) {
        this.id_Asignatura = id_Asignatura;
        this.Nombre = Nombre;
    }

    public Asignaturas() {
        //throw new UnsupportedOperationException("No soportado");
    }

    public int getId_Asignatura() {
        return id_Asignatura;
    }

    public void setId_Asignatura(int id_Asignatura) {
        this.id_Asignatura = id_Asignatura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    

}
