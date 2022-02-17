package dao;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface AlumnoDAO {
	
	public void addAlumno(Alumno alumno);
	public Alumno findAlumno(String dni);
	public List<Alumno> alumnosPorCurso(int idCurso);
	
	public List<Alumno> alumnosPorFecha(Date fechaMin);
	/*
	
	
	*/

}
