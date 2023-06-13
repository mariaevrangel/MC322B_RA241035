package classes;
import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private ArrayList<Frota> listaFrota;
		
	public ClientePJ (String nome, String telefone, String endereco, String email, String tipoCliente, String cnpj, Date dataFundacao, int qtdDeFuncionarios) {
		super(nome, telefone, endereco, email, tipoCliente);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.listaFrota = new ArrayList<Frota>();
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	// Sem setCnpj por ser do tipo final
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	@Override
	public String getidentificacao() {
		return getCnpj();
	}
	
	public double calculaScore(ClientePJ cliente) {
		double score;
		double funcionarios = cliente.getQtdDeFuncionarios();
		score = super.calculaScore(cliente) * (1 + (funcionarios/100));
		return score;
	}
	
	public String toString() {
		return "Cliente do CNPJ " + cnpj + ", fundado em " + dataFundacao + ", com " + qtdDeFuncionarios + "funcionários; referente ao: " + super.toString() + ". \n";
	}
	
}