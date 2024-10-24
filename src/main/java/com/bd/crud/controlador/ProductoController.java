package com.bd.crud.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.crud.modelo.ClassProducto;
import com.bd.crud.servicio.IProductoServicio;

@Controller
@RequestMapping("/Vistas")
public class ProductoController {
	//inyeccion de dependencia
	@Autowired
	private IProductoServicio iproductoservicio;
	@GetMapping("ListadoProductos")
	public String ListadoProducto(Model modelo) {
		//recuperamos los datos de la bd...
		List<ClassProducto> listado=iproductoservicio.ListadoProductos();
		//enviamos hacia la vista
		modelo.addAttribute("listado",listado);
		//retornamos
		return "/Vistas/ListadoProductos";		
	}   //fin del metodo listado producto...
	
	//creamos los respectivos metodos para registrar datos..
	   @GetMapping("/RegistrarProducto")
	   public String RegistrarProducto(Model modelo) {
		   //realizamos la respectiva instancia..
		   ClassProducto clproducto=new ClassProducto();
		   //enviamos hacia la vista
		   modelo.addAttribute("regproducto",clproducto);
		   //retornamos
		   return "/Vistas/FrmRegProducto";
	   }  //fin del metodo registrar...
	   
	   //realizamos el mapeo con postmapping..
	   @PostMapping("/GuardarProduto")
	   public String GuardarProducto(@ModelAttribute ClassProducto clprod,
			   Model modelo) {	   
		   iproductoservicio.RegistrarProducto(clprod);
		   //emitimos mensaje por consola
		   System.out.println("datos registrado en bd");
		   //retornamos al listado
		   return "redirect:/Vistas/ListadoProductos";
		   
	   }   //fin del metodo guardar producto...
	   
	   //creamos el metodo editar..
	   @GetMapping("/editarproducto/{id}")
	   public String Editar(@PathVariable("id") Integer idproducto,
			   Model modelo) {
		   ClassProducto clproducto=iproductoservicio.BuscarporId(idproducto);
		   //enviamos hacia vista
		   modelo.addAttribute("regproducto",clproducto);
		   //enviamos al frmregproducto..
		   return "/Vistas/FrmRegProducto";
		   
	   }   //fin del metodo editar..
	   //creamos el metodo eliminar...
	   @GetMapping("/eliminarproducto/{id}")
	   public String eliminar(@PathVariable("id") Integer idproducto,
			   Model modelo) {
		   //aplicamos la inyeccion de dependencia
		   iproductoservicio.EliminarProducto(idproducto);
		   //actualizar el listado
		   List<ClassProducto> listado=iproductoservicio.ListadoProductos();
		   //enviamos hacia la vista
		   modelo.addAttribute("listado", listado);
		   //redireccionamos
		   return "redirect:/Vistas/ListadoProductos";
		   
	   }//fin del metodo eliminar...
     
}//fin de la clase.....
