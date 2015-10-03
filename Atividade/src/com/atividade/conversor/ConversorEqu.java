package com.atividade.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.atividade.dao.EquipeDAO;
import com.atividade.entidades.Equipe;

@FacesConverter ( value="conversorEqu")
public class ConversorEqu implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		EquipeDAO eqdao = new EquipeDAO();
		Equipe eq = eqdao.buscarNome(arg2);
		
		return eq;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		Equipe eq = new Equipe();
		eq = (Equipe) arg2;
		
		return eq.getDescricao();
	}

	
}
