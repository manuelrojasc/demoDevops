package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PersonaDao;
import Modelo.Persona;

/**
 * Servlet implementation class PersonaController
 */
public class PersonaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		// TODO Auto-generated method stub

 		String opcion = request.getParameter("opcion");
  
 		if (opcion.equals("crear")) {
 			System.out.println("Usted a presionado la opcion crear");
 			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/views/crear.jsp");
 			requestDispatcher.forward(request, response);
 		} else if (opcion.equals("listar")) {

 			PersonaDao personaDAO = new PersonaDao();
 			List<Persona> lista = new ArrayList<>();
 			try {
 				lista = personaDAO.obtenerPersona();
 				for (Persona persona : lista) {
 					System.out.println(persona);
 				}

 				request.setAttribute("lista", lista);
 				//cambiar ruta ojjo
 				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/views/listar.jsp");
 				requestDispatcher.forward(request, response);

 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

 			System.out.println("Usted a presionado la opcion listar");
 		} else if (opcion.equals("editar")) {
 			int id = Integer.parseInt(request.getParameter("id"));
 			System.out.println("Editar id: " + id);
 			PersonaDao personaDAO = new PersonaDao();
 			Persona p = new Persona();
 			try {
 				p = personaDAO.obtenerPersona(id);
 				System.out.println(p);
 				request.setAttribute("persona", p);
 				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/views/editar.jsp");
 				requestDispatcher.forward(request, response);

 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

 		}else if (opcion.equals("eliminar")) {
 			PersonaDao personaDAO = new PersonaDao();
 			int id=Integer.parseInt(request.getParameter("id"));
 			try {
 				personaDAO.eliminar(id);
 				System.out.println("Registro eliminado satisfactoriamente...");
 				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/index.jsp");
 				requestDispatcher.forward(request, response);
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 			
 		}
 		// response.getWriter().append("Served at: ").append(request.getContextPath());
 	}

 	/**
 	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
 	 *      response)
 	 */
 	protected void doPost(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		// TODO Auto-generated method stub
 		String opcion = request.getParameter("opcion");
 	

 		if (opcion.equals("guardar")) {
 			PersonaDao personaDAO = new PersonaDao();
 			Persona persona = new Persona();
 			persona.setNombre(request.getParameter("nombre"));
 			persona.setApellidos(request.getParameter("apellidos"));
 			try {
 				personaDAO.guardar(persona);
 				System.out.println("Registro guardado satisfactoriamente...");
 				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/index.jsp");
 				requestDispatcher.forward(request, response);

 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		} else if (opcion.equals("editar")) {
 			Persona persona = new Persona();
 			PersonaDao personaDAO = new PersonaDao();

 			persona.setDni(Integer.parseInt(request.getParameter("id")));
 			persona.setNombre(request.getParameter("nombre"));
 			persona.setApellidos(request.getParameter("apellidos"));
 			
 			try {
 				personaDAO.editar(persona);
 				System.out.println("Registro editado satisfactoriamente...");
 				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/webapp/index.jsp");
 				requestDispatcher.forward(request, response);
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		} 

 		// doGet(request, response);
 	}

}
