package com.livro.capitulo4.model.DAO;

import java.util.List;

import com.livro.capitulo4.model.Conta;
import com.livro.capitulo4.model.Usuario;

public interface ContaDAO {
	public void salvar(Conta conta);

	public void excluir(Conta conta);

	public Conta carregar(Integer conta);

	public List<Conta> listar(Usuario usuario);

	public Conta buscarFavorita(Usuario usuario);

}
