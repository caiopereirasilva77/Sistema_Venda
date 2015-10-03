package com.atividade.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Equipevendedor") 

public class Equipe_Vendedor {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer idequipevendedor;
	@Column(length=100)
	
	private Integer idvendedor;
	@Column(length=100)
	
	private Integer idequipe;
	
	@ManyToOne
	private Vendedor vendedor;
	
	@ManyToOne
	private Equipe equipe;
	
	
	
	
	public Integer getId() {
		return idequipevendedor;
	}
	public void setId(Integer idequipevendedor) {
		this.idequipevendedor = idequipevendedor;
	}
	public Integer getIdvendedor() {
		return idvendedor;
	}
	public void setIdvendedor(Integer idvendedor) {
		this.idvendedor = idvendedor;
	}
	public Integer getIdequipe() {
		return idequipe;
	}
	public void setIdequipe(Integer idequipe) {
		this.idequipe = idequipe;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Equipe getEquipe() {
		return equipe;
	}
	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	
	
	
	

}
