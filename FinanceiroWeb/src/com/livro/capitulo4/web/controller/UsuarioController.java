package com.livro.capitulo4.web.controller;

import java.util.Date;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;

import com.livro.capitulo4.model.Conta;
import com.livro.capitulo4.model.Usuario;
import com.livro.capitulo4.model.rn.ContaRN;
import com.livro.capitulo4.model.rn.UsuarioRN;



@RequestScoped
@ManagedBean(name = "usuarioController")
public class UsuarioController {
	private Usuario usuario=new Usuario();
	private String confirmarSenha;
	private Date nascimento;
	private List<Usuario> lista;
	private String destinoSalvar;
	private Conta conta=new Conta();

	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public String novo() {
		System.out.println("novo()");
		setDestinoSalvar("usuarioSucesso");
		this.usuario=new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}
	
	public String editar() {		
		setConfirmarSenha(this.usuario.getSenha());
		java.sql.Date sqlDate = this.usuario.getNascimento();
		this.nascimento=(java.sql.Date)sqlDate;
		return "/publico/usuario";
	}
	public String salvar() {
		FacesContext context=FacesContext.getCurrentInstance();
		String senha=this.usuario.getSenha();
		
		if (!senha.equalsIgnoreCase(this.confirmarSenha)) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Senha confirmada incorretamente",""));
			return null;
		}

		java.util.Date utilDate = getNascimento();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//	    System.out.println("utilDate:"+utilDate);
//	    System.out.println("sqlDate:"+sqlDate);
	    usuario.setNascimento(sqlDate);
		
		UsuarioRN usuarioRN=new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		
		if (this.getConta().getDescricao()!=null) {
			this.getConta().setUsuario(this.usuario);
			this.getConta().setFavorita(true);
			
			ContaRN contaRN=new ContaRN();
			contaRN.salvar(this.getConta());
		}
		
		
		return getDestinoSalvar();
	}
	
	public String excluir() {
		UsuarioRN usuarioRN=new UsuarioRN();
		usuarioRN.excluir(usuario);
		this.lista=null;
		return null;
	}
	
	public String ativar() {
		UsuarioRN usuarioRN=new UsuarioRN();
		if (this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		}else {
			this.usuario.setAtivo(true);
		}
		
		usuarioRN.salvar(usuario);
		return null;
	}
	public Usuario getUsuario() {return usuario;}
	public void setUsuario(Usuario usuario) {this.usuario = usuario;}
	public String getConfirmarSenha() {return confirmarSenha;}
	public void setConfirmarSenha(String confirmarSenha) {this.confirmarSenha = confirmarSenha;}
	public Date getNascimento() {return nascimento;}
	public void setNascimento(Date nascimento) {this.nascimento = nascimento;}
	public List<Usuario> getLista() {
		if (this.lista==null) {
			UsuarioRN usuarioRN=new UsuarioRN();
			this.lista=usuarioRN.listar();
		}
		return this.lista;
	}
	public void setLista(List<Usuario> lista) {	this.lista = lista;}
	public String getDestinoSalvar() {return destinoSalvar;	}
	public void setDestinoSalvar(String destinoSalvar) {this.destinoSalvar = destinoSalvar;}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmarSenha == null) ? 0 : confirmarSenha.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((destinoSalvar == null) ? 0 : destinoSalvar.hashCode());
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UsuarioController)) {
			return false;
		}
		UsuarioController other = (UsuarioController) obj;
		if (confirmarSenha == null) {
			if (other.confirmarSenha != null) {
				return false;
			}
		} else if (!confirmarSenha.equals(other.confirmarSenha)) {
			return false;
		}
		if (conta == null) {
			if (other.conta != null) {
				return false;
			}
		} else if (!conta.equals(other.conta)) {
			return false;
		}
		if (destinoSalvar == null) {
			if (other.destinoSalvar != null) {
				return false;
			}
		} else if (!destinoSalvar.equals(other.destinoSalvar)) {
			return false;
		}
		if (lista == null) {
			if (other.lista != null) {
				return false;
			}
		} else if (!lista.equals(other.lista)) {
			return false;
		}
		if (nascimento == null) {
			if (other.nascimento != null) {
				return false;
			}
		} else if (!nascimento.equals(other.nascimento)) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}
	
		
}
