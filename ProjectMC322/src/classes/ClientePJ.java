package classes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	int qtdDeFuncionarios;
	private ArrayList<Frota> listaFrota;
	private ArrayList<SeguroPJ> segurosPJ;
		
	public ClientePJ (String nome, String telefone, String endereco, String email, String tipoCliente, String cnpj, Date dataFundacao, int qtdDeFuncionarios) {
		super(nome, telefone, endereco, email, tipoCliente);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdDeFuncionarios = qtdDeFuncionarios;
		this.listaFrota = new ArrayList<Frota>();
		this.segurosPJ = new ArrayList<SeguroPJ>();
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

	public int getQtdDeFuncionarios() {
		return qtdDeFuncionarios;
	}

	public void setQtdDeFuncionarios(int qtdDeFuncionarios) {
		this.qtdDeFuncionarios = qtdDeFuncionarios;
	}
	
	public ArrayList<SeguroPJ> getSegurosPJ() {
		return segurosPJ;
	}

	public void setSegurosPJ(ArrayList<SeguroPJ> segurosPJ) {
		this.segurosPJ = segurosPJ;
	}
	
	public Double contarSinistros(Cliente cliente) {
		double contador = 0;
		for(Seguro seguro : segurosPJ) {
			if(seguro.getCliente().equals(cliente)){
				contador++;
			}
		}
		return contador;
	}

	public Boolean cadastrarFrota(Frota frota) {
		listaFrota.add(frota);
		return true;
	}
	
	public void atualizarFrota(Frota frota, Veiculo veiculo, String comando) {
		if (comando == "excluir") {
			listaFrota.remove(frota);
		} else if (comando == "remover") {
			frota.removeVeiculo(veiculo);
		} else if (comando == "adicionar") {
			frota.addVeiculo(veiculo);
		}
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
	
	public double calculaAnos(Date dataFundacao) {
		Calendar dateFundacao = Calendar.getInstance();
		dateFundacao.setTime(dataFundacao);
		Calendar today = Calendar.getInstance();

		int anos = today.get(Calendar.YEAR) - dateFundacao.get(Calendar.YEAR);
		int meses = today.get(Calendar.MONTH) - dateFundacao.get(Calendar.MONTH);
		int dias = today.get(Calendar.DAY_OF_MONTH) - dateFundacao.get(Calendar.DAY_OF_MONTH);

		// Ver se conta o ano que estamos ou não
		if (meses < 0 || (meses == 0 && dias < 0)) {
			anos--;
		}

		double idade = anos + meses / 12.0;

		return idade;
	}
	
	public String toString() {
		return "Cliente do CNPJ " + cnpj + ", fundado em " + dataFundacao + "; referente ao: " + super.toString() + ". \n";
	}
	
}