package classes;
import java.util.ArrayList;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private final String tipoCliente;
	private Double valorSeguro;
	
	public Cliente(String nome, String endereco, String tipoCliente) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.tipoCliente = tipoCliente;
		this.valorSeguro = 0.0;
	}

	public Double getValorSeguro() {
		return valorSeguro;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String address) {
		this.endereco = address;
	}
	
	public void setValorSeguro(Double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public void addVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	
	public void removeVeiculo(Veiculo veiculo) {
		listaVeiculos.remove(veiculo);
	}
	
	public Veiculo searchVeiculo(String placa) {
		for(Veiculo veiculo : listaVeiculos) {
			if(veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}
		}
		return null;
	}
	
	public abstract String getidentificacao();
	
	public double contarVeiculos(Cliente cliente) {
		double contador = 0;
		for(Veiculo veiculo : listaVeiculos) {
			if(cliente.listaVeiculos.contains(veiculo)){
				contador++;
			}
		}
		return contador;
	}
	
	public double calculaScore(Cliente cliente) {
		double score;
		double quantidadeCarros = contarVeiculos(cliente);
		score = CalcSeguro.VALOR_BASE.getOperacao() * quantidadeCarros;
		return score;
	}

	public String toString() {
		return nome + ", residente no endereco " + endereco;
	}

}
