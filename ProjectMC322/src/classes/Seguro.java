package classes;

import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {
	private static int contador = 0;
	private final int id;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private Cliente cliente;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
	private int valorMensal;
	
	public Seguro(Cliente cliente, Date dataInicio, Date dataFim, Seguradora seguradora) {
		this.id = idGenerator();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.cliente = cliente;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaCondutores = new ArrayList<Condutor>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Seguro.contador = contador;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Condutor> getListaCondutores() {
		return listaCondutores;
	}

	public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}

	public int getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(int valorMensal) {
		this.valorMensal = valorMensal;
	}

	public int getId() {
		return id;
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
		return "Seguro [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", seguradora=" + seguradora
				+ ", listaSinistros=" + listaSinistros + ", listaCondutores=" + listaCondutores + ", valorMensal="
				+ valorMensal + "]";
	}
	
}