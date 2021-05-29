package br.com.guilherme.romano.domain.model;

public enum AlgarismosRomanos {
	
	M(1000),
	D(500),
	C(100),
	L(50),
	X(10),
	V(5),
	I(1);
	
	public Integer valorAlgarismo;
	AlgarismosRomanos(Integer valor) {
		this.valorAlgarismo = valor;
	}
	
	 public static AlgarismosRomanos asAlgarismoRomano(String algarismo) {
        for (AlgarismosRomanos algarismoRomano : AlgarismosRomanos.values()) {
            if (algarismoRomano.name().equalsIgnoreCase(algarismo))
                return algarismoRomano;
        }
        return null;
    }
}
