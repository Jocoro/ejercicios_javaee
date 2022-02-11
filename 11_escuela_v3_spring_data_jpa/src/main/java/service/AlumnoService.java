package service;

import java.util.Date;
import java.util.List;

import model.Alumno;

public interface AlumnoService {
	public boolean addAlumno(Alumno alumno, int idCurso);
	public Alumno findAlumno(String idAlumno);
	public List<Alumno> alumnosPorCurso(int idCurso);
	
	public List<Alumno> alumnosPorFecha(Date fechaMin);

}
