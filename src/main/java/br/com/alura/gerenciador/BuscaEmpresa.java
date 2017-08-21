package br.com.alura.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.TransducedAccessor_field_Double;

import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns= "/busca")
public class BuscaEmpresa extends HttpServlet{
	
	
	public BuscaEmpresa(){
		System.out.println("COnstuindo uma servlet do tipo busca empresa");
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("inicializando a servlet" + this);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destruindo a servlet");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter writer =  resp.getWriter();
		writer.println("<html><body>");
		writer.println("Resultado da busca:");		
		String filtro = req.getParameter("filtro");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		writer.println("<ul>");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + " :" + empresa.getNome() +" </li>");
		}
		writer.println("</ul>");
		writer.println("</html></body>");
	}
}
