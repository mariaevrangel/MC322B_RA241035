package classes;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String toString() {
		return "Veiculo de placa " + placa + ", da marca " + marca + ", e modelo " + modelo + ". \n";
	}

}
