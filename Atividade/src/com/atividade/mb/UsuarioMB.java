package com.atividade.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.atividade.dao.UsuarioDAO;
import com.atividade.entidades.Usuario;


@ManagedBean
@ViewScoped
public class UsuarioMB {

	private Usuario usuario;


	private List<Usuario> usuarios;

	private UsuarioDAO usuarioDAO = new UsuarioDAO();


	@PostConstruct
	private void init(){
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();

		usuarios = usuarioDAO.buscarTodos();

	}

	public String salvar(){

		FacesContext context = FacesContext.getCurrentInstance();

		if (usuario.getSenha().equals(usuario.getConfSenha())&& usuario.getSenha()!=null
				&& usuario.getConfSenha()!=null && usuario.getId() == null && usuario.getNome()!=null 
				&& usuario.getLogin()!=null){

			usuarioDAO.insere(usuario);
			usuarios = usuarioDAO.buscarTodos();
			usuario = new Usuario();

			context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com sucesso!", ""));
		}else{
			System.out.println("Id:" + usuario.getId());
			System.out.println("Nome:" + usuario.getNome());
			System.out.println("Login:" + usuario.getLogin());
			System.out.println("Senha:" + usuario.getSenha());
			System.out.println("ConfSenha:" + usuario.getConfSenha());

			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem", ""));

		}
		if (usuario.getId() !=null) {

			usuarioDAO.atualizar(usuario);
			usuarios = usuarioDAO.buscarTodos();
			usuario = new Usuario(); 



		}else{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem", ""));
		}
		return "";
	}


	public String excluir(){
		UsuarioDAO dao = new UsuarioDAO();
		dao.delete(usuario);
		usuarios = dao.buscarTodos();
		usuario = new Usuario();
		return"";


	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	
}
