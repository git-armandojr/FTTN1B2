package br.edu.cefsa.ftt.bean;

public class TipoBEAN {
	
	private int codigo;
    private String descricao;    
        
	public TipoBEAN() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public TipoBEAN(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public TipoBEAN(String codigo, String descricao) {
		setCodigo(codigo);
		setDescricao(descricao);
	}
	
	public TipoBEAN(String descricao) {
		setDescricao(descricao);
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
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
}
