package br.com.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.financeiro.model.Pessoa;
import br.com.financeiro.repository.Pessoas;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private List<Pessoa> todasPessoas;
	
	@Inject
	private Pessoas pessoas;
	
	@PostConstruct
	public void iniciar(){
		this.pessoa = new Pessoa();
		this.todasPessoas = this.pessoas.todos();
	}
	
	public void cadastrar(){
		this.pessoas.adicionar(this.pessoa);
		this.iniciar();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}

}
