package br.edu.cefsa.ftt.bean;

import br.edu.cefsa.ftt.types.AtributoENUM;

public class CartaBEAN {
	
	private int codigo;
    private String nome;
    private int ataque;
    private int defesa;
    private String foto; // Fotos são armazenadas no banco através de array de bytes.
    private TipoBEAN tipo; //Fará referência a uma outra tabela, categoriza a carta
    private AtributoENUM atributo; // Referenciado em outra tabela do banco
	
    public CartaBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}   

	public CartaBEAN(int codigo, String nome, int ataque, int defesa, String foto, TipoBEAN tipo,
			AtributoENUM atributo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ataque = ataque;
		this.defesa = defesa;
		this.foto = foto;
		this.tipo = tipo;
		this.atributo = atributo;
	}



	public CartaBEAN(String codigo, String nome, String ataque, String defesa, String foto,
			String tipo, String atributo) {
		setCodigo(codigo);
		setNome(nome);
		setAtaque(ataque);
		setDefesa(defesa);
		setFoto(foto);
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo != null)
		   this.codigo = Integer.valueOf(codigo);
		else
		   this.codigo = 0;
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
	
	public void setAtaque(String ataque) {
		if (ataque != null)
		   this.ataque = Integer.valueOf(ataque);
		else
		   this.ataque = 0;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	
	public void setDefesa(String defesa) {
		if (defesa != null)
		   this.defesa = Integer.valueOf(defesa);
		else
		   this.defesa = 0;
	}

	public String getFoto() {
		return foto;
	}	
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public TipoBEAN getTipo() {
		return tipo;
	}

	public void setTipo(TipoBEAN tipo) {
		this.tipo = tipo;
	}

	public AtributoENUM getAtributo() {
		return atributo;
	}

	public void setAtributo(AtributoENUM atributo) {
		this.atributo = atributo;
	}
	
}
