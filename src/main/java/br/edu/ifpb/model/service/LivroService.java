package br.edu.ifpb.model.service;

import java.io.Serializable;

import br.edu.ifpb.model.dao.LivroDAO;
import br.edu.ifpb.model.entities.Livro;

public class LivroService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private LivroDAO livroDAO;

	public LivroService(LivroDAO livroDAO) {
		this.livroDAO = livroDAO;
	}
	
	public void salvar(Livro livro) {
		this.livroDAO.addLivro(livro);
	}

}
