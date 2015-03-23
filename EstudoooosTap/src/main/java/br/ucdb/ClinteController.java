package br.ucdb;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ClinteController")
public class ClinteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ClinteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pegar a lista e levar para o JSP
		GerenciadorCliente gc = new GerenciadorCliente();
		
		List<Cliente> clientes = gc.getClientes();
		
		request.setAttribute("cli", clientes);
		
		RequestDispatcher view = request.getRequestDispatcher("Clientes.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		
		Cliente cliente = new Cliente ();
		cliente.setnome(nome);
		
		GerenciadorCliente gc = new GerenciadorCliente();
		gc.salvar(cliente);
		
		response.getWriter().print("Salvo com Sucesso!!!");
		
		doGet(request, response);
		
	}

}
