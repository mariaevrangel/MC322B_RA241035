package classes;

import java.util.Date;

public class SeguroPF extends Seguro {
	private Veiculo veiculo;
	private ClientePF clientePF;
	
	public SeguroPF(ClientePF cliente, Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo) {
		super(cliente, dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.clientePF = cliente;
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
	
	public Condutor autorizarCondutor(Condutor condutor) {
		getListaCondutores().add(condutor);
		return condutor;
	}
	
	public Condutor desautorizarCondutor(Condutor condutor) {
		getListaCondutores().remove(condutor);
		return condutor;
	}
	
	public double calculaValor(ClientePF cliente) {
		double fator;
		double quantidadeCarros = cliente.contarVeiculos(cliente);
		double quantidadeSinistrosCliente = cliente.contarSinistros(cliente);
		double quantidadeSinistrosCondutor = quantidadeSinistrosCliente;
		double idade = cliente.calculaIdade(cliente.getdataNascimento());
		if (idade <= 30.0) {
			fator = CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_18_30.getOperacao() * (1 + 1/(quantidadeCarros + 2)) * (2 + (quantidadeSinistrosCliente/10)) *(5 + (quantidadeSinistrosCondutor/10));
		} else if (idade > 30.0 && idade <= 60.0) {
			fator = CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_30_60.getOperacao() * (1 + 1/(quantidadeCarros + 2)) * (2 + (quantidadeSinistrosCliente/10)) *(5 + (quantidadeSinistrosCondutor/10));
		} else if (idade > 60.0 && idade <= 90.0) {
			fator = CalcSeguro.VALOR_BASE.getOperacao() * CalcSeguro.FATOR_60_90.getOperacao() * (1 + 1/(quantidadeCarros + 2)) * (2 + (quantidadeSinistrosCliente/10)) *(5 + (quantidadeSinistrosCondutor/10));
		} else {
			fator = 0;
		}
		setValorMensal(fator);
		double valorMensal = fator;
		return valorMensal;
	}

	@Override
	public String toString() {
		return "Seguro de PF cobre o veículo " + veiculo + ", do cliente " + clientePF + "\n";
	}
	
}
	