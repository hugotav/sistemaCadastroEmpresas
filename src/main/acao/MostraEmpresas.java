package main.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.modelo.Banco;
import main.modelo.Empresa;

public class MostraEmpresas implements Acao {
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	System.out.print("mostrando empresas");
	
	String paramId = request.getParameter("id");
	Integer id = Integer.valueOf(paramId);
	
	Banco banco = new Banco();
	
	Empresa empresa = banco.buscaEmpresaPelaId(id);
	
	System.out.println(empresa.getNome());
	
	request.setAttribute("empresa", empresa);
	
	return "foward:formAlteraEmpresa.jsp";
		
	}

}
