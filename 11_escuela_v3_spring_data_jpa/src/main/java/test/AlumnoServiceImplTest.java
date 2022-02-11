package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import configuration.ModeloConfig;
import service.AlumnoService;

@ExtendWith(MockitoExtension.class) 
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ModeloConfig.class }) 
class AlumnoServiceImplTest {
	
	@Autowired
	AlumnoService service;
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAlumnosCurso() {
		fail("Not yet implemented");
	}
	

}
