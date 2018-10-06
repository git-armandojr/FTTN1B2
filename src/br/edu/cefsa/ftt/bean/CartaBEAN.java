package br.edu.cefsa.ftt.bean;

public class CartaBEAN {
	
	private byte[] Foto; // Fotos são armazenadas no banco através de array de bytes.
    private int Codigo;
    private TipoBEAN Tipo; //Fará referência a uma outra tabela, categoriza a carta
    private String Nome;
    private int Ataque;
    private int Defesa;
    private AtributoBEAN Atributo; // Referenciado em outra tabela do banco
	
    public CartaBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartaBEAN(byte[] foto, int codigo, TipoBEAN tipo, String nome, int ataque, int defesa,
			AtributoBEAN atributo) {
		super();
		Foto = foto;
		Codigo = codigo;
		Tipo = tipo;
		Nome = nome;
		Ataque = ataque;
		Defesa = defesa;
		Atributo = atributo;
	}

	public byte[] getFoto() {
		return Foto;
	}

	public void setFoto(byte[] foto) {
		Foto = foto;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public TipoBEAN getTipo() {
		return Tipo;
	}

	public void setTipo(TipoBEAN tipo) {
		Tipo = tipo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getAtaque() {
		return Ataque;
	}

	public void setAtaque(int ataque) {
		Ataque = ataque;
	}

	public int getDefesa() {
		return Defesa;
	}

	public void setDefesa(int defesa) {
		Defesa = defesa;
	}

	public AtributoBEAN getAtributo() {
		return Atributo;
	}

	public void setAtributo(AtributoBEAN atributo) {
		Atributo = atributo;
	}
}
