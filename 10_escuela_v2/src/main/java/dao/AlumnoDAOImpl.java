package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;

@Repository
public class AlumnoDAOImpl implements AlumnoDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	@Transactional
	@Override
	public void addAlumno(Alumno alumno) {
		manager.persist(alumno);

	}

	@Override
	public Alumno findAlumno(String dni) {
		return manager.find(Alumno.class, dni);
	}

	@Override
	public List<Alumno> alumnosPorCurso(int idCurso) {
		String jpql ="Select a from Alumno a where a.curso.idCurso=?1";
		var query=manager.createQuery(jpql,Alumno.class);
		query.setParameter(1, idCurso);
		return query.getResultList();
	}

	

	@Override
	public List<Alumno> alumnosPorFecha(Date fechaMin) {
		String jpql ="Select a from Alumno a where a.curso.fechaInicio>=?1";
		var query=manager.createQuery(jpql,Alumno.class);
		query.setParameter(1, fechaMin);
		return query.getResultList();
	}

}
