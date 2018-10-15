package br.edu.cefsa.ftt.bean;

import java.io.FileInputStream;

public class JogadorBEAN {
	private FileInputStream foto;
	private int codigo;
	private String nome;
	private String apelido;
	private String cpf;
	private String nacionalidade;
	public FileInputStream getFoto() {
		return foto;
	}
	public void setFoto(FileInputStream foto) {
		this.foto = foto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
}
