package com.entidades;

import java.sql.Date;

public class Pessoa {
	// Atributos
	private int idPessoa;
	private String nome;
	private String cpf;
	private Date dtNascimento;
	private float altura;
	private float peso;
	
	// Construtores
	public Pessoa() {
	}

	public Pessoa(String nome, String cpf, Date dtNascimento, float altura, float peso) {
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.altura = altura;
		this.peso = peso;
	}

	// Getters and Setters
	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", dtNascimento=" + dtNascimento
				+ ", altura=" + altura + ", peso=" + peso + "]";
	}

	
}
