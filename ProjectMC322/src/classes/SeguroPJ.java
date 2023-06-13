package classes;

import java.util.Date;

public class SeguroPJ extends Seguro {
	private Frota frota;
	private ClientePJ clientePJ;
	
	public SeguroPJ(ClientePJ cliente, Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota) {
		super(cliente, dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.clientePJ = cliente;
	}

	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	public ClientePJ getClientePJ() {
		return clientePJ;
	}

	public void setClientePJ(ClientePJ clientePJ) {
		this.clientePJ = clientePJ;
	}

	public Condutor autorizarCondutor(Condutor condutor) {
		getListaCondutores().add(condutor);
		return condutor;
	}
	
	public Condutor desautorizarCondutor(Condutor condutor) {
		getListaCondutores().remove(condutor);
		return condutor;
	}
	
	public double calculaValor(ClientePJ cliente) {
		double fator;
		double qtdFuncionarios = cliente.getQtdDeFuncionarios();
		double anosFundacao = cliente.calculaAnos(cliente.getDataFundacao());
		double qtdSinistrosCliente = cliente.contarSinistros(cliente);
		double qtdSinistrosCondutor = qtdSinistrosCliente;
		int range = cliente.getListaFrota().size();
		double qtdVeiculos = 0.0;
		for (int i = 0; i <= range; i++) {
			for(Frota frota : cliente.getListaFrota()) {
				qtdVeiculos += cliente.getVeiculosPorFrota(frota);
			}
		}
		fator = CalcSeguro.VALOR_BASE.getOperacao() * (10 + (qtdFuncionarios/10)) * (1 + 1/(qtdVeiculos + 2)) * (1 + 1/(anosFundacao + 2)) * (2 + (qtdSinistrosCliente/10)) * (5 + qtdSinistrosCondutor /10);
		setValorMensal(fator);
		double valorMensal = fator;
		return valorMensal;
	}
	
	@Override
	public String toString() {
		return "SeguroPJ da " + frota + ", do cliente " + clientePJ + ". \n";
	}
	
}
	