package com.livro.capitulo4.model.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.livro.capitulo4.model.Usuario;
import com.livro.capitulo4.model.DAO.UsuarioDAO;

public class UsuarioImpl implements UsuarioDAO {
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		session.save(usuario);

	}

	@Override
	public void atualizar(Usuario usuario) {
		session.update(usuario);

	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);

	}

	@Override
	public Usuario carregar(Integer codigo) {		
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql="";
		Query query=this.session.createQuery(hql);
		query.setString("login", login);
		return (Usuario) query.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

}
