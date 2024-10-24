package com.bd.crud.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.crud.modelo.ClassProducto;
import com.bd.crud.repositorio.IProductoRepository;

@Service
public class ClassProductoServicioImp implements IProductoServicio {

	//aplicamos la inyeccion de dependencia...
	@Autowired
	private IProductoRepository iproductorepository;
	
	
	@Override
	public void RegistrarProducto(ClassProducto clproducto) {
		//invocamos el metodo guardar...
		iproductorepository.save(clproducto);
		
	}   //fin del metodo registrar....

	@Override
	public void EliminarProducto(Integer id) {
		//invocamos el metodo eliminar...
		iproductorepository.deleteById(id);
		
	} //fin del metodo eliminar...

	@Override
	public List<ClassProducto> ListadoProductos() {
		//invocamos el metodo listado
		return (List<ClassProducto>) iproductorepository.findAll();
	}   //fin del metodo listado....

	@Override
	public ClassProducto BuscarporId(Integer id) {
		//invocamos el metodo buscar por codigo...
		return iproductorepository.findById(id).orElse(null);
	}   //fin del metodo buscar....

}  //fin de la clase imp....
