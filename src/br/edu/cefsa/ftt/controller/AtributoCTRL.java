package br.edu.cefsa.ftt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.edu.cefsa.ftt.types.AtributoENUM;

/**
 * Servlet implementation class AtributoCTRL
 */
@WebServlet("/AtributoCTRL")
public class AtributoCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtributoCTRL() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		Gson g = new Gson();
		
		ArrayList<String> tipos = new ArrayList<String>();
		for (AtributoENUM tipo : AtributoENUM.values()) {
			if (tipo.name() != null) {
				tipos.add(tipo.name());
			}
		};
		response.getWriter().write(g.toJson(tipos));
		
	}

}
