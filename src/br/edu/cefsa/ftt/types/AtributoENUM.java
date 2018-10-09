package br.edu.cefsa.ftt.types;

public enum AtributoENUM {    
    AGUA(1), DIVINO(2), FOGO(3), LUZ(4), TERRA(5), TREVAS(6), VENTO(7);
     
    private final int codigo;
    
    AtributoENUM(int codigo){
    	this.codigo = codigo;
    }
    public int getValor(){
        return codigo;
    }
}
