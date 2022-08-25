package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.EditoraDAO;
import br.edu.ifpb.model.entities.Editora;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class ConsultaEditorasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Editora> editoras;

	public void consultar() {
		EntityManager manager = JPAUtil.getEntityManager();
		EditoraDAO editoraDAO = new EditoraDAO(manager);
		this.editoras = editoraDAO.todas();
		manager.close();
	}

	public List<Editora> getEditoras() {
		return editoras;
	}

}
