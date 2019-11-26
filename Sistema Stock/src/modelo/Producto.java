package modelo;

public class Producto {
	private int idProducto;
	private	String descripcion;
	private	double precioUnitario;
	public Producto(int idProducto, String descripcion, double precioUnitario) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}
	
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precioUnitario="
				+ precioUnitario + "]";
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPreciounitario() {
		return precioUnitario;
	}

	public void setPreciounitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	

}
