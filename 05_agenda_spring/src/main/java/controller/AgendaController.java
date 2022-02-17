package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Contacto;
import service.ContactosService;

@Controller
public class AgendaController {
	
	@Autowired
	ContactosService service;
	/*
	@PostMapping("alta")
	public String agregarContacto(@RequestParam("nombre") String nombre, 
			@RequestParam("email") String email, @RequestParam("edad") int edad) {
		service.agregar(nombre,email,edad);
		return "info";
	}
	*/
	@PostMapping("alta")
	public String agregarContacto(@ModelAttribute("contacto") Contacto contacto) {
		service.agregar(contacto);
		return "info";
	}
	@GetMapping("contactos")
	public String getContactos(HttpServletRequest request) {
		List<Contacto> contactos = service.recuperarContactos();
		request.setAttribute("contactos", contactos);
		return "listado";
		
	}
	@GetMapping("baja")
	public String eliminarContactos(@RequestParam("email") String email) {
		service.eliminar(email);
		return "forward:/contactos";
	}
	

}
