package classes;

import java.util.ArrayList;

public abstract class Frota {
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList<SeguroPJ> segurosPJ;
	
	public Frota(String code, Veiculo veiculo) {
		this.code = code;
		this.listaVeiculos = new ArrayList<Veiculo>();
		listaVeiculos.add(veiculo);
		this.segurosPJ = new ArrayList<SeguroPJ>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	public ArrayList<SeguroPJ> getSeguroPJ() {
		return segurosPJ;
	}

	public void setSeguroPJ(ArrayList<SeguroPJ> seguroPJ) {
		this.segurosPJ = seguroPJ;
	}
	
	public void addVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
	}
	
	public void removeVeiculo(Veiculo veiculo) {
		if(listaVeiculos.size() > 1) {
			listaVeiculos.remove(veiculo);
		} else {
			System.out.println("A remoção não é possível, pois toda frota necessita ter, no mínimo, um veículo. \n");
		}
	}

	public Boolean cadastrarSeguroPJ(SeguroPJ seguroPJ) {
		if (segurosPJ.size() == 0) {
			segurosPJ.add(seguroPJ);
			System.out.println("A frota está assegurada pelo " + seguroPJ + ". \n");
		} else {
			System.out.println("Esta frota já possui um seguro. É necessário removê-lo antes de adicionar um novo. \n");
			return false;
		}
		return true;
	}
	
	public Boolean removerSeguroPJ(SeguroPJ seguroPJ) {
		if (segurosPJ.size() == 0) {
			System.out.println("Esta frota não possui um seguro para que ele possa ser removido. \n");
			return false;
		} else {
			segurosPJ.remove(seguroPJ);
			System.out.println("Seguro removido com sucesso.");
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "frota " + code + "contém: " + listaVeiculos + ". \n";
	}
	
}