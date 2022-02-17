package controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Curso;
import service.CursoService;

@Controller
public class EscuelaController {
	
	@Autowired
	CursoService service;
	
	@PostMapping("alta")
	public String agregarCurso(@ModelAttribute("curso") Curso curso) {
		service.addCurso(curso);
		return "inicio";
	}
	@GetMapping("filtroPorFechas")
	public String filtrarPorFechas(@RequestParam("fechaInicial") @DateTimeFormat(pattern = "yyyy-MM-dd")
			Date fechaInicial, @RequestParam("fechaFinal") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFinal,
			HttpServletRequest request) {
		List<Curso> cursos = service.cursosEntreFechas(fechaInicial, fechaFinal);
		request.setAttribute("cursos", cursos);
		return "cursos";
	}
	@GetMapping("filtroPorDuracion")
	public String filtrarPorDuracion(@RequestParam("duracion") int duracion,
			HttpServletRequest request) {
		List<Curso> cursos = service.cursosPorDuracionMax(duracion);
		request.setAttribute("cursos", cursos);
		return "cursos";
		
	}
	@GetMapping("buscarCurso")
	public String buscarCurso(@RequestParam("idCurso") int idCurso,
			HttpServletRequest request) {
		List<Curso> cursos = List.of(service.findCurso(idCurso));
		request.setAttribute("cursos", cursos);
		return "cursos";
	}
	@GetMapping("modificarCursos")
	public String modificarCursos(@RequestParam("porcentaje") int porcentaje,
			@RequestParam("duracionMin") int duracionMin) {
		service.reducirPrecio(porcentaje, duracionMin);
		return "inicio";
	}
	

}
