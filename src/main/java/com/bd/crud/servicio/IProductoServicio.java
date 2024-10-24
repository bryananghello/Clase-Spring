package com.bd.crud.servicio;

import java.util.List;

import com.bd.crud.modelo.ClassProducto;

public interface IProductoServicio {
	//declaramos los metodos
	public void RegistrarProducto(ClassProducto clproducto);
	public void EliminarProducto(Integer id);
	public List<ClassProducto> ListadoProductos();
	public ClassProducto BuscarporId(Integer id);
	

}  //fin de la interface...
