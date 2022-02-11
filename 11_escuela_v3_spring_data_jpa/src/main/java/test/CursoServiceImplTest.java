package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import configuration.ModeloConfig;
import dao.CursoDAO;
import model.Curso;
import service.CursoServiceImpl;

@ExtendWith(MockitoExtension.class) 
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ModeloConfig.class }) 
class CursoServiceImplTest {
	
	@Mock
	CursoDAO dao;
	CursoServiceImpl service;
	@BeforeEach
	/*void setUp() throws Exception {
		service = new CursoServiceImpl(dao);
		when(dao.findCursoByNombre("java")).thenReturn(new Curso(2,"java",120,200,new Date()));
		when(dao.findCursoByNombre("no existe")).thenReturn(null);
	}*/

	

	@Test
	void testAddCurso() {
		assertTrue(service.addCurso(new Curso(2,"no existe",120,200,new Date())));
		assertFalse(service.addCurso(new Curso(2,"java",120,200,new Date())));
	}

	@Test
	void testFindCurso() {
		fail("Not yet implemented");
	}

	@Test
	void testCursosEntreFechas() {
		fail("Not yet implemented");
	}

	@Test
	void testReducirPrecio() {
		fail("Not yet implemented");
	}

	@Test
	void testCursosPorDuracionMax() {
		fail("Not yet implemented");
	}

	@Test
	void testFindCursoByAlumno() {
		fail("Not yet implemented");
	}

}
