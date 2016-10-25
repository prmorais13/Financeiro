package br.com.financeiro.teste;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.financeiro.model.Lancamento;
import br.com.financeiro.model.Pessoa;
import br.com.financeiro.model.TipoLancamento;

public class GeraTabela {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinanceiroPU");
		EntityManager manager = factory.createEntityManager();
		Pessoa p = new Pessoa();
		p.setNome("Paulo Roberto");
		
		Lancamento lanc = new Lancamento();
		lanc.setDataPagamento(new Date());
		lanc.setDataVencimento(new Date());
		lanc.setDescricao("Teste");
		lanc.setPessoa(p);
		lanc.setTipo(TipoLancamento.RECEITA);
		lanc.setValor(BigDecimal.valueOf(100.00));
		
		manager.persist(p);
		manager.persist(lanc);
	}
}
