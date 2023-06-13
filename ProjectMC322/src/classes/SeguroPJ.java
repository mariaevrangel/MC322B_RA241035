package classes;

import java.util.Date;

public class SeguroPJ extends Seguro {
	private Frota frota;
	private ClientePJ clientePJ;
	
	public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientePJ clientePJ) {
		super(dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.clientePJ = clientePJ;
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

	@Override
	public String toString() {
		return "SeguroPJ da " + frota + ", do cliente " + clientePJ + ". \n";
	}
	
}
	