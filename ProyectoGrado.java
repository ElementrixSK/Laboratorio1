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
public class ProyectoGrado extends MaterialBibliografico implements Serializable{
    static final long serialVersionUID=42L;
    private String tutor;
    private String revisor;
    
    @Override
    public void Mostrar(){
        super.Mostrar();
        System.out.println("Tutor   : "                 +this.tutor);
        System.out.println("Revisor : "                 +this.revisor);
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
    
    
}