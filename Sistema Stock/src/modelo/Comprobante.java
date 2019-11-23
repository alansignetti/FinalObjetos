package modelo;

import java.time.LocalDate;

public abstract class Comprobante {
	private LocalDate fecha;
	private Producto producto;
	private int cantidad;
	private Empleado vendedor;
	public Comprobante(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor) {
		super();
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
	}
	
	
	@Override
	public String toString() {
		return "Comprobante [fecha=" + fecha + ", producto=" + producto + ", cantidad=" + cantidad + ", vendedor="
				+ vendedor + "]";
	}


	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Empleado getVendedor() {
		return vendedor;
	}
	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}
	
	

}
