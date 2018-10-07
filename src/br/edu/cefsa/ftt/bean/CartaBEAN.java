package br.edu.cefsa.ftt.bean;

import java.io.FileInputStream;

public class CartaBEAN {
	
	private int codigo;
    private String nome;
    private int ataque;
    private int defesa;
    private FileInputStream foto; // Fotos são armazenadas no banco através de array de bytes.
    private TipoBEAN tipo; //Fará referência a uma outra tabela, categoriza a carta
    private AtributoBEAN atributo; // Referenciado em outra tabela do banco
	
    public CartaBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}   

	public CartaBEAN(int codigo, String nome, int ataque, int defesa, FileInputStream foto, TipoBEAN tipo,
			AtributoBEAN atributo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ataque = ataque;
		this.defesa = defesa;
		this.foto = foto;
		this.tipo = tipo;
		this.atributo = atributo;
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

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public FileInputStream getFoto() {
		return foto;
	}	
	
	public void setFoto(FileInputStream foto) {
		this.foto = foto;
	}
	

	public TipoBEAN getTipo() {
		return tipo;
	}

	public void setTipo(TipoBEAN tipo) {
		this.tipo = tipo;
	}

	public AtributoBEAN getAtributo() {
		return atributo;
	}

	public void setAtributo(AtributoBEAN atributo) {
		this.atributo = atributo;
	}
	
}
