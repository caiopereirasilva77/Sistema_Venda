package com.atividade.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.atividade.entidades.Equipe_Vendedor;

import com.atividade.util.JpaUtil;

public class Equipe_VendedorDAO extends BaseDAO {
	
	
	EntityManager em = JpaUtil.getEntityManager();
	
	public void insere(Equipe_Vendedor equipe_Vendedor){  
	
		em.getTransaction().begin();
		em.persist(equipe_Vendedor);
		em.getTransaction().commit();
	}

	public void delete(Equipe_Vendedor equipe_Vendedor){  
	
	
		equipe_Vendedor= (Equipe_Vendedor) em.find(Equipe_Vendedor.class, equipe_Vendedor.getId());
		em.getTransaction().begin();
		em.remove(equipe_Vendedor);
		em.getTransaction().commit();
	}

	
	public List<Equipe_Vendedor> buscarTodos() {  
		
		return em.createQuery("select ev from Equipevendedor ev").getResultList();
	}  

	public Equipe_Vendedor buscarPorId(int id) {  
		
		return em.find(Equipe_Vendedor.class, id);
		
	}  


	public void atualizar(Equipe_Vendedor equipe_Vendedor) {  
		
		em.getTransaction().begin();
		em.merge(equipe_Vendedor);
		em.getTransaction().commit();
		

}
	

	
	

}
