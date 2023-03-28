package classes;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	
	//validarCNPJ
	
	public ClientePJ (String nome, String endereco, Date dataLicenca, String educacao, 
			String genero, String classeEconomica, List <Veiculo> listaVeiculos, String cnpj, 
			Date dataFundacao) {
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	// Sem setCnpj porque eh do tipo final
	public String getCnpj() {
		return cnpj;
	}

	public String toString() {
		return "ClientePJ [cnpj=" + cnpj + ", dataFundacao=" + dataFundacao + ", toString()=" + super.toString() + "]";
	}
	
}