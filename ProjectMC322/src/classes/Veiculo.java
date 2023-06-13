package classes;

import java.util.ArrayList;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private ArrayList<SeguroPF> segurosPF;
	
	public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.segurosPF = new ArrayList<SeguroPF>();
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public ArrayList<SeguroPF> getSeguroPF() {
		return segurosPF;
	}

	public void setSeguroPF(ArrayList<SeguroPF> seguroPF) {
		this.segurosPF = seguroPF;
	}
	
	public Boolean cadastrarSeguroPF(SeguroPF seguroPF) {
		if (segurosPF.size() == 0) {
			segurosPF.add(seguroPF);
			System.out.println("O veículo está assegurado pelo " + seguroPF + ". \n");
		} else {
			System.out.println("Este veículo já possui um seguro. É necessário removê-lo antes de adicionar um novo. \n");
			return false;
		}
		return true;
	}
	
	public Boolean removerSeguroPF(SeguroPF seguroPF) {
		if (segurosPF.size() == 0) {
			System.out.println("Este veículo não possui um seguro para que ele possa ser removido. \n");
			return false;
		} else {
			segurosPF.remove(seguroPF);
			System.out.println("Seguro removido com sucesso.");
		}
		return true;
	}

	public String toString() {
		return "Veiculo com placa " + placa + ", da marca " + marca + " e modelo " + modelo + ", fabricado em " + anoFabricacao + ". \n";
	}

}
