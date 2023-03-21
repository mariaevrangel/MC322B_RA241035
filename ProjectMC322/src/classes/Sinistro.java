package classes;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	private static int contador = 0;
	
	public Sinistro(int id, String data, String endereco) {
		this.id = idGenerator();
		this.data = data;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int idGenerator() {
		//id++
		int number = 1;
		number += contador;
		contador++;
		return number;
	}

	public String toString() {
		return "Identificacao do sinistro" + id + ", datado em " + data + ", no endereço:" + endereco + ".";
	}

}
