package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UsuarioDao objUsuarioDAO = new UsuarioDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch (opcion) {
			case "validarUsuario" : {
				/*Aquí implemento toda la lógica a utilizar para validar usuario en login*/
				validarUsuario(request,response);
			}
		}
		doGet(request, response);
	}

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pagina;
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		int existe = objUsuarioDAO.validarUsuario(nickname, password);
		if (existe==1) {
			/*Aqui significa que el usuario si existe en la BD*/
			pagina = "/GestionParque.jsp";
		}
		else {
			pagina = "/login.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	public void validarUsuarioSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String pagina;
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		int existe = objUsuarioDAO.validarUsuarioSP(nickname, password);
		if (existe==1) {
			/*Aqui significa que el usuario si existe en la BD*/
			pagina = "/GestionParque.jsp";
		}
		else {
			pagina = "/login.jsp";
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
}


