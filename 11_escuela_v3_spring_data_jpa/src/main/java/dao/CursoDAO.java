package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;

public interface CursoDAO extends JpaRepository<Curso,Integer>{
	public Curso findByDenominacion(String nombre);
	
	@Query("Select c from Curso c where c.fechaInicio>?1 AND c.fechaInicio<?2")
	public List<Curso> cursosEntreFechas(Date fechaInicial, Date fechaFinal);
	@Transactional
	@Modifying
	@Query("update Curso c set c.precio=c.precio*?1 where c.duracion>?2")
	public void reducirPrecio(int porcentaje,int duracionMin);
	@Query("Select c from Curso c where c.duracion<?1")
	public List<Curso> cursosPorDuracionMax(int duracion);
	@Query("Select distinct(c) from Curso c join c.alumnos a where a.dni=?1")
	public Curso findCursoByAlumno(String dni);
	
	
}
