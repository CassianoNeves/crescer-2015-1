package filmator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import filmator.model.Usuario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	  public boolean preHandle(HttpServletRequest request,
			  HttpServletResponse response,
			  Object controller) throws Exception {
	    
			String uri = request.getRequestURI();
			
			if( uri.endsWith("login") || 
					uri.endsWith("naoLogado") ||
					uri.endsWith("/usuario/validar") ||
					uri.endsWith("scripts") ||
					uri.contains("resources") ){
				return true;
			}
	      
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		
			if(usuario != null) {
				
				if( uri.endsWith("/filme/listar") ||
						uri.endsWith("/usuario/listar") ){
					if( usuario.isAdmin() ){
						return true;
					}else{
						response.sendRedirect("/naoLogado");
						return false;
					}
				}
				
		        return true;
		    }
		
		
		
		    response.sendRedirect("/login");
		    return false;  
	  }
}
