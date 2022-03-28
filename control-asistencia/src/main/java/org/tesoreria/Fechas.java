package org.tesoreria;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Fechas {
	private LocalDate dias;
	private String dayss;
	public String getDayss() {
		return dayss;
	}
	public void setDayss(String dayss) {
		this.dayss = dayss;
	}
	public LocalDate getDias() {
		return dias;
	}
	public void setDias(LocalDate dias) {
		this.dias = dias;
	}
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		LocalDate hoy = LocalDate.now();
		LocalDate d = LocalDate.parse("2021-04-12");
	
        ArrayList<String> cad = new ArrayList<String>();
       for(int ii = 0;ii<5;ii++) { 
    	   cad.add(d.plusDays(ii).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));    	   
       }
       System.out.println(cad);
       ArrayList<String> guardias= new ArrayList<String>();
       ArrayList<String> vacaciones= new ArrayList<String>();
       String v="";
       String g ="";
       
       String fechasEjemplo = "12/04/2021,13/04/2021";
		//System.out.println("fechasejemplo: "+fechasEjemplo);
		//String[] arrayOfInts = fechasEjemplo.split(",");
		boolean guardia = true;
        for (int k=0 ; k <cad.size();k++) {
     	   boolean esVacacion = true;
     	   for (int j=0 ; j <arrayOfInts.length;j++) {
     		   //System.out.println("valor" + arrayOfInts[j]);
     		   if (arrayOfInts[j].equals(cad.get(k))) {
     			   System.out.println("guardias " + arrayOfInts[j]);
     			   guardias.add(arrayOfInts[j]);
     			   esVacacion = false;
     			   g += arrayOfInts[j] + "," ;
     		   }else {
     			   guardia = false;
     			  
     		   }
     		   
     	   }
     	   if (esVacacion) {
     	   System.out.println("vacacion " + cad.get(k));
     	   vacaciones.add(cad.get(k));
     	   v += cad.get(k) + ",";
     	   }
     	   
        }
        System.out.println("Guardias ");
        g = g.substring(0, g.length()-1); 
        v= v.substring(0, v.length()-1);
       	System.out.println(g);
       	System.out.println("Vacaciones ");
        System.out.println(v);
       
        
       /*
      for(Fechas fe:fechas) {
    	   System.out.println("fech: "+fe.getDayss());
    	   
       }*/
        
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
