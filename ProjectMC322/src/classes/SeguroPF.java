package classes;

import java.util.Date;

public class SeguroPF extends Seguro {
	private Veiculo veiculo;
	private ClientePF clientePF;
	
	public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF clientePF) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.clientePF = clientePF;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public ClientePF getClientePF() {
		return clientePF;
	}

	public void setClientePF(ClientePF clientePF) {
		this.clientePF = clientePF;
	}

	@Override
	public String toString() {
		return "Seguro de PF cobre o veículo " + veiculo + ", do cliente " + clientePF + "\n";
	}
	
}
	