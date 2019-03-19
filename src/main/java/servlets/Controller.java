package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.CommandFactory;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		proccessRequest( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		doGet(request, response);
	}

	private void proccessRequest( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.commandFactory();
        Command command = commandFactory.getCommand(req);
        String page = command.execute(req);
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }
}
