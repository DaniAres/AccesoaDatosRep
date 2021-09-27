package org.example;

public class coche extends  vehiculo{

   private int numRuedas=4;

   public coche(int velocidad, int numRuedas){
       super (velocidad);
       this.numRuedas = numRuedas;
   }

   public int getNumRuedas(){
       return numRuedas;
   }

   public void setNumRuedas (int numRuedas) {
       this.numRuedas = numRuedas;
   }







}
