package Test;
import java.time.LocalDate;
import java.time.LocalTime;

import modelo.*;
public class Test {

	public static void main(String[] args) {
		
		try {
			
			
			System.out.println("---------1--------");
			SistemaSaludDispositivos sys = new SistemaSaludDispositivos();
			sys.agregarEmpresa("Empresa 1");
			sys.agregarEmpresa("Empresa 2");
			
			
			System.out.println("---------2--------");
			System.out.println(sys.traerEmpresa("Empresa 2"));
			
			
			System.out.println("---------3--------");
			sys.agregarDispositivo("Sensor Humedad", "A2020",sys.traerEmpresa("Empresa 1"));
			sys.agregarDispositivo("Sensor Temperatura", "A2325",sys.traerEmpresa("Empresa 1"));
			sys.agregarDispositivo("Sensor Presion", "B2021",sys.traerEmpresa("Empresa 2"));
			sys.agregarDispositivo("Sensor Calor", "B2326",sys.traerEmpresa("Empresa 2"));
			
			
			System.out.println("---------5--------");
			System.out.println(sys.traerDispositivo("B2326"));
			
			
			System.out.println("---------6--------");
			sys.traerDispositivo("B2326").agregarMetrica(18, LocalDate.of(2022, 9, 18), LocalTime.of(10,00));
			sys.traerDispositivo("B2326").agregarMetrica(19, LocalDate.of(2022, 9, 19), LocalTime.of(12,30));
			sys.traerDispositivo("B2326").agregarMetrica(23, LocalDate.of(2022, 9, 20), LocalTime.of(15,00));
			sys.traerDispositivo("B2326").agregarMetrica(20, LocalDate.of(2022, 9, 21), LocalTime.of(18,30));
			sys.traerDispositivo("B2326").agregarMetrica(18, LocalDate.of(2022, 9, 22), LocalTime.of(22,30));
			
			System.out.println("---------7--------");
			System.out.println(sys.traerDispositivo("B2326").traerMetrica(LocalDate.of(2022, 9, 19), LocalTime.of(12, 30)));
			
			System.out.println("---------8--------");
			System.out.println(sys.traerDispositivo("B2326").traerMetricas(LocalDate.of(2022, 9, 19), LocalDate.of(2022, 9, 21)));
			
			System.out.println("---------9--------");
			System.out.println(sys.traerDispositivo("B2326").traerMetricas(sys.traerDispositivo("B2326"), LocalDate.of(2022, 9, 19),LocalDate.of(2022, 9, 21), 22));
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
		try {	
			
		SistemaSaludDispositivos sys = new SistemaSaludDispositivos();
		sys.agregarEmpresa("Empresa 1");
		sys.agregarEmpresa("Empresa 2");
			System.out.println("---------4--------");
			sys.agregarDispositivo("Sensor Movimiento", "A2021",sys.traerEmpresa("Empresa 1"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
