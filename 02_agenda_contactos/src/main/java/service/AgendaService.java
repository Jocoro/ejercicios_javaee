package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import locator.ConexionLocator;
import model.Contacto;

public class AgendaService {

	public boolean agregarContacto(Contacto contacto) {
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			try(Connection con=ConexionLocator.getConnection();
			PreparedStatement st=con.prepareStatement(sql)){
			//sutituimos parametros por valores
			st.setString(1, contacto.getNombre());
			st.setString(2, contacto.getEmail());
			st.setInt(3, contacto.getEdad());
			st.execute();
			return true;
			}
			catch(SQLException ex) {
			ex.printStackTrace();
			return false;
			}
		
		

	}

	public Contacto buscarContacto(String email) {
		String sql="select * from contactos where email=?";
		try(Connection con=ConexionLocator.getConnection();
		PreparedStatement st=con.prepareStatement(sql)){
		st.setString(1, email);
		ResultSet rs=st.executeQuery();
		if(rs.next()) {
		return new Contacto(rs.getString("nombre"),rs.getString("email"),rs.getInt("edad"));
		}
		return null;
		}
		catch(SQLException ex) {
		ex.printStackTrace();
		return null;
		}
	}

	public boolean eliminarContacto(String email) {
		String sql="delete from contactos where email=?";
		try (Connection con=ConexionLocator.getConnection();
		PreparedStatement st=con.prepareStatement(sql);){
		st.setString(1, email);
		if(st.executeUpdate()>0) {
		return true;
		}
		return false;
		}
		catch(SQLException ex) {
		ex.printStackTrace();
		return false;
		}
	}

	public Collection<Contacto> getContactos() {
		ArrayList<Contacto> contactos=new ArrayList<>();
		try(Connection con=ConexionLocator.getConnection();
		Statement st=con.createStatement()){
		String sql="select * from contactos";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
		contactos.add( new Contacto(rs.getInt("idContacto"),rs.getString("nombre"),rs.getString("email"),rs.getInt("edad")));
		}
		}
		catch(SQLException ex) {
		ex.printStackTrace();
		}
		return contactos;
		}
		

}
