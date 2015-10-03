package com.atividade.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean(name = "Equipe", eager = true)
@SessionScoped


public class Equipe  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idequipe;
	private String descricao;
	
	
	

	public Integer getId() {
		return idequipe;
	}
	public void setId(Integer idequipe) {
		this.idequipe = idequipe;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
