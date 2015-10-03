package com.atividade.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.atividade.entidades.Equipe;
import com.atividade.util.JpaUtil;

public class EquipeDAO extends BaseDAO {
	
	
	EntityManager em = JpaUtil.getEntityManager();
	
	public void insere(Equipe equipe) {
		em.getTransaction().begin();
		try {
			em.persist(equipe);
		} catch (Exception exc){
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
	}

	public void delete(Equipe equipe) {
		em.getTransaction().begin();
		try {
			em.remove(equipe);
		} catch (Exception exc){
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
	}

	public List<Equipe> buscarTodos() {

		return em.createQuery("SELECT e FROM Equipe e").getResultList();
		
		
	}

	public Equipe buscarPorId(int id) {
		return em.find(Equipe.class, id);
	}

		
public Equipe buscarNome(String descricao){
		
		return(Equipe) em.createQuery("select e from Equipe e " +
				 " where  descricao = : descricao").setParameter("descricao",descricao).getSingleResult();
	}

	public void atualizar(Equipe equipe) {
		em.getTransaction().begin();
		try {
			em.merge(equipe);
		} catch (Exception exc){
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
	}
	
	

}
