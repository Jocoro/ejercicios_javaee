package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AgendaService;

/**
 * Servlet implementation class EliminarController
 */
@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgendaService service =new AgendaService();
		//recogemos el parametro email
		String email=request.getParameter("email");
		service.eliminarContacto(email);
		//despues de eliminar transferimos el control a la lista controller para que vuelva a cargarlo
		request.getRequestDispatcher("ListadoController").forward(request, response);
	}

}
