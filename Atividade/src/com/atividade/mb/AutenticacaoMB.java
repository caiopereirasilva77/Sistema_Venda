package com.atividade.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atividade.dao.UsuarioDAO;
import com.atividade.entidades.Usuario;

@ManagedBean
@RequestScoped
public class AutenticacaoMB {

	public String login;
	public String senha;
	
	public String logar(){
		FacesContext context = FacesContext.getCurrentInstance();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = new Usuario();
		u = dao.buscarPorLogin(login);
		if (u.getLogin().equals(login) && u.getSenha().equals(senha)){
			
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("idUser", u.getId());
		session.setAttribute("nome", u.getNome());
		session.setAttribute("usuario", u);
		
		HttpServletResponse response = (HttpServletResponse) context.getExternalContext();
		
		Cookie c = new Cookie ("001.rodirog", "Cookie de Teste");
		response.addCookie(c);
		
			return "principal.jsf";
		}else{
			context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha incorretos!", ""));
			return "";
		}
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
