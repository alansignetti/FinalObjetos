package modelo;

import java.util.ArrayList;
import java.util.List;

public class SistemaStock {
	List<Producto> lstProductos;
	List<Comprobante> lstComprobante;
	List<Sucursal> lstSucursal;
	public SistemaStock() {
		super();
		lstProductos = new ArrayList<Producto>();
		lstComprobante = new ArrayList<Comprobante>();
		lstSucursal = new ArrayList<Sucursal>();
		}
	@Override
	public String toString() {
		return "SistemaStock [lstProductos=" + lstProductos + ", lstComprobante=" + lstComprobante + ", lstSucursal="
				+ lstSucursal + "]";
	}
	public List<Producto> getLstProductos() {
		return lstProductos;
	}
	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}
	public List<Comprobante> getLstComprobante() {
		return lstComprobante;
	}
	public void setLstComprobante(List<Comprobante> lstComprobante) {
		this.lstComprobante = lstComprobante;
	}
	public List<Sucursal> getLstSucursal() {
		return lstSucursal;
	}
	public void setLstSucursal(List<Sucursal> lstSucursal) {
		this.lstSucursal = lstSucursal;
	}
	
	
	
}
