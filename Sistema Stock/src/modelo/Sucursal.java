package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	private int idSucursal;
	private String direccion;
	private List<Empleado> lstEmpleados;
	private List<Lote> lstLotes;
	
	public Sucursal(int idSucursal, String direccion) {
		super();
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		lstEmpleados= new ArrayList<Empleado>();
		lstLotes= new ArrayList<Lote>();
	}
	
	
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}
	public List<Lote> getLstLotes() {
		return lstLotes;
	}
	public void setLstLotes(List<Lote> lstLotes) {
		this.lstLotes = lstLotes;
	}
	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", direccion=" + direccion + ", lstEmpleados=" + lstEmpleados
				+ ", lstLotes=" + lstLotes + "]";
	}
	

}
