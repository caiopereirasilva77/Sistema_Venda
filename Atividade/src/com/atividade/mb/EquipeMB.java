package com.atividade.mb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.atividade.dao.EquipeDAO;
import com.atividade.entidades.Equipe;


@ManagedBean
@ViewScoped
public class EquipeMB {
	
	
	private Equipe equipe;
	private List<Equipe> equipes;
	private EquipeDAO dao = new EquipeDAO();
	


	@PostConstruct
	private void init() {
		equipes = new ArrayList<Equipe>();
		limpaTela();
	}
	
	
	private void limpaTela() {
		equipe = new Equipe();
		System.out.println(" Primeiro- id:"+ equipe.getId() + "Descricao:"+ equipe.getDescricao());
		equipes = dao.buscarTodos();
		System.out.println(" Segundo - id:"+ equipe.getId() + "Descricao:"+ equipe.getDescricao());
		
	}

	public String salvar() throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		if (equipe.getId() == null) {
			dao.insere(equipe);
			limpaTela();
		} else {
			dao.atualizar(equipe);
			limpaTela();
			context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Salvo com sucesso!", ""));
		}
		return "";
	}

	public String excluir() {
		EquipeDAO dao = new EquipeDAO();
		dao.delete(equipe);
		limpaTela();
		return "";
	}


	public Equipe getEquipe() {
		return equipe;
	}


	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}


	public List<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}


	public EquipeDAO getDao() {
		return dao;
	}


	public void setDao(EquipeDAO dao) {
		this.dao = dao;
	}



	

}
