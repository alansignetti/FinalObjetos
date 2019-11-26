package modelo;

import java.time.LocalDate;

public class Remito extends Comprobante{
	private String formaDePago;

	public Remito(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, String formaDePago) {
		super(fecha, producto, cantidad, vendedor);
		this.formaDePago = formaDePago;
	}


	@Override
	public String toString() {
		return "Remito [formaDePago=" + formaDePago + ", Fecha=" + getFecha()
				+ ", Producto=" + getProducto().getIdProducto() + ", Cantidad=" + getCantidad() + ", Vendedor="
				+ getVendedor() +"]";
	}




	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
	
	
	
	
	

}
