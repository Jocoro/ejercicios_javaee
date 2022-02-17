package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.AgendaService;


@WebServlet("/AltaController")
public class AltaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar los datos del contacto y a traves de la capa de servicio damos de alta
		AgendaService service = new AgendaService();
		Contacto contacto = new Contacto(request.getParameter("nombre"),request.getParameter("email"),
				Integer.parseInt(request.getParameter("edad")));
		service.agregarContacto(contacto);
		//transferimos el control a una pagina de información
		request.getRequestDispatcher("info.html").forward(request, response);
	}

}
