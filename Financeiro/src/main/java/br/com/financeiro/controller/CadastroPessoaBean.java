package br.com.financeiro.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.cfg.OneToOneSecondPass;
import org.primefaces.event.SelectEvent;

import br.com.financeiro.model.Pessoa;
import br.com.financeiro.repository.Pessoas;

@Named
@ViewScoped
public class CadastroPessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Pessoa pessoaSelecionada;
	private List<Pessoa> todasPessoas;
	
	@Inject
	private Pessoas pessoas;
	
	@PostConstruct
	public void iniciar(){
		this.pessoa = new Pessoa();
		this.pessoaSelecionada = new Pessoa();
		this.todasPessoas = this.pessoas.todos();
	}
	
	public void cadastrar(){
		this.pessoas.adicionar(this.pessoa);
		this.iniciar();
	}
	
	public void alterar(SelectEvent event) {
		//this.pessoa = (Pessoa) event.getObject();
		//this.pessoa = this.pessoas.porId(this.pessoaSelecionada.getId());
		this.pessoa = this.pessoaSelecionada;

/*		Pessoa p = (Pessoa) event.getObject();
		Cliente c2 = clienteDAO.localizar(c.getCodigoPessoa());
		c2.setNome(c.getNome());

		clienteDAO.atualizar(c2);
		clientes = clienteDAO.localizarAll();*/
	}
	
	public void excluir(){
		if (this.pessoa.getId() != 0){
			this.pessoas.remover(this.pessoa);
			this.iniciar();
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Atenção...",
					"Selecione um registro na tabela para excluir."));
		}
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}


	public List<Pessoa> getTodasPessoas() {
		return todasPessoas;
	}

}
