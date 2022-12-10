package negocio;

import java.util.ArrayList;

public class Bolao {
	
	private String nome;
	private ArrayList<String> paises;
	private ArrayList<Integer> placares;

	public Bolao() {
		paises = new ArrayList<String>();
		placares = new ArrayList<Integer>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getPaises() {
		return paises;
	}

	public void addPaises(String pais) {
		this.paises.add(pais);
	}

	public ArrayList<Integer> getPlacares() {
		return placares;
	}

	public void addPlacares(int placar) {
		this.placares.add(placar);
	}

}
