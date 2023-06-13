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
	
	public ArrayList<Frota> getListaFrota() {
		return listaFrota;
	}

	public void setListaFrota(ArrayList<Frota> listaFrota) {
		this.listaFrota = listaFrota;
	}

	public Boolean cadastrarFrota(Frota frota) {
		listaFrota.add(frota);
		return true;
	}
	
	public void atualizarFrota(Frota frota) {
		listaFrota.remove(frota);
	}
	
	public Frota searchFrota(String code) {
		for(Frota frota : listaFrota) {
			if(frota.getCode().equals(code)) {
				return frota;
			}
		}
		return null;
	}
	
	public double getVeiculosPorFrota(Frota frotas) {
		double contador = 0;
		for(Frota frota : listaFrota) {
			if(frota.equals(frotas)){
				contador = frota.getListaVeiculos().size();
				return contador;
			}
		}
		return contador;
	}
	
	public String toString() {
		return "Cliente do CNPJ " + cnpj + ", fundado em " + dataFundacao + "; referente ao: " + super.toString() + ". \n";
	}
	
}