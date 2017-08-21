package br.com.alura.gerenciador;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter{

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			String uri = req.getRequestURI();
			String usuario = getUsuario(req);			
			System.out.println("usuario "+ usuario + "acessando URI: " + uri);
			chain.doFilter(request, response);
			
		}

		private String getUsuario(HttpServletRequest req) {
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

			if(usuario == null) return "deslogado";
			return usuario.getEmail();
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub
			
		}
}
