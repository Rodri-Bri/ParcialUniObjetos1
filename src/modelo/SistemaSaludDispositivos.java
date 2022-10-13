package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaSaludDispositivos {
	private List<Empresa> lstEmpresas;
	private List<Dispositivo> lstDispositivos;
	
	public SistemaSaludDispositivos() {
		this.lstEmpresas = new ArrayList<Empresa>();
		this.lstDispositivos = new ArrayList<Dispositivo>();
	}

	
	//GETTERS AND SETTERS
	public List<Empresa> getLstEmpresas() {
		return lstEmpresas;
	}

	public void setLstEmpresas(List<Empresa> lstEmpresas) {
		this.lstEmpresas = lstEmpresas;
	}

	public List<Dispositivo> getLstDispositivos() {
		return lstDispositivos;
	}

	public void setLstDispositivos(List<Dispositivo> lstDispositivos) {
		this.lstDispositivos = lstDispositivos;
	}
	
	//METODOS
	public boolean agregarEmpresa(String nombre) {
		boolean bandera=false;
		if(lstEmpresas.size() == 0) {
			Empresa e = new Empresa(1,nombre);
			bandera = lstEmpresas.add(e);
		}else {
			int maxId = lstEmpresas.get(lstEmpresas.size()-1).getId()+1;
			Empresa e = new Empresa(maxId, nombre);
			bandera = lstEmpresas.add(e);
		}
		
		return bandera;
	}
	
	public Empresa traerEmpresa(String nombre) {
		
		boolean bandera = false;
		int i=0;
		Empresa empresaRetorno = null;
		while (bandera == false && i < lstEmpresas.size()) {
			if(lstEmpresas.get(i).getNombre().equals(nombre)) {
				empresaRetorno = lstEmpresas.get(i);
				bandera=true;
			}else {
				i++;
			}
		}
		return empresaRetorno;
	}
	
	
	public boolean agregarDispositivo(String nombre, String codigo, Empresa empresa) throws Exception {
		boolean bandera=false;
		if(lstDispositivos.size() == 0) {
			Dispositivo d = new Dispositivo(1,nombre,codigo,empresa);
			bandera = lstDispositivos.add(d);
		}else {
			int maxId = lstDispositivos.get(lstDispositivos.size()-1).getId()+1;
			Dispositivo d = new Dispositivo(maxId,nombre,codigo,empresa);
			bandera = lstDispositivos.add(d);
		}
		
		return bandera;
	}

	public Dispositivo traerDispositivo(String codigo) {
		boolean bandera = false;
		int i=0;
		int pos=-1;
		while(bandera == false && lstDispositivos.size() > i) {
			if(lstDispositivos.get(i).getCodigo().equals(codigo)) {
				bandera=true;
				pos=i;
			}else {
				i++;
			}
		}
		return lstDispositivos.get(pos);
	}
	
	
	
	@Override
	public String toString() {
		return "SistemaSaludDispositivos [lstEmpresas=" + lstEmpresas + ", lstDispositivos=" + lstDispositivos + "]";
	}
	
	
}
