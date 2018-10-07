package br.edu.cefsa.ftt.bean;

public class AtributoBEAN {
	
	private int codigo;
    private String descricao;
	
    public AtributoBEAN() {
		super();
		// TODO Auto-generated constructor stub
	} 

	public AtributoBEAN(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
