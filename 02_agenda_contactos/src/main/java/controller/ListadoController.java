package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.AgendaService;


@WebServlet("/ListadoController")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperamos los contactos y se los enviamos a una pagina para que los pinte
		AgendaService service = new AgendaService();
		List<Contacto> contactos = List.copyOf(service.getContactos());
		request.setAttribute("contactos", contactos);
		request.getRequestDispatcher("listado.jsp").forward(request, response);
	}

}
