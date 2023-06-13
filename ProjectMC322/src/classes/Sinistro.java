package classes;

import java.util.Date;

public class Sinistro {
	private final int id;
	private Date data;
	private String endereco;
	private static int contador = 0;
	private Condutor condutor;
	private Seguro seguro;
	
	public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
		this.id = idGenerator();
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}

	public int getId() {
		return id;
	}

	// Sem setId por ser do tipo final

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	public int idGenerator() {
		// Id++
		int number = 1;
		number += contador;
		contador++;
		return number;
	}

	@Override
	public String toString() {
		return "Sinistro " + id + ", com data " + data + ", endereço " + endereco + "; do condutor " + condutor
				+ ", com o seguro: " + seguro + "\n";
	}
	
	
}
