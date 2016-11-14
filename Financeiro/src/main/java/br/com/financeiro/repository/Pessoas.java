package br.com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.financeiro.model.Pessoa;
import br.com.financeiro.util.jpa.Transactional;

public class Pessoas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public void adicionar(Pessoa pessoa){
		this.manager.merge(pessoa);
	}
	
	@Transactional
	public void remover(Pessoa pessoa){
		pessoa = porId(pessoa.getId());
		this.manager.remove(pessoa);
	}
	
	public List<Pessoa> todos(){
		return this.manager.createQuery("FROM Pessoa ORDER BY nome", Pessoa.class).getResultList();
	}

	public Pessoa porId(Long id){
		return this.manager.find(Pessoa.class, id);
	}
}
