/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratorio1_FilaA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SmartUrban2025
 */
public class OperacionesMaterial {

    List<ProyectoGrado> ListaProyecto;
    List<Libro> ListaLibro;
    List<MaterialBibliografico> ListaMaterial;
    Scanner leer = new Scanner(System.in);

    public OperacionesMaterial() {
        ListaProyecto = new ArrayList<>();
        ListaLibro = new ArrayList<>();
        ListaMaterial = new ArrayList<>();
    }

    public void AñadirProyecto() {
        ProyectoGrado pg = new ProyectoGrado();
        System.out.print("Ingrese Titulo del Proyecto   : ");
        pg.setTitulo(leer.nextLine());
        System.out.print("Ingrese Autor del Proyecto    : ");
        pg.setAutor(leer.nextLine());
        System.out.print("Ingrese Tutor del Proyecto    : ");
        pg.setTutor(leer.nextLine());
        System.out.print("Ingrese Revisor del Proyecto  : ");
        pg.setRevisor(leer.nextLine());
        ListaMaterial.add(pg);
        System.out.println("");
        System.out.println("        PROYECTO REGISTRADO CON EXITO...        ");
        System.out.println("                                             ");
        
    }

    public void AñadirLibro() {
        Libro li = new Libro();
        System.out.print("Ingrese Titulo del Libro      : ");
        li.setTitulo(leer.nextLine());
        System.out.print("Ingrese Autor del Libro       : ");
        li.setAutor(leer.nextLine());
        System.out.print("Ingrese Edicion del Libro     : ");
        li.setEdicion(leer.nextInt());
        leer.nextLine();
        System.out.print("Ingrese Area del Libro        : ");
        li.setArea(leer.nextLine());
        ListaMaterial.add(li);
        System.out.println("");
        System.out.println("        LIBRO REGISTRADO CON EXITO...        ");
        System.out.println("");
    }

    public void MostrarMaterial(){
        if (!ListaMaterial.isEmpty()) {
            System.out.println("                MATERIAL BIBLIOGRAFICO                ");
            for (MaterialBibliografico lm : ListaMaterial) {
                if (lm instanceof Libro) {
                    System.out.println("            LIBRO           ");
                    Libro lib = (Libro) lm;
                    lib.Mostrar();
                    System.out.println("                                ");
                } else {
                    System.out.println("            PROYECTO            ");
                    ProyectoGrado pg = (ProyectoGrado) lm;
                    pg.Mostrar();
                    System.out.println("                                ");
                }
            }
        }
    }
    
    public void Buscar() {
        System.out.print("Ingrese el TITULO del Libro o Proyecto : ");
        String titulo = leer.nextLine();
        System.out.println("");
        boolean vf = false;

        for (MaterialBibliografico bm : ListaMaterial) {
            if (bm.getTitulo().equalsIgnoreCase(titulo)) {
                vf = true;
                System.out.println("            MATERIAL ENCONTRADO...          ");
                System.out.println("");
                bm.Mostrar();
                System.out.println("");
            }
        }
        if (!vf) {
            System.out.println("            EL MATERIAL NO SE ENCUENTRA REGISTRADO          ");
            System.out.println("");
        }
    }
    
    public void Eliminar() {
        System.out.print("Ingrese el TITULO del Proyecto o Libro que se eliminara: ");
        String e = leer.nextLine();
        System.out.println("");
        boolean elim = false;

        for (MaterialBibliografico mb : ListaMaterial) {
            if (mb instanceof Libro) {
                Libro ml = (Libro) mb;
                if (ml.getTitulo().equalsIgnoreCase(e)) {
                    elim = true;
                    ListaMaterial.remove(ml);
                    System.out.println("            EL MATERIAL SE ELIMINO CON EXITO          ");
                    System.out.println("");
                    break;
                }

            } else {
                ProyectoGrado mp = (ProyectoGrado) mb;
                if (mp.getTitulo().equalsIgnoreCase(e)) {
                    ListaMaterial.remove(mp);
                    elim = true;
                    System.out.println("                EL MATERIAL SE ELIMINO CON EXITO            ");
                    System.out.println("");
                    break;
                }

            }

        }

    }

    public void CrearArchivo() {
        Path path = Paths.get("C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoMaterialBibliografico.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("        ARCHIVO CREADO CON EXITO...     ");
                System.out.println("");
            } else {
                System.out.println("        EL ARCHIVO YA EXISTE...     ");
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }

    public void AlmacenarDatos() {
        String location = "C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoMaterialBibliografico.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(ListaMaterial);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


    public void LeerDatos() {
        String location = "C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoMaterialBibliografico.txt";
        try {
            FileInputStream archivo = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                ListaMaterial = (List<MaterialBibliografico>) ois.readObject();
            } else {
                System.out.println("            EL OBJETO ES NULO           ");
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}