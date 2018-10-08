package br.edu.cefsa.ftt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import br.edu.cefsa.ftt.bean.TipoBEAN;
import br.edu.cefsa.ftt.dao.TipoDAO;

/**
 * Servlet implementation class TipoCTRL
 */
@WebServlet("/tipo")
public class TipoCTRL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoCTRL() {
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
				TipoBEAN tipoBean = new TipoBEAN();
				
				tipoBean.setCodigo(codigo);
				
				TipoDAO tipoDao = new TipoDAO();
				
				tipoBean = tipoDao.getTipoById(Integer.valueOf(codigo));
				
				json = gson.toJson(tipoBean);
			}
			else {
				List<TipoBEAN> tipos = new ArrayList<TipoBEAN>();
				
				TipoDAO tipoDao = new TipoDAO();
				
				tipos = tipoDao.getAllTipos();
				
				json = gson.toJson(tipos);
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
		TipoBEAN tipoBean = new TipoBEAN(
				request.getParameter("codigo"),
				request.getParameter("descricao"));
		
		//System.out.print(cartaBean);
		
		TipoDAO tipoDao = new TipoDAO();
		
		String status = null;
		String message = null;
		String now = String.valueOf(new Date());
		
		try {
			tipoDao.addTipo(tipoBean);
		   
			status = "OK";
			message = "Tipo cadastrado com sucesso!";
		   
		} catch (Exception e) {
			status = "Error";
			message = e.getMessage();
			System.err.println(now +  " - Ops!! - " + message);
			System.err.println(now +  " - Ops!! - " + tipoBean);
			e.printStackTrace();
		}
		
		response.setContentType("application/json"); //MIME Type
		response.setCharacterEncoding("utf-8");
		
	    //create Json Object
		JsonObject json = new JsonObject();

		// put some value pairs into the JSON object .
		
		json.addProperty("Status", status);
		json.addProperty("Message", message);
		json.addProperty("Time", now);


		response.getWriter().print(json.toString());
        response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TipoBEAN tipoBean = new TipoBEAN(
				request.getParameter("codigo"),
				request.getParameter("descricao"));
		
		//System.out.print(cartaBean);
		
		TipoDAO tipoDao = new TipoDAO();
		
		String status = null;
		String message = null;
		String now = String.valueOf(new Date());
		
		try {
			tipoDao.updateTipo(tipoBean);
		   
			status = "OK";
			message = "Carta atualizada!";
		   
		} catch (Exception e) {
			status = "Error";
			message = e.getMessage();
			System.err.println(now +  " - Ops!! - " + message);
			System.err.println(now +  " - Ops!! - " + tipoBean);
			e.printStackTrace();
		}
		
		response.setContentType("application/json"); //MIME Type
		response.setCharacterEncoding("utf-8");
		
	    //create Json Object
		JsonObject json = new JsonObject();

		// put some value pairs into the JSON object .
		
		json.addProperty("Status", status);
		json.addProperty("Message", message);
		json.addProperty("Time", now);


		response.getWriter().print(json.toString());
        response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TipoBEAN tipoBean = new TipoBEAN();
		
		tipoBean.setCodigo(request.getParameter("codigo"));
		
		TipoDAO tipoDao = new TipoDAO();
		
		//System.out.print(cartaBean);
		
		String status = null;
		String message = null;
		String now = String.valueOf(new Date());
		
		try {
		   tipoDao.deleteTipo(tipoBean);
		   
		   status = "OK";
		   message = "Carta removida!";
		   now = String.valueOf(new Date());
		   
		} catch (Exception e) {
			status = "Error";
			message = e.getMessage();
			System.err.println(now +  " - Ops!! - " + message);
			System.err.println(now +  " - Ops!! - " + tipoBean);
			e.printStackTrace();
		}
		
		response.setContentType("application/json"); //MIME Type
		response.setCharacterEncoding("utf-8");
		
	    //create Json Object
		JsonObject json = new JsonObject();

		// put some value pairs into the JSON object .
		
		json.addProperty("Status", status);
		json.addProperty("Message", message);
		json.addProperty("Time", now);

		response.getWriter().print(json.toString());
        response.flushBuffer();
	}

}
