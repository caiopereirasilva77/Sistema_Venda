package com.atividade.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;


import com.atividade.dao.EquipeDAO;
import com.atividade.dao.Equipe_VendedorDAO;
import com.atividade.dao.VendedorDAO;

import com.atividade.entidades.Equipe;
import com.atividade.entidades.Equipe_Vendedor;
import com.atividade.entidades.Vendedor;
import com.atividade.util.JpaUtil;


@ManagedBean
@ViewScoped

public class Equipe_VendedorMB {
	
	EntityManager em = JpaUtil.getEntityManager();

	private Equipe_Vendedor equipe_vendedor;
	private List<Equipe_Vendedor> Equipes_Vendedores;
	private Equipe_VendedorDAO eqdao = new Equipe_VendedorDAO();
	


	@PostConstruct
	private void init(){

		Equipes_Vendedores = new ArrayList<Equipe_Vendedor>();
		limpaTela();
	

	}
	
	public List<Vendedor> getListVend(){
		VendedorDAO vdao = new VendedorDAO();
		return vdao.buscarTodos();
	}
	
	
	public List<Equipe> getListEqu(){
		EquipeDAO edao = new EquipeDAO();
		return edao.buscarTodos();
	}


	private void limpaTela(){

		equipe_vendedor = new Equipe_Vendedor();
		Equipes_Vendedores = eqdao.buscarTodos();
	}

	public String salvar(){



		if (equipe_vendedor.getId()==null){

			eqdao.insere(equipe_vendedor);
			limpaTela();
			
			

		}else{

			eqdao.atualizar(equipe_vendedor);
			limpaTela();

		}


		return"";
	}



	public String excluir(){
		
		
		eqdao.delete(equipe_vendedor);
		limpaTela();
	
		
		
		return"";

		
	}

	public Equipe_Vendedor getEquipe_vendedor() {
		return equipe_vendedor;
	}

	public void setEquipe_vendedor(Equipe_Vendedor equipe_vendedor) {
		this.equipe_vendedor = equipe_vendedor;
	}

	public List<Equipe_Vendedor> getEquipes_Vendedores() {
		return Equipes_Vendedores;
	}

	public void setEquipes_Vendedores(List<Equipe_Vendedor> equipes_Vendedores) {
		Equipes_Vendedores = equipes_Vendedores;
	}

	public Equipe_VendedorDAO getEdao() {
		return eqdao;
	}

	public void setEdao(Equipe_VendedorDAO edao) {
		this.eqdao = edao;
	}
	
	



	
	

}
