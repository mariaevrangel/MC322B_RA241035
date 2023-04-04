package classes;

public class Sinistro {
	private final int id;
	private String data;
	private String endereco;
	private static int contador = 0;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, 
			Cliente cliente) {
		this.id = idGenerator();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	// Sem setId por ser do tipo final

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

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int idGenerator() {
		// Id++
		int number = 1;
		number += contador;
		contador++;
		return number;
	}
	
	public String toString() {
		return "Sinistro " + id + ", gerado na data " + data + ", com endereco " + endereco + ", da seguradora " + 
				seguradora + ", referente ao veiculo " + veiculo + ", do cliente " + cliente + ". \n";
	}

}
