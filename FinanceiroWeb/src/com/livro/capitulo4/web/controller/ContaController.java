package com.livro.capitulo4.web.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.livro.capitulo4.model.Conta;
import com.livro.capitulo4.model.rn.ContaRN;
import com.livro.capitulo4.model.util.ContextoUtil;

@ManagedBean
@RequestScoped

public class ContaController {
	private Conta selecionada = new Conta();
	private List<Conta> lista = null;
	//@ManagedProperty(value = "#{contextoController}")
	//private ContextoController contextoController;

	public String salvar() {
		ContextoController contextoController=ContextoUtil.getContextoController();
		this.selecionada.setUsuario(contextoController.getUsuarioLogado());
		ContaRN contaRN = new ContaRN();
		contaRN.salvar(this.selecionada);
		this.selecionada = new Conta();
		this.lista = null;
		return null;
	}

	public String excluir() {
		ContaRN contaRN = new ContaRN();
		contaRN.excluir(this.selecionada);
		this.selecionada = new Conta();
		this.lista = null;
		return null;
	}

	public String tornarFavorita() {
		ContaRN contaRN = new ContaRN();
		contaRN.tornarFavorita(this.selecionada);
		this.selecionada = new Conta();
		return null;
	}

	public Conta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Conta selecionada) {
		this.selecionada = selecionada;
	}

	public List<Conta> getLista() {
		ContextoController contextoController=ContextoUtil.getContextoController();
		this.selecionada.setUsuario(contextoController.getUsuarioLogado());
		if (this.lista == null) {
			ContaRN contaRN = new ContaRN();
			this.lista = contaRN.listar(contextoController.getUsuarioLogado());
		}
		return this.lista;

	}

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}


}
