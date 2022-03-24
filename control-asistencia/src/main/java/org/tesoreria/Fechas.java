package org.tesoreria;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Fechas {
	public static void main(String[] args) throws ParseException {
		//12/04/2021' '16/04/2021'
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		//Date firstDate = format.parse("30/07/1992");
		Date fecha_inicio = (Date) format.parse("12/04/2021");
		System.out.println("fecha inicio: "+ fecha_inicio);
		/*
        String periodo[] ={"1","2","3","4", "5", "6","7","8","9","10"};
        String p = Arrays.toString(periodo);
        System.out.println("periodo: "+p);
		String fechasEjemplo = "1,3,4,5,8";
		//System.out.println("fechasejemplo: "+fechasEjemplo);
		String[] arrayOfInts = fechasEjemplo.split(",");
        String arrayToString = Arrays.toString(arrayOfInts);
        System.out.println("fechas seleccionadas: "+arrayToString);
       String newFecha = p.replaceAll(arrayToString, "");
       char[] aCaracteres = newFecha.toCharArray();
       System.out.println("Nueva fecha: "+newFecha + arrayOfInts.length);
      ArrayList<String> vacaciones= new ArrayList<String>();
      ArrayList<String> guardias= new ArrayList<String>();
      String v="";
      String g ="";
       for (int i=0 ; i < periodo.length;i++) {
    	   boolean esGuardia = true;
    	   for (int j=0 ; j <arrayOfInts.length;j++) {
    		   //System.out.println("valor" + arrayOfInts[j]);
    		   if (arrayOfInts[j].equals(periodo[i])) {
    			   System.out.println("vaciones " + arrayOfInts[j]);
    			   vacaciones.add(arrayOfInts[j]);
    			   esGuardia = false;
    			   v += arrayOfInts[j] + "," ;
    		   }
    		   
    	   }
    	   if (esGuardia) {
    	   System.out.println("guardia " + periodo[i]);
    	   guardias.add(periodo[i]);
    	   g += periodo[i] + ",";
    	   }
    	   
       }
       
       System.out.println(v);
       System.out.println(g);
        */
    }
}
