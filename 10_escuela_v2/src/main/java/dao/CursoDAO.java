package dao;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface CursoDAO {
	public void addCurso(Curso curso);
	public Curso findCurso(int idCurso);
	public Curso findCursoByNombre(String nombre);
	public List<Curso> cursosEntreFechas(Date fechaInicial, Date fechaFinal);
	public void reducirPrecio(int porcentaje,int duracionMin);
	public List<Curso> cursosPorDuracionMax(int duracion);
	public Curso findCursoByAlumno(String dni);
	public List<Curso> findAll();
	
}
