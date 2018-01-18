package com.livro.capitulo4.web.springsecurity.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.livro.capitulo4.model.Usuario;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAO<Integer, Usuario> implements UserDAO {

	@Override
	public Usuario findById(int id) {
		return this.getByKey(id);
	}

	@Override
	public Usuario findBySSO(String sso) {
		 Criteria crit = createEntityCriteria();
	        crit.add(Restrictions.eq("ssoId", sso));
	        return (Usuario) crit.uniqueResult();
	}

}
