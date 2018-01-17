package com.livro.capitulo4.model.util;

import com.livro.capitulo4.model.DAO.UsuarioDAO;
import com.livro.capitulo4.model.DAO.impl.UsuarioDAOImpl;

public class DAOFactory {
	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOImpl usuarioDAO=new UsuarioDAOImpl();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}
}
