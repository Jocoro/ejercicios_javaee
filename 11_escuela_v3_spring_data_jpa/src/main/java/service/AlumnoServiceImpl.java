package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnoDAO;
import dao.CursoDAO;
import model.Alumno;
import model.Curso;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	private AlumnoDAO alumnoDAO;
	private CursoDAO cursoDAO;
	public AlumnoServiceImpl(@Autowired AlumnoDAO alumnoDAO,
			@Autowired CursoDAO cursoDAO) {
		this.alumnoDAO=alumnoDAO;
		this.cursoDAO=cursoDAO;
	}
	//-Posibilidad de dar de alta nuevos alumnos, teniendo en cuenta que no puede haber dos alumnos con el mismo dni
	//y el curso debe existir
	@Override
	public boolean addAlumno(Alumno alumno, int idCurso) {
		Curso curso =cursoDAO.findById(idCurso).orElse(null);
		if(alumnoDAO.findById(alumno.getDni()).orElse(null)==null
				&&curso!=null) {
			alumno.setCurso(curso);
			alumnoDAO.save(alumno);
			return true;
			}
		return false;
	}

	@Override
	public Alumno findAlumno(String dni) {
		// TODO Auto-generated method stub
		return alumnoDAO.findById(dni).orElse(null);
	}
	//-Recuperar lista de alumnos de un determinado curso
	@Override
	public List<Alumno> alumnosPorCurso(int idCurso) {
		return alumnoDAO.alumnosPorCurso(idCurso);
	}
	//-A partir de una fecha, lista de alumnos matriculados en cursos posteriores a dicha fecha
	@Override
	public List<Alumno> alumnosPorFecha(Date fechaMin) {
		return alumnoDAO.alumnosPorFecha(fechaMin);
	}

}
