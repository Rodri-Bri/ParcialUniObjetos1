package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {

	public static boolean esBisiesto(int anio) {
		boolean bandera=false;
		if(anio % 4 == 0 && anio % 100 != 0) {
			bandera=true;
		}else if(anio % 4 == 0 && anio % 100 == 0 && anio % 400 == 0) {
			bandera=true;
		} 
		return bandera;
	}
	/*
	public static boolean esFechaValida(LocalDate fecha) {
		if(esBisiesto(fecha.getYear())) {
			
		}
	}
	*/
	
	public static String traerFechaCorta(LocalDate fecha) {
		return fecha.getDayOfMonth() +"/" + fecha.getMonthValue()+"/"+ fecha.getYear();
	}
	
	public static String traerHoraCorta(LocalTime hora) {
		return hora.getHour() + ":" + hora.getMinute();
	}
	
	public static boolean esDiaHabil(LocalDate fecha) {
		return (fecha.getDayOfWeek().getValue() >= 1 && fecha.getDayOfWeek().getValue() <= 5);
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String diaDeSemana[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		return diaDeSemana[fecha.getDayOfWeek().getValue()-1];
	}
	
	public static String traerMesEnLetras(LocalDate fecha) {
		String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"}; 
		return meses[fecha.getMonthValue()-1];
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		return traerDiaDeLaSemana(fecha) + " " + fecha.getDayOfMonth() + " de " + traerMesEnLetras(fecha) + " del " + fecha.getYear(); 
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		int cantDias=0;
		if(mes == 1) {
			cantDias=31;
		}else if(mes == 2 && esBisiesto(anio)) {
			cantDias=29;
		}else if(mes == 2 && esBisiesto(anio) == false) {
			cantDias=28;
		}else if(mes == 3) {
			cantDias=31;
		}else if(mes == 4) {
			cantDias=30;
		}else if(mes == 5) {
			cantDias=31;
		}else if(mes == 6) {
			cantDias=30;
		}else if(mes == 7) {
			cantDias=31;
		}else if(mes == 8) {
			cantDias=31;
		}else if(mes == 9) {
			cantDias=30;
		}else if(mes == 10) {
			cantDias=31;
		}else if(mes == 11) {
			cantDias=30;
		}else if(mes == 12) {
			cantDias=31;
		}
		return cantDias;
	}
	
	public static double aproximar2Decimal(double valor) {
		return Math.round(valor*100.0)/100.0;
	}
	
	public static boolean esNumero(char c) {
		boolean bandera=false;
		int i=0;
		char array[] = {'0','1','2','3','4','5','6','7','8','9'};
		while(bandera == false && array.length > i) {
			if(array[i] == c) {
				bandera=true;
			}else {
				i++;
			}
		}		
		return bandera;
	}
	
	public static boolean esLetra(char c) {
		boolean bandera=false;
		int i=0;
		char []arrayChar= {'a', 'b', 'c', 'd', 'e','f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		while(bandera == false && arrayChar.length > i) {
			if(arrayChar[i] == c) {
				bandera=true;
			}else {
				i++;
			}
		}
		return bandera;
	}
	
	public static boolean esCadenaNros(String cadena) {
		int i=0;
		boolean bandera=false;
		while(cadena.length() > i && bandera == false) {
			if(esNumero(cadena.charAt(i))) {
				bandera=true;
			}else {
				i++;
			}
		}
		return bandera;
	}
	public static boolean esCadenaLetras(String cadena) {
		return !esCadenaNros(cadena);
	}
	
}

