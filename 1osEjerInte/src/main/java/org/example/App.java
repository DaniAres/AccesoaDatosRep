package org.example;


import java.util.ArrayList;
import java.util.Calendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Ejercicio6();
    }

    private static void Ejercicio1(){

        int num1=10;
        int num2=5;

        System.out.println("El resultado de la suma es:" + (num1+num2));
        System.out.println("El resultado de la resta es:" + (num1-num2));
        System.out.println("El resultado de la multiplicación es:" + (num1*num2));
        System.out.println("El resultado de la división es:" + (num1/num2));
        System.out.println("El módulo de la división es:" + (num1%num2));
    }

    private static void Ejercicio2(){
        int cont;

        for (cont=1; cont<=100; cont++){
            System.out.print(cont+",");
        }
    }

    private static void Ejercicio3(){
        //obtener
        Calendar car = Calendar.getInstance();

        int diaSemana = car.get(Calendar.DAY_OF_WEEK);

        switch (diaSemana){
            case 1: System.out.println("Hoy es domingo"); break;
            case 2: System.out.println("Hoy es lunes"); break;
            case 3: System.out.println("Hoy es martes"); break;
            case 4: System.out.println("Hoy es miércoles"); break;
            case 5: System.out.println("Hoy es jueves"); break;
            case 6: System.out.println("Hoy es viernes"); break;
            case 7: System.out.println("Hoy es sábado"); break;
            default: System.out.println("ERROR"); break;
        }
    }

    private static void Ejercicio4(){

        ArrayList<String> listaA = new ArrayList<String>();
        ArrayList<String> listaB = new ArrayList<String>();

        listaA.add("blanco");
        listaA.add("verde");
        listaA.add("amarillo");

        listaB.add("morado");
        listaB.add("verde");
        listaB.add("amarillo");

        for(String element : listaB){
            if(!listaA.contains(element)){
                System.out.println(element+" no existe en lista A");
            }
        }

        for(String element : listaA){
            if(!listaB.contains(element)){
                System.out.println(element+" no existe en lista B");
            }
        }

    }

    private static void Ejercicio5(){

        coche objCoche= new coche(40, 4);
        System.out.println("Mi coche va a "+objCoche.getVelocidad()
        +" kms/hora y tiene "+objCoche.getNumRuedas()+" ruedas");
    }

    private static void Ejercicio6(){

        Volador objVolador = new Gaviota();
        objVolador.volar();
    }



}
