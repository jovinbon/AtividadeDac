package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.LivroDAO;
import br.edu.ifpb.model.entities.Livro;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class ConsultaLivrosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Livro> livros;

	public void consultar() {
		EntityManager manager = JPAUtil.getEntityManager();
		LivroDAO livroDAO = new LivroDAO(manager);
		this.livros = livroDAO.todos();
		manager.close();
	}

	public List<Livro> getLivros() {
		return livros;
	}

}
