package modelo;

public class Producto {
	private int idProducto;
	private	String descripcion;
	private	double preciounitario;
	public Producto(int idProducto, String descripcion, double preciounitario) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.preciounitario = preciounitario;
	}
	
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", preciounitario="
				+ preciounitario + "]";
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
		return preciounitario;
	}

	public void setPreciounitario(double preciounitario) {
		this.preciounitario = preciounitario;
	}
	
	
	

}
