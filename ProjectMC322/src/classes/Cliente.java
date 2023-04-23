package classes;
import java.util.ArrayList;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private String tipoCliente;
	
	public Cliente(String nome, String endereco, String tipoCliente) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.tipoCliente = tipoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String address) {
		this.endereco = address;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
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
	
	public String gettipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipo) {
		tipoCliente = tipo;
	}
	
	public abstract String getidentificacao();

	public String toString() {
		return nome + ", residente no endereco " + endereco;
	}

}
