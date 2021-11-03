package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static boolean finPartida;

    public static void main(String[] args) throws JAXBException {

        boolean finPartida = false;
        int codigo = 1;

        imprimirCabecera();


        Aventura aventura = leerXML("C:\\Users\\FP\\Documents\\GitHub\\AccesoaDatosRep\\Aventura\\aventura.xml");

        while (!finPartida) {
            Escena escenaAct = imprimirEscena(aventura, codigo);
            if (!finPartida) {
                boolean opcionEncontrada = false;

                Scanner scanner = new Scanner(System.in);
                System.out.println("\nElige la opción: ");
                try {
                    int opcionSel = scanner.nextInt();

                    for (Opcion opcion : escenaAct.getOpciones()) {
                        if (opcion.getId() == opcionSel) {
                            codigo = opcion.getResultado();
                            opcionEncontrada = true;
                        }
                    }
                    System.out.println(finPartida);
                    if (!opcionEncontrada) {
                        System.out.println("OPCION NO ENCONTRADA");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("OPCIÓN NO VÁLIDA");
                }
            }
        }
    }

    private static Escena imprimirEscena(Aventura aventura, int codigo) {

        Escena resultado = new Escena();

        ArrayList<Escena> escenas = aventura.getEscenas();
        for (Escena e : escenas) {

            if (e.getCodigo() == codigo) {
                resultado = e;
                System.out.println(e.getTexto());

                if (e.getOpciones() == null || e.getOpciones().isEmpty()) {
                    finPartida = true;
                    System.out.println("FIN DE LA PARTIDA");

                } else {
                    for (Opcion o : e.getOpciones()) {
                        System.out.println(o.getId() + "-" + o.getTexto());
                    }
                }

            }


        }

        if (resultado == null) {
            finPartida = true;
        }

        return resultado;
    }

    private static void imprimirCabecera() {

        System.out.println("Bienvenido a AVENTURA. Para avanzar en la historia, escriba la opción deseada y pulse ENTER.");

    }

    private static Aventura leerXML(String ruta) throws JAXBException {
        Aventura aventura = new Aventura();
        File file = new File(ruta);
        ArrayList<Escena> listaescenas = new ArrayList<Escena>();
        if (file.exists()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Aventura.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            aventura = (Aventura) jaxbUnmarshaller.unmarshal(file);
            listaescenas = (aventura != null ? aventura.getEscenas() : new ArrayList<Escena>());
        } else {
            System.out.println("No se ha podido leer el fichero indicado");
        }
        //System.out.println(listaescenas);
        return aventura;
    }

}
