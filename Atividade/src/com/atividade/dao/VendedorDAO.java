package com.atividade.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.atividade.entidades.Vendedor;
import com.atividade.util.JpaUtil;

public class VendedorDAO {

	EntityManager em = JpaUtil.getEntityManager();
	
	public void insere(Vendedor vendedor) {
		em.getTransaction().begin();
		try {
			em.persist(vendedor);
		} catch (Exception exc){
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
	}

	public void delete(Vendedor vendedor) {
		em.getTransaction().begin();
		try {
			em.remove(vendedor);
		} catch (Exception exc){
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
	}

	public List<Vendedor> buscarTodos() {
		return em.createQuery("SELECT v FROM Vendedor v").getResultList();
	}

	public Vendedor buscarPorId(int id) {
		return em.find(Vendedor.class, id);
	}

	public Vendedor buscarPorNome(String nome) {
		return em.find(Vendedor.class, nome);
	}

	public void atualizar(Vendedor vendedor) {
		em.getTransaction().begin();
		try {
			em.merge(vendedor);
		} catch (Exception exc){
			em.getTransaction().rollback();
		} finally {
			em.getTransaction().commit();
		}
	}

}
