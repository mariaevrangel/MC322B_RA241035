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
	private double valorMensal = 0.0;
	
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

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double fator) {
		this.valorMensal = fator;
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

	public Sinistro gerarSinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
		Sinistro sinistro = new Sinistro(data, endereco, condutor, seguro);
		return sinistro;
	}
	
	public void listarCondutor() {
		for(Condutor condutor : listaCondutores) {
				System.out.println(condutor);	
		}
	}
	
	public Condutor autorizarCondutor(Condutor condutor) {
		listaCondutores.add(condutor);
		return condutor;
	}
	
	public Condutor desautorizarCondutor(Condutor condutor) {
		listaCondutores.remove(condutor);
		return condutor;
	}
	
	public double calculaValor(){
		return valorMensal;
	}
	
	@Override
	public String toString() {
		return "Seguro [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", seguradora=" + seguradora
				+ ", listaSinistros=" + listaSinistros + ", listaCondutores=" + listaCondutores + ", valorMensal="
				+ valorMensal + "]";
	}
	
}