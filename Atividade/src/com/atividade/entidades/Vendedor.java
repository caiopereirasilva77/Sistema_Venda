package com.atividade.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean(name = "Vendedor", eager = true)
@SessionScoped

public class Vendedor {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idvendedor;
	private String nome;
	private float comissao;
	
	
	public Integer getId() {
		return idvendedor;
	}
	public void setId(Integer id) {
		this.idvendedor = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	
	

}
