package br.edu.ifpb.model.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.ifpb.model.dao.EditoraDAO;
import br.edu.ifpb.model.dao.LivroDAO;
import br.edu.ifpb.model.entities.Editora;
import br.edu.ifpb.model.entities.Livro;
import br.edu.ifpb.model.service.LivroService;
import br.edu.ifpb.model.util.JPAUtil;

@ManagedBean
@ViewScoped
public class CadastroLivroBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Livro livro = new Livro();
	private List<Editora> editoras;

	public void preparaListaDeEditoras() {
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			EditoraDAO editoraDAO = new EditoraDAO(manager);
			editoras = editoraDAO.todas();
		} finally {
			manager.close();
		}
	}

	public void salvar() {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			trx.begin();

			LivroService livroService = new LivroService(new LivroDAO(manager));
			livroService.salvar(livro);

			this.livro = new Livro();

			context.addMessage(null, new FacesMessage("Livro salvo com sucesso!"));

			trx.commit();
		} catch (Exception e) {
			trx.rollback();

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Editora> getEditoras() {
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

}
