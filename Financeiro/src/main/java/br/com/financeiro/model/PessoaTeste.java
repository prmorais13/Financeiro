package br.com.financeiro.model;

import br.com.financeiro.util.generic.GenericModel;

public class PessoaTeste extends GenericModel{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
