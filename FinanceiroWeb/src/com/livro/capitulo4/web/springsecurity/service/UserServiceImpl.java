package com.livro.capitulo4.web.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.livro.capitulo4.model.Usuario;
//import com.livro.capitulo4.web.springsecurity.dao.UserDao;
import com.livro.capitulo4.web.springsecurity.dao.UserDAO;
public class UserServiceImpl implements UserService {
	@Autowired
    private UserDAO dao;
	@Override
	public Usuario findById(int id) {
		return dao.findById(id);
	}

	@Override
	public Usuario findBySso(String sso) {
		return dao.findBySSO(sso);
	}

}
