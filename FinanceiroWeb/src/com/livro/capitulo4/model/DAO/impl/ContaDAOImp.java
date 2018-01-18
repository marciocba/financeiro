package com.livro.capitulo4.model.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.livro.capitulo4.model.Conta;
import com.livro.capitulo4.model.Usuario;
import com.livro.capitulo4.model.DAO.ContaDAO;

public class ContaDAOImp implements ContaDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void excluir(Conta conta) {
		this.session.delete(conta);
	}

	public void salvar(Conta conta) {
		this.session.saveOrUpdate(conta);
	}

	public Conta carregar(Integer conta) {
		return (Conta) this.session.get(Conta.class, conta);
	}

	public List<Conta> listar(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		return criteria.list();
	}

	public Conta buscarFavorita(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Conta.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("favorita", true));
		return (Conta) criteria.uniqueResult();
	}

}
