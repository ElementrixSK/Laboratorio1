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
public class MaterialBibliografico implements Serializable{
    static final long serialVersionUID=42L;
    private String titulo;
    private String autor;
    
    public void Mostrar() {
        System.out.println("Titulo  :"     +this.titulo);
        System.out.println("Autor   :"     +this.autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
}
