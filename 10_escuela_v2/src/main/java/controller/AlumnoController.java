package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Alumno;
import model.Curso;
import service.AlumnoService;
import service.CursoService;

@Controller
public class AlumnoController {
	
	@Autowired
	CursoService cursoService;
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping("alumnos")
	public String cargaCursosPaginaAlumnos(HttpServletRequest request) {
		List<Curso> cursos = cursoService.getAll();
		request.setAttribute("cursos", cursos);
		return "alumnos"; 
	}
	@GetMapping("alumnosPorCurso")
	public String cargaPaginaAlumnos(@RequestParam("idCurso") int idCurso, HttpServletRequest request) {
		
		
		List<Alumno> alumnos = alumnoService.alumnosPorCurso(idCurso);
		
		request.setAttribute("alumnos", alumnos);
		return "forward:/alumnos"; 
	}

}
