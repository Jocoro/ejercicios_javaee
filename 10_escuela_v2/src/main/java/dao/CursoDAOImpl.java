package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;

@Repository
public class CursoDAOImpl implements CursoDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	@Transactional
	@Override
	public void addCurso(Curso curso) {
		manager.persist(curso);
	}

	@Override
	public Curso findCurso(int idCurso) {
		return manager.find(Curso.class, idCurso);
	}

	@Override
	public List<Curso> cursosEntreFechas(Date fechaInicial, Date fechaFinal) {
		String jpql ="Select c from Curso c where c.fechaInicio>?1 AND c.fechaInicio<?2";
		TypedQuery<Curso> query=manager.createQuery(jpql, Curso.class);
		query.setParameter(1, fechaInicial);
		query.setParameter(2, fechaFinal);
		return query.getResultList();
	}
	
	@Transactional
	@Override
	public void reducirPrecio(int porcentaje, int duracionMin) {
		String jpql ="update Curso c set c.precio=c.precio*?1 where c.duracion>?2";
		var query = manager.createQuery(jpql);
		double variable =(100.0-porcentaje)/100.0;
		query.setParameter(1, variable);
		query.setParameter(2, duracionMin);
		query.executeUpdate();

	}

	@Override
	public List<Curso> cursosPorDuracionMax(int duracion) {
		String jpql ="Select c from Curso c where c.duracion<?1";
		TypedQuery<Curso> query=manager.createQuery(jpql, Curso.class);
		query.setParameter(1, duracion);
		return query.getResultList();
	}

	@Override
	public Curso findCursoByAlumno(String dni) {
		String jpql ="Select distinct(c) from Curso c join c.alumnos a where a.dni=?1";
		var query = manager.createQuery(jpql, Curso.class);
		query.setParameter(1,dni);
		List<Curso> cursos=query.getResultList();
		return cursos.size()>0?cursos.get(0):null;
	}

	@Override
	public Curso findCursoByNombre(String nombre) {
		var query = manager.createNamedQuery("Curso.findByName",Curso.class);
		query.setParameter(1,nombre);
		List<Curso> cursos=query.getResultList();
		return cursos.size()>0?cursos.get(0):null;
	}

	@Override
	public List<Curso> findAll() {
		String jpql ="Select c from Curso c";
		TypedQuery<Curso> query=manager.createQuery(jpql, Curso.class);
		return query.getResultList();
	}

}
