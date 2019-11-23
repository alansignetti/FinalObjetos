package modelo;

import java.time.LocalDate;

public class Lote {
	private Sucursal sucursal;
	private Producto producto;
	private LocalDate fechaAlta;
	private int cantidadInicial;
	private int cantidadActual;
	private boolean activo;
	
	public Lote(Sucursal sucursal, Producto producto, LocalDate fechaAlta, int cantidadInicial, int cantidadActual,
			boolean activo) {
		super();
		this.sucursal = sucursal;
		this.producto = producto;
		this.fechaAlta = fechaAlta;
		this.cantidadInicial = cantidadInicial;
		this.cantidadActual = cantidadActual;
		this.activo = activo;
	}
	@Override
	public String toString() {
		return "Lote [sucursal=" + sucursal + ", producto=" + producto + ", fechaAlta=" + fechaAlta
				+ ", cantidadInicial=" + cantidadInicial + ", cantidadActual=" + cantidadActual + ", activo=" + activo
				+ "]";
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public int getCantidadInicial() {
		return cantidadInicial;
	}
	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}
	public int getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

}
