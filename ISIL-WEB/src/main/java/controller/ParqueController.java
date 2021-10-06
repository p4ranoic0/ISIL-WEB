package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParqueDao;
import model.Parque;


@WebServlet("/parque")
public class ParqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ParqueDao objParqueDAO = new ParqueDao();       
   
    public ParqueController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupero la variable opci�n para saber que voy a hacer en el GET.
				String opcion = request.getParameter("opcion");
				switch (opcion) {
					/*Esto es lo que voy a hacer si me piden buscarPorNombre*/
					case "buscarPorNombre" :
					{
						buscarporNombre(request,response);
						break;
					}
					case "nuevo" : {
						nuevoParque(request,response);
						break;
					}
					case "editar" : {
						editarParque(request,response);
						break;
					}
				}
	}

	private void editarParque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idParque = Integer.parseInt(request.getParameter("idParque"));
		Parque objParqueEditar = null;
		//objParqueEditar = objParqueDAO.buscarParquexId(idParque);
		objParqueEditar = objParqueDAO.buscarParquexId_SP(idParque);	
		request.setAttribute("parque",objParqueEditar);
		String paginaJSP = "/editarParque.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		
	}
	
	
	
	private void nuevoParque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paginaJSP = "/nuevoParque.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
	}

	private void buscarporNombre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*He obtenido el nombre del parque que puse en la p�gina GestionParque.jsp*/
		List<Parque> listaParques;
		String nombreParque = request.getParameter("nombreParque");
		if (nombreParque==null) {
			/*Si esta vacio, debo traerme todos los parques*/
			//listaParques = objParqueDAO.buscarParqueAll();
			listaParques = objParqueDAO.buscarParqueAll_SP();
		}
		else {
			/*Debo traerme solo los parques que concuerden con el dato ingresado*/
			//listaParques = objParqueDAO.buscarParquexNombre(nombreParque);
			listaParques = objParqueDAO.buscarParquexNombre_SP(nombreParque);
		}		
		/*Deja informaci�n en memoria para que la p�gina lo pueda obtener*/
		request.setAttribute("listaParques", listaParques); /*Esto lo hago para dejarle a la p�gina un atributo que la p�gina pueda recuperar*/
		String paginaJSP = "/GestionParque.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String action = request.getParameter("action");
				switch (action){
					case "guardar" :{
						try {
							guardarParque(request,response);
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}
					case "eliminar" :{						
						//System.out.println("al cargar nuevamente se genera una excepcion");
						try {
							eliminarParque(request,response);
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (ServletException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					case "actualizar" :{						
							try {
								actualizarParque(request,response);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ServletException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					
				}
	}

	private void actualizarParque(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

		int idParque = Integer.parseInt(request.getParameter("idParque"));
		String nombre = request.getParameter("nombre");
		Integer aforo = Integer.parseInt(request.getParameter("aforo"));
		String direccion = request.getParameter("direccion");
		String distrito = request.getParameter("distrito");
		
		Parque objParque = new Parque(idParque,nombre,aforo,direccion,distrito);
		/*Utilizo el objeto DAO para agregarlo en la base de datos*/
		//objParqueDAO.editarParque(objParque);		
		objParqueDAO.editarParque_SP(objParque);
		String paginaJSP = "/GestionParque.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
		System.out.println("Registro actualizado");
		
	}


	private void eliminarParque(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{		
		int idParque = Integer.parseInt(request.getParameter("idParque"));
		//objParqueDAO.eliminarParque(idParque);
		objParqueDAO.eliminarParque_SP(idParque);
		String paginaJSP = "/GestionParque.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);	
		System.out.println("registro eliminado");
		
	}

	private void guardarParque(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		Integer aforo = Integer.parseInt(request.getParameter("aforo"));
		String direccion = request.getParameter("direccion");
		String distrito = request.getParameter("distrito");
		
		Parque objParque = new Parque(nombre,aforo,direccion,distrito,1);
		/*Utilizo el objeto DAO para agregarlo en la base de datos*/
		//objParqueDAO.agregarParque(objParque);
		objParqueDAO.agregarParque_SP(objParque);
		String paginaJSP = "/GestionParque.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaJSP);
		dispatcher.forward(request, response);
	}

}
