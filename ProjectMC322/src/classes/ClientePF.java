package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private String educacao;
	private Date dataNascimento;
	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList<SeguroPF> segurosPF;

	public ClientePF(String nome, String telefone, String endereco, String email, String cpf, String genero, String educacao, 
			Date dataNascimento, String tipoCliente) {
		super(nome, telefone, endereco, email, tipoCliente);
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.educacao = educacao;
		this.genero = genero;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.segurosPF = new ArrayList<SeguroPF>();
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public ArrayList<SeguroPF> getSegurosPF() {
		return segurosPF;
	}

	public void setSegurosPF(ArrayList<SeguroPF> segurosPF) {
		this.segurosPF = segurosPF;
	}

	public String getCpf() {
		return cpf;
	}

	// Sem setCPF por ser do tipo final

	public Date getdataNascimento() {
		return dataNascimento;
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
	
	public double contarVeiculos(ClientePF cliente) {
		double contador = 0;
		for(Veiculo veiculo : listaVeiculos) {
			if(cliente.listaVeiculos.contains(veiculo)){
				contador++;
			}
		}
		return contador;
	}
	
	public void setdataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double calculaIdade(Date dataNascimento) {
		Calendar dateNascimento = Calendar.getInstance();
		dateNascimento.setTime(dataNascimento);
		Calendar today = Calendar.getInstance();

		int anos = today.get(Calendar.YEAR) - dateNascimento.get(Calendar.YEAR);
		int meses = today.get(Calendar.MONTH) - dateNascimento.get(Calendar.MONTH);
		int dias = today.get(Calendar.DAY_OF_MONTH) - dateNascimento.get(Calendar.DAY_OF_MONTH);

		// Ver se conta o ano que estamos ou não
		if (meses < 0 || (meses == 0 && dias < 0)) {
			anos--;
		}

		double idade = anos + meses / 12.0;

		return idade;
	}

	@Override
	public String getidentificacao() {
		return getCpf();
	}

	public String toString() {
		return "Cliente com CPF " + cpf + ", nascido em " + dataNascimento + ", refere-se a: " + super.toString()
				+ ", com nível de educacao " + educacao + ", do genero " + genero + ". \n";
	}

}