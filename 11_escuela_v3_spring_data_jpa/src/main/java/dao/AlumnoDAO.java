package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;


public interface AlumnoDAO extends JpaRepository<Alumno,String>{
	@Query("Select a from Alumno a where a.curso.idCurso=?1")
	public List<Alumno> alumnosPorCurso(int idCurso);
	
	@Query("Select a from Alumno a where a.curso.fechaInicio>=?1")
	public List<Alumno> alumnosPorFecha(Date fechaMin);
	/*
	
	
	*/

}
