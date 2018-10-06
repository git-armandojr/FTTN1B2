package br.edu.cefsa.ftt.bean;

public class TipoBEAN {
	
	private int Codigo;
    private String Descricao;
	
    public TipoBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoBEAN(int codigo, String descricao) {
		super();
		Codigo = codigo;
		Descricao = descricao;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
    
}
