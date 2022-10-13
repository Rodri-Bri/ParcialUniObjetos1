package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dispositivo {
	private int id;
	private String nombre;
	private String codigo;
	private List<Metrica> lstMetricas;
	private Empresa empresa;
	
	//CONSTRUCTOR
	public Dispositivo(int id, String nombre, String codigo, Empresa empresa) throws Exception {
		super();
		this.id = id;
		this.nombre = nombre;
		setCodigo(codigo);
		this.lstMetricas = new ArrayList<Metrica>();
		this.empresa = empresa;
	}

	
	//GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if(codigo.length() != 5)throw new Exception("El codigo es menor o mayor a 5");
		if(codigo.charAt(0) != 'A' && codigo.charAt(0) != 'B') throw new Exception ("No empieza ni con A ni B");
		
		int suma=0;
		char array[] = {'0','1','2','3','4','5','6','7','8','9'};
		int array2[] = {0,1,2,3,4,5,6,7,8,9};
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				if(array[j] == codigo.charAt(i)) {
					suma = array2[j] + suma;
				}
			}
		}
		
		if(codigo.charAt(0) == 'A'  && suma % 2 != 0) throw new Exception ("El codigo no es par");
		if(codigo.charAt(0) == 'B'  && suma % 2 == 0) throw new Exception ("El codigo es par");
		
		this.codigo = codigo;
	}

	public List<Metrica> getLstMetricas() {
		return lstMetricas;
	}

	public void setLstMetricas(List<Metrica> lstMetricas) {
		this.lstMetricas = lstMetricas;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", lstMetricas=" + lstMetricas
				+ ", empresa=" + empresa + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dispositivo other = (Dispositivo) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public boolean agregarMetrica(int valor, LocalDate fecha, LocalTime hora){
	return lstMetricas.add(new Metrica(valor, fecha, hora));
	}

	public Metrica traerMetrica(LocalDate fecha, LocalTime hora) {
		boolean bandera = false;
		int i=0;
		Metrica metricaRetorno = null;
		while(bandera == false && i < lstMetricas.size()) {
			if(fecha.equals(lstMetricas.get(i).getFecha()) && hora.equals(lstMetricas.get(i).getHora())) {
				bandera = true;
				metricaRetorno = lstMetricas.get(i);
			}else {
				i++;
			}
		}
		return metricaRetorno;
	}
	
	public Metrica traerMetrica(LocalDate fecha) {
		boolean bandera = false;
		int i=0;
		Metrica metricaRetorno = null;
		while(bandera == false && i < lstMetricas.size()) {
			if(fecha.equals(lstMetricas.get(i).getFecha())) {
				bandera = true;
				metricaRetorno = lstMetricas.get(i);
			}else {
				i++;
			}
		}
		return metricaRetorno;
	}
	
	public List<Metrica> traerMetricas(LocalDate desde, LocalDate hasta) {
		List <Metrica> lstMetricaRetorno = new ArrayList<Metrica>();
		hasta = hasta.plusDays(1);
		
		while(!desde.equals(hasta)) {
			if(traerMetrica(desde) != null) {	
				lstMetricaRetorno.add(traerMetrica(desde));
			}
			desde = desde.plusDays(1);
		}
		
		return lstMetricaRetorno;
	}
	
	public List<Metrica> traerMetricas(Dispositivo dispositivo, LocalDate desde, LocalDate hasta, int menorAValor){
		List <Metrica> lstMetricaRetorno = new ArrayList<Metrica>();
		lstMetricaRetorno = traerMetricas(desde,hasta);
	
		boolean bandera = false;
		int i = 0;
		hasta = hasta.plusDays(1);
		while (bandera == false && !desde.equals(hasta)) {
			if(traerMetrica(desde).getValor() > menorAValor) {
				lstMetricaRetorno.remove(i);
			}
			i++;
			desde = desde.plusDays(1);
		}
		return lstMetricaRetorno;
	}
	
}



