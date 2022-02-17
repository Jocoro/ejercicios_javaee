package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import model.Contacto;

@Service
public class ContactosServiceimpl implements ContactosService {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public boolean agregar(String nombre, String email, int edad) {
		String sql="insert into contactos(nombre, email, edad) values (?,?,?)";
		return template.update(sql,nombre,email,edad)>0;
	}

	@Override
	public boolean agregar(Contacto contacto) {
		 return agregar(contacto.getNombre(),contacto.getEmail(),contacto.getEdad());
	}

	@Override
	public Contacto buscar(String email) {
		String sql ="select * from contactos where email=?";
		List<Contacto> contactos= template.query(sql, (r,f)->new Contacto(r.getInt("idContacto"),
				r.getString("nombre"),
				r.getString("email"),
				r.getInt("edad")), email);
		return contactos.size()>0?contactos.get(0):null;
	}

	@Override
	public boolean eliminar(String email) {
		String sql = "delete from contactos where email=?";
		return template.update(sql,email)>0;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		String sql ="select * from contactos";
		return template.query(sql, (r,f)->new Contacto(r.getInt("idContacto"),
				r.getString("nombre"),
				r.getString("email"),
				r.getInt("edad")));
	}

}
