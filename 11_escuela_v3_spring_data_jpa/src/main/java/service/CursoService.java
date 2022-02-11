package service;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface CursoService {
	public boolean addCurso(Curso curso);
	public Curso findCurso(int idCurso);
	public List<Curso> cursosEntreFechas(Date fechaInicial, Date fechaFinal);
	public void reducirPrecio(int porcentaje,int duracionMin);
	public List<Curso> cursosPorDuracionMax(int duracion);
	public Curso findCursoByAlumno(String idAlumno);
	public List<Curso> getAll(); 

}
