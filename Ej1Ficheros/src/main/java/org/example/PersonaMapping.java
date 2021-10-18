package org.example;

import java.io.*;
import java.util.ArrayList;

public class PersonaMapping {

    public static void escribirPersona(){

        Persona persona1 = new Persona("Alex", "Castañeda", "23/2/1999");
        Persona persona2 = new Persona("Pepe", "García", "26/3/1999");
        Persona persona3 = new Persona("Dani", "Ares", "19/4/1999");

        ArrayList<Persona> listaPersonas = new ArrayList<Persona>();

            listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);

            FileOutputStream fileout= null;
            ObjectOutputStream objout = null;


            //Escribir
            try {
                fileout = new FileOutputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Persona.txt");
                objout = new ObjectOutputStream(fileout);

                for(Persona p : listaPersonas){
                    objout.writeObject(p);
                }
                } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(fileout!=null) fileout.close();
                    if(objout!=null) objout.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
    }

    public static void leerPersona(){

        FileInputStream filein = null;
        ObjectInputStream objin = null;

        try{
            filein = new FileInputStream("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Ej1Ficheros\\Persona.txt");
            objin = new ObjectInputStream(filein);

            while(true){
                try{
                    Persona obj =(Persona) objin.readObject();
                    System.out.println("Se ha leido el objeto del fichero: " +obj.getNombre()+ " "+obj.getApellidos()+" "+obj.getFechaNac());
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if(filein!=null) filein.close();
                if (objin!=null) objin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
