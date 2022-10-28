package main.webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.acao.Acao;
import main.acao.AlteraEmpresas;
import main.acao.ListaEmpresas;
import main.acao.MostraEmpresas;
import main.acao.NovaEmpresas;
import main.acao.NovaEmpresasForm;
import main.acao.RemoveEmpresas;

import main.modelo.Banco;
import main.modelo.Empresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "main.acao." + paramAcao;
		
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome do parâmetro passado
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("foward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		
		/*String nome = null;
		
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresas")) {
			RemoveEmpresas acao = new RemoveEmpresas();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("MostraEmpresas")) {
			MostraEmpresas acao = new MostraEmpresas();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresas")) {
			AlteraEmpresas acao = new AlteraEmpresas();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresas")) {
			NovaEmpresas acao = new NovaEmpresas();
			nome = acao.executa(request, response);
		}  else if (paramAcao.equals("NovaEmpresasForm")) {
			NovaEmpresasForm acao = new NovaEmpresasForm();
			nome = acao.executa(request, response);
		}*/
		
		
	}

}
