package br.edu.ifpb.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.edu.ifpb.model.dao.EditoraDAO;
import br.edu.ifpb.model.entities.Editora;
import br.edu.ifpb.model.util.JPAUtil;

@FacesConverter(forClass = Editora.class)
public class EditoraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Editora retorno = null;
		EntityManager manager = JPAUtil.getEntityManager();
		try {
			if (value != null && !"".equals(value)) {
				EditoraDAO pessoas = new EditoraDAO(manager);
				retorno = pessoas.porId(new Long(value));
			}
			return retorno;
		} finally {
			manager.close();
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Editora) value).getCodigo().toString();
		}
		return null;
	}
}
