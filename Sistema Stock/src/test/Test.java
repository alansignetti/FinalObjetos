package test;

import java.time.LocalDate;

import modelo.SistemaStock;

public class Test {

	public static void main(String[] args) {
		SistemaStock s= new SistemaStock();
		try {
			System.out.println("1--Agregar e imprimir productos--");
			s.agregarProducto("Producto A", 40.5);
			s.agregarProducto("Producto B", 65.5);
	
			System.out.println(s.traerProducto("Producto A"));
			System.out.println(s.traerProducto("Producto B"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("2--Agregar e imprimir sucursales--");
			s.agregarSucursal("Direccion A");
			s.agregarSucursal("Direccion B");
	
			System.out.println(s.traerSucursal("Direccion A"));
			System.out.println(s.traerSucursal("Direccion B"));			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("3--Agregar e imprimir empleados--");
		s.traerSucursal(1).agregarEmpleado("Jose", "Gomez", 11111);
		s.traerSucursal(2).agregarEmpleado("Felipe", "Suarez", 22222);
		
		System.out.println(s.traerSucursal(1).traerEmpleado(11111));
		System.out.println(s.traerSucursal(2).traerEmpleado(22222));
		
		System.out.println("4--Agregar e imprimir lotes--");		
		s.traerSucursal(1).agregarLote(s.traerProducto(1), LocalDate.of(2019, 10, 1), 100);
		s.traerSucursal(1).agregarLote(s.traerProducto(2), LocalDate.of(2019, 10, 1), 50);
		s.traerSucursal(1).agregarLote(s.traerProducto(1), LocalDate.of(2019, 10, 3), 40);
		s.traerSucursal(2).agregarLote(s.traerProducto(1), LocalDate.of(2019, 10, 2), 80);
		s.traerSucursal(2).agregarLote(s.traerProducto(2), LocalDate.of(2019, 10, 2), 80);		
		
		System.out.println(s.traerSucursal(1).traerLotesActivos(s.traerProducto(2)));
		System.out.println(s.traerSucursal(2).traerLotesActivos(s.traerProducto(2)));
		
		
		System.out.println("5--Cantidad total producto 1 de sucursal 1--");
		System.out.println(s.traerSucursal(1).traerCantidad(s.traerProducto(1)));
		
		
		System.out.println("6--Validar si se pueden retirar 80 del prod 1 sucursal 1--");
		System.out.println(s.traerSucursal(1).validarConsumo(s.traerProducto(1), 80));
		
		
		
		try {
			
			System.out.println("7--Generar Remito--");
			System.out.println(s.traerSucursal(1).generarRemitoDeConsumo(LocalDate.of(2019, 10, 5), 
					s.traerProducto(1), 80, s.traerSucursal(1).traerEmpleado(11111), "FormaDePago 1"));
			
			System.out.println("8--Tratar Generar Remito--");			
			System.out.println(s.traerSucursal(1).generarRemitoDeConsumo(LocalDate.of(2019, 10, 6), 
					s.traerProducto(1),80, s.traerSucursal(1).traerEmpleado(11111), "FormaDePago 1"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		System.out.println("9--Generar Solicitud Stock--");	
		System.out.println(s.traerSucursal(1).generarSolicitudStock(LocalDate.of(2019, 10, 5), s.traerProducto(1), 70, s.traerSucursal(1).traerEmpleado(11111)));
		
		
		System.out.println("10--Obtener lista de sucursales que si tienen stock--");	
		System.out.println(	s.validarConsumo(s.traerProducto(1),80));

		System.out.println("11--Actualizar solicitudStock vendedor 22222--");
		s.traerSucursal(1).actualizarSolicitudStock(s.traerSucursal(1).generarSolicitudStock(LocalDate.of(2019, 10, 5),
				s.traerProducto(1), 70, s.traerSucursal(1).traerEmpleado(11111)), 22222, true);
		

	}

}
