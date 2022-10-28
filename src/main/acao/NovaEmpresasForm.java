package main.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.modelo.Banco;
import main.modelo.Empresa;

public class NovaEmpresasForm implements Acao{
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	return "foward:formNovaEmpresa.jsp";
		
		
		
	}

}
