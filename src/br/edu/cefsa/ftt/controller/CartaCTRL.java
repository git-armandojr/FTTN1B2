package br.edu.cefsa.ftt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import br.edu.cefsa.ftt.bean.CartaBEAN;
import br.edu.cefsa.ftt.dao.CartaDAO;

/**
 * Servlet implementation class CartaCTRL
 */
@WebServlet("/carta")
public class CartaCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartaCTRL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    
	    String json = null;
		String codigo = request.getParameter("codigo");		
		
		try {
			if (codigo != null) {
				CartaBEAN cartaBean = new CartaBEAN();
				
				cartaBean.setCodigo(codigo);
				
				CartaDAO cartaDao = new CartaDAO();
				
				cartaBean = cartaDao.getCartaById(Integer.valueOf(codigo));
				
				json = gson.toJson(cartaBean);
			}
			else {
				List<CartaBEAN> cartas = new ArrayList<CartaBEAN>();
				
				CartaDAO cartaDao = new CartaDAO();
				
				cartas = cartaDao.getAllCartas();
				
				json = gson.toJson(cartas);
			}			
		} catch (Exception e) {
			String status = null;
			String message = null;
			String now = null;
			
			status = "Error";
			message = e.getMessage();
			System.err.println(status + ": " + now +  " - Ops!! - " + message);
			e.printStackTrace();
			
			JsonObject jsonObject = new JsonObject();
			
			jsonObject.addProperty("Status", status);
			jsonObject.addProperty("Message", message);
			jsonObject.addProperty("Time", now);
			
			json = gson.toJson(jsonObject);
		}
		
		response.setContentType("application/json"); //MIME Type
		response.setCharacterEncoding("utf-8");

		response.getWriter().print(json);
        response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
