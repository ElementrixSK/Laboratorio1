/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio1_FilaA;

import java.io.Serializable;

/**
 *
 * @author SmartUrban2025
 */
public class Libro extends MaterialBibliografico implements Serializable{
    static final long serialVersionUID=42L;
    private int edicion;
    private String area;
    
    @Override
    public void Mostrar(){
        super.Mostrar();
        System.out.println("Edicion : "                 +this.edicion);
        System.out.println("Area    : "                 +this.area);
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    
}
