package classes;

import java.util.Calendar;
import java.util.Date;

public class ClientePF extends Cliente {
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private final String cpf;
	private Date dataNascimento;

	public ClientePF(String nome, String endereco, Date dataLicenca, String educacao, String genero,
			String classeEconomica, String tipoCliente, String cpf, Date dataNascimento) {
		super(nome, endereco, tipoCliente);
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	// Sem setCPF por ser do tipo final

	public Date getdataNascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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


	public double calculaScore(ClientePF cliente) {
		double score, fator;
		double idade = cliente.calculaIdade(cliente.getdataNascimento());
		if (idade <= 30.0) {
			fator = CalcSeguro.FATOR_18_30.getOperacao();
		} else if (idade > 30.0 && idade <= 60.0) {
			fator = CalcSeguro.FATOR_30_60.getOperacao();
		} else if (idade > 60.0 && idade <= 90.0) {
			fator = CalcSeguro.FATOR_60_90.getOperacao();
		} else {
			fator = 0;
		}
		score = super.calculaScore(cliente) * fator;
		return score;
	}

	@Override
	public String getidentificacao() {
		return getCpf();
	}

	public String toString() {
		return "Cliente com CPF " + cpf + ", nascido em " + dataNascimento + ", refere-se a: " + super.toString()
				+ ", com nível de educacao " + educacao + ", do genero " + genero + ", da classe econômica "
				+ classeEconomica + ". \n";
	}

}