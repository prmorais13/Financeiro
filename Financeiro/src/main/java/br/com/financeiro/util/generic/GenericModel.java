package br.com.financeiro.util.generic;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GenericModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

}
