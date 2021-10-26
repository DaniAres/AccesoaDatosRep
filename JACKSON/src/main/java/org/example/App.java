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
    ejercicioJACKSONEsc();
    }
    //ejercicioJACKSONlectura
    private static void ejercicioJACKSON(){

        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Delegado> lista = mapper.readValue(new File("C:\\Users\\FP\\Desktop\\listaAlumnos.json"),
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Delegado.class));

        for(Delegado m : lista){

        System.out.println(m.getId()+"-"+m.getNombre()+"-"+m.getEdad()+"-"+m.getNotaMedia()+"-"+m.getCiclo()+"-"+m.getCurso());
        }
    } catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void ejercicioJACKSONEsc(){

        ArrayList<Delegado> mascotasLista = new ArrayList<>();
        mascotasLista.add(new Delegado(1,"Paco", 20, 6.5, "DAM", 2));
        mascotasLista.add(new Delegado(2,"Marta", 22, 9,"DAW", 1));

        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\Users\\FP\\Desktop\\listaAlumnosEsc.json"), mascotasLista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
