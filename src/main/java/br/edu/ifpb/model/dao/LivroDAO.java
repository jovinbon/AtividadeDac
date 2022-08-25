package br.edu.ifpb.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifpb.model.entities.Livro;

public class LivroDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public LivroDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void addLivro(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todos() {
		TypedQuery<Livro> query = manager.createQuery("FROM Livro", Livro.class);
		return query.getResultList();
	}

}
