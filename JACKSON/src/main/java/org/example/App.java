package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    ejercicioJACKSON();
    }
    //ejercicioJACKSONlectura
    private static void ejercicioJACKSON(){

        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Delegado> lista = mapper.readValue(new File("C:\\Users\\FP\\Desktop\\listaAlumnos.json"),
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Delegado.class));

        for(Delegado m : lista){

        System.out.println(m.getNombre()+"-"+m.getEdad()+"-"+m.getNotaMedia()+"-"+m.getCiclo()+"-"+m.getCurso());
        }
    } catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void ejercicioJACKSONEsc(){

        ArrayList<Delegado> mascotasLista = new ArrayList<>();
        mascotasLista.add(new Delegado("Paco", 20, 6.5, "DAM", 2));
        mascotasLista.add(new Delegado("Marta", 22, 9,"DAW", 1));

        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
