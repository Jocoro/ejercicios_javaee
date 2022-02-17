package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CursoDAO;
import model.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	
	private CursoDAO cursoDAO;
	
	public CursoServiceImpl(@Autowired CursoDAO cursoDAO) {
		this.cursoDAO=cursoDAO;
	}
	//-Añadir nuevos cursos, no puede haber dos cursos con el mismo nombre
	@Override
	public boolean addCurso(Curso curso) {
		if(cursoDAO.findCursoByNombre(curso.getDenominacion())==null) {
			cursoDAO.addCurso(curso);
			return true;
		}
		return false;
	}
	//-Busqueda de curso por id
	@Override
	public Curso findCurso(int idCurso) {
		return cursoDAO.findCurso(idCurso);
	}
	//-Consultar cursos por fecha de inicio (que comiencen entre dos fechas dadas)
	@Override
	public List<Curso> cursosEntreFechas(Date fechaInicial, Date fechaFinal) {
		return cursoDAO.cursosEntreFechas(fechaInicial, fechaFinal);
	}
	//-Modificar precios de cursos segun criterio: Reducción de un porcentaje determinado a los cursos
	//cuya duración sea superior a valor determinado
	@Override
	public void reducirPrecio(int porcentaje, int duracionMin) {
		cursoDAO.reducirPrecio(porcentaje, duracionMin);

	}
	//-Recupera cursos cuya duración sea inferior a una determinada cantidad
	@Override
	public List<Curso> cursosPorDuracionMax(int duracion) {
		return cursoDAO.cursosPorDuracionMax(duracion);
	}
	//-Dado un alumno, que nos devuelva los datos de su curso
	@Override
	public Curso findCursoByAlumno(String idAlumno) {
		return cursoDAO.findCursoByAlumno(idAlumno);
	}
	@Override
	public List<Curso> getAll() {
		// TODO Auto-generated method stub
		return cursoDAO.findAll();
	}

}
