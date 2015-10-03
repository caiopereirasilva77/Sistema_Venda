package com.atividade.mb;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.atividade.dao.VendedorDAO;

import com.atividade.entidades.Vendedor;


@ManagedBean
@ViewScoped
public class VendedorMB {

	private Vendedor vendedor;
	private List<Vendedor> vendedores;
	private VendedorDAO dao = new VendedorDAO();
	


	@PostConstruct
	private void init() {
		vendedores = new ArrayList<Vendedor>();
		limpaTela();
	}
	
	
	private void limpaTela() {
		vendedor = new Vendedor();
		vendedores = dao.buscarTodos();
	}

	public String salvar() throws SQLException {
		FacesContext context = FacesContext.getCurrentInstance();
		if (vendedor.getId() == null) {
			dao.insere(vendedor);
			limpaTela();
		} else {
			dao.atualizar(vendedor);
			limpaTela();
			context.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Salvo com sucesso!", ""));
		}
		return "";
	}

	public String excluir() {
		VendedorDAO dao = new VendedorDAO();
		dao.delete(vendedor);
		limpaTela();
		return "";
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public List<Vendedor> getVendedores() {
		return vendedores;
	}


	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}


	public VendedorDAO getDao() {
		return dao;
	}


	public void setDao(VendedorDAO dao) {
		this.dao = dao;
	}


	
	
}