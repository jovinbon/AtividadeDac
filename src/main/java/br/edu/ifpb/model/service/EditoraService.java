package br.edu.ifpb.model.service;

import java.io.Serializable;

import br.edu.ifpb.model.dao.EditoraDAO;
import br.edu.ifpb.model.entities.Editora;

public class EditoraService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EditoraDAO editoraDAO;

	public EditoraService(EditoraDAO editoraDAO) {
		this.editoraDAO = editoraDAO;
	}
	
	public void salvar(Editora editora) {
		this.editoraDAO.addEditora(editora);
	}

}
