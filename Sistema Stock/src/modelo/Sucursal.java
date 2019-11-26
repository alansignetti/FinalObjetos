package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
		return "Sucursal [idSucursal=" + idSucursal + ", direccion=" + direccion +"]";
	}

	public Empleado traerEmpleado(long dni) {
		Iterator<Empleado> it = lstEmpleados.iterator();
		int stop=0;
		Empleado e=null;

		while (it.hasNext()&& stop==0) {
			e =  it.next();
			if (e.getDni()==dni) {
				stop=1;
			}
		}
		Empleado devolver=null;
		if (stop==1) {
			devolver=e;
		}

		return devolver;		
	}	

	public boolean agregarEmpleado(String nombre, String apellido, long dni) {
		boolean devolver = false;
		Empleado e = this.traerEmpleado(dni);		

		if (e==null) {
			devolver= lstEmpleados.add(new Empleado(nombre, apellido, dni, new Sucursal(idSucursal, direccion)));		
		}		
		return devolver;	
	}//7



	//10
	public List<Lote> traerLotesActivos(Producto producto){

		List<Lote> listaActivos = new ArrayList<Lote>();
		Iterator<Lote> it=lstLotes.iterator();
		while (it.hasNext()) {
			Lote l =  it.next();
			if (l.getProducto().equals(producto)&& l.isActivo()) {
				listaActivos.add(l);
			}			
		}
		return listaActivos;		
	}
	//9
	public boolean agregarLote(Producto producto, LocalDate fechaAlta, int cantidadInicial) {

		return lstLotes.add(new Lote(new Sucursal(idSucursal, direccion), producto, fechaAlta, cantidadInicial, cantidadInicial, true));

	}


	public int traerCantidad(Producto producto) {
		//		Producto p=this.traerProducto(producto.getIdProducto());
		//		Iterator<Producto>it= lstProductos.iterator();
		Iterator<Lote>it=lstLotes.iterator();
		int cantidad=0;
		while (it.hasNext()) {
			Lote l1 =  it.next();
			if (l1.getProducto().equals(producto)) {
				cantidad +=l1.getCantidadActual();
			}
		}
		return cantidad;		
	}

	public boolean validarConsumo(Producto producto, int cantidad) {	
		return this.traerCantidad(producto)>=cantidad;	
	}

	public Remito generarRemitoDeConsumo(LocalDate fecha, Producto producto, int cantidad,
			Empleado vendedor, String formaDePago) throws Exception{

		Remito devolverRemito=null;		
		boolean cant=this.validarConsumo(producto, cantidad);		
		int cantidadAux=cantidad;		

		if (!cant) {
			throw new Exception("No hay cantidades suficientes del producto");
		}
		Iterator<Lote> it=this.traerLotesActivos(producto).iterator();
		while (it.hasNext()&&cantidadAux>0) {
			Lote lote = it.next();
			//			int cantaux=lote.getCantidadActual();
			if (lote.getCantidadActual()>cantidadAux) {
				lote.setCantidadActual(lote.getCantidadActual()-cantidad);
				cantidadAux=0;			
			}
			if (lote.getCantidadActual()<cantidadAux) {
				cantidadAux -=lote.getCantidadActual();
				lote.setCantidadActual(0);
			}
			if (lote.getCantidadActual()==cantidadAux) {
				cantidadAux=0;
				lote.setCantidadActual(0);
			}
		}			
		devolverRemito=new Remito(fecha, producto, cantidad, vendedor, formaDePago);

		return devolverRemito;		
	}


	public SolicitudStock generarSolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor) {

		SolicitudStock generarSolicitudStock = null;
		if (!this.validarConsumo(producto, cantidad)) {
			generarSolicitudStock=new SolicitudStock(fecha, producto, cantidad, vendedor, null, false);
		}

		return generarSolicitudStock;	
	}

	public void actualizarSolicitudStock(SolicitudStock solicitudStock, long dni, boolean aceptado) {
		solicitudStock.setVendedor(this.traerEmpleado(dni));
		solicitudStock.setAceptado(aceptado);
	}



}
