package com.livro.capitulo4.web.springsecurity.service;

import com.livro.capitulo4.model.Usuario;

public interface UserService {
	public Usuario findById(int id);
	//login 
	public Usuario findBySso(String sso);
}
