package com.medschedule.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_medicos")
public class Medico extends Pessoa{
	
	private String crm;
	private String especialidade;
	
	public Medico() {
		super();
	}
	
	public Medico(Long id, String nome, String cpf, String email, String crm, String especialidade) {
        super(id, nome, cpf, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
