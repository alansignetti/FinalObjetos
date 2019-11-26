package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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



	//	1 +traerProducto(String descripcion): Producto			
	//	2 +agregarProducto(String descripcion, double precioUnitario): boolean	
	//	Exception si la descripcion ya existe para otro producto			
	//	3 +traerSucursal(String direccion): Sucursal			
	//	4 +agregarSucursal(String direcc1on) boolean			
	//	Exception si la dirección ya existe
	//	5. +traerSucursal(int idSucursal): Sucursal


	public Producto traerProducto(String descripcion) {
		Iterator<Producto> it = lstProductos.iterator();
		int stop=0;
		Producto p=null;

		while (it.hasNext() && stop==0) {
			Producto producto =  it.next();
			if (producto.getDescripcion().equalsIgnoreCase(descripcion)) {
				stop=1;
				p=producto;
			}
		}
		Producto devolver=null;
		if (stop==1) {
			devolver=p;
		}
		return devolver;		
	}

	//8 
	public Producto traerProducto(int idProducto) {
		Iterator<Producto> it = lstProductos.iterator();
		int stop=0;
		Producto p=null;

		while (it.hasNext() && stop==0) {
			Producto producto =  it.next();
			if (producto.getIdProducto()==idProducto) {
				stop=1;
				p=producto;
			}
		}
		Producto devolver=null;
		if (stop==1) {
			devolver=p;
		}
		return devolver;
	}

	public boolean agregarProducto(String descripcion, double precioUnitario) throws Exception{
		boolean devolver=false;
		Producto p=this.traerProducto(descripcion);

		int id=1;
		if (lstProductos.size() !=0) {
			id=lstProductos.get(lstProductos.size()-1).getIdProducto()+1;
		}		

		if (p==null) {
			devolver=lstProductos.add(new Producto(id, descripcion, precioUnitario));
		}
		else
			throw new Exception("La descripcion ya existe para otro producto");		
		return devolver;		
	}


	public Sucursal traerSucursal(String direccion) {
		Iterator<Sucursal> it = lstSucursal.iterator();
		int stop=0;
		Sucursal s=null;

		while (it.hasNext() && stop==0) {
			s = it.next();
			if (s.getDireccion().equalsIgnoreCase(direccion)) {
				stop=1;	

			}
		}

		Sucursal devolver=null;
		if (stop==1) {
			devolver=s;
		}
		return devolver;
	}


	public boolean agregarSucursal(String direccion) throws Exception{
		boolean devolver = false;
		Sucursal s=this.traerSucursal(direccion);
		int id=1;

		if (lstSucursal.size()!=0) {
			id=lstSucursal.get(lstSucursal.size()-1).getIdSucursal()+1;
		}

		if (s==null) {
			devolver=lstSucursal.add(new Sucursal(id, direccion));
		}
		else 
			throw new Exception("la direccion ya existe");	

		return devolver;
	}


	public Sucursal traerSucursal(int idSucursal) {
		Iterator<Sucursal> it = lstSucursal.iterator();
		int stop=0;
		Sucursal s=null;

		while (it.hasNext() && stop==0) {
			s = it.next();
			if (s.getIdSucursal()==idSucursal) {
				stop=1;	

			}
		}
		Sucursal devolver=null;
		if (stop==1) {
			devolver=s;
		}
		return devolver;
	}

	public Remito generarRemitoDeConsumo(Sucursal sucursal,LocalDate fecha, Producto producto, int cantidad,
			Empleado vendedor, String formaDePago) throws Exception{

		Remito devolverRemito=null;		
		boolean cant=sucursal.validarConsumo(producto, cantidad);		
		int cantidadAux=cantidad;		

		if (!cant) {
			throw new Exception("No hay cantidades suficientes del producto");
		}
		Iterator<Lote> it=sucursal.traerLotesActivos(producto).iterator();
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

	public List<Sucursal>validarConsumo(Producto producto, int cantidad){
		Iterator<Sucursal> it=lstSucursal.iterator();
		List<Sucursal> listaValida=new ArrayList<Sucursal>();
		Sucursal s=null;
		while (it.hasNext()) {
			s = it.next();
			if (s.validarConsumo(producto, cantidad)) {
				listaValida.add(s);
			}			
		}

		return listaValida;		
	}
	
	

	/*
6. *public boolean agregarEmpleado(String nombre, String apellido, long dni)
7. *public Empleado traerEmpleado(long dni)
8. *public Producto traerProducto(int idProducto)
9. *public boolean aregarLote(Producto producto, LocalDate fechaAlta, int cantidadInicial)
10. *public List<Lote> traerLotesActivos(Producto producto)
11. *public int traerCantidad(Producto producto)
12. *public boolean validarConsumo(Producto producto, int cantidad)
13. *public Remito generarRemitoDeConsumo(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, String formaDePago)
	Exception no se puede generarel nuevo remito si no hay cantidades del producto
14. *public Remito generarRemitoDeConsumo(Sucursal sucursal,LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, String formaDePago)
15. *public SolicitudStock generarSolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor)
16. *public List<Sucursal>validarConsumo(Producto producto, int cantidad)
17. *public void actualizarSolicitudStock(SolicitudStock solicitudStock, long dni, boolean aceptado)

	 */

}
