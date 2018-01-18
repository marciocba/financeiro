package com.livro.capitulo4.model.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.livro.capitulo4.web.controller.ContextoController;

public class ContextoUtil {
public static ContextoController getContextoController() {
	FacesContext context=FacesContext.getCurrentInstance();
	ExternalContext external = context.getExternalContext();
	HttpSession session = (HttpSession)external.getSession(true);
	
	ContextoController 
		contextoController = (ContextoController)session.getAttribute("contextoController");
	
	return contextoController;
}
}
