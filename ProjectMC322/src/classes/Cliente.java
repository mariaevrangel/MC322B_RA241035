package classes;
import java.util.Date;
import java.util.List;

public class Cliente {
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private List<Veiculo> listaVeiculos;
	
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, 
			String genero, String classeEconomica, List<Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = new List<Veiculo>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String address) {
		this.endereco = address;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
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

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public String toString() {
		return "Cliente " + nome + ", residente no endereco =" + endereco + ", com nível de educacao " + educacao +
				", do genero " + genero + ", incluso na classe econômica " + classeEconomica + ". \n";
	}

}
