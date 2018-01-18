package com.livro.capitulo4.web.springsecurity.dao;

import com.livro.capitulo4.model.Usuario;

public interface UserDAO {
	Usuario findById(int id);
    
	Usuario findBySSO(String sso);
}
