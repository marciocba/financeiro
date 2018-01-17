package com.livro.capitulo4.model.util;

import com.livro.capitulo4.model.DAO.UsuarioDAO;
import com.livro.capitulo4.model.DAO.impl.UsuarioImpl;

public class DAOFactory {
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioImpl usuarioDAO=new UsuarioImpl();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}
