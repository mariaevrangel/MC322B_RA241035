package classes;
import java.util.Date;

public class ClientePF extends Cliente {
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private final String cpf;
	private Date dataNascimento;
	
	public ClientePF (String nome, String endereco, Date dataLicenca, String educacao, String genero,
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

	public boolean validarCPF(String cpf) {
	    // So numero
	    cpf = cpf.replaceAll("[^\\d]", "");

	    // 11 digitos
	    int tamanho = cpf.length();

	    // Verificar se todos os numeros sao iguais
	    boolean resposta = false;
	    char primeiro = cpf.charAt(0);
	    for (int i = 1; i < tamanho; i++) {
	        if (cpf.charAt(i) != primeiro) {
	            resposta = true;
	            break;
	        }
	    }
	    
	    if (tamanho != 11 || resposta == false) {
	    	return false;
	    }
	    
	    // Verificar digitos
	    int[] mult1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
	    int[] mult2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	    String cpf9digitos = cpf.substring(0, 9);
	    int soma = 0;
	    for (int i = 0; i < (tamanho-2); i++) {
	    // 48 = posicao de '0' na tabela ASCII
	        int digito = (cpf9digitos.charAt(i) - 48);
	        soma += digito * mult1[i];
	    }
	    int resto = 11 - (soma % 11);
	    char digit1 = '0';
	    if ((soma % 11) != 10 || (soma % 11) != 11) {
	    	digit1 = (char)(resto + 48);
	    }
	    cpf9digitos += digit1;
	    soma = 0;
	    for (int i = 0; i < (tamanho - 1); i++) {
	    	int digito = (cpf9digitos.charAt(i) - 48);
	        soma += digito * mult2[i];
	    }
	    resto = 11 - (soma % 11);
	    char digit2 = '0';
	    if ((soma % 11) != 10 || (soma % 11) != 11) {
	    	digit2 = (char)(resto + 48);
	    }
	    cpf9digitos += digit2;
	    
	    // CPF verdadeiro
	    if (cpf.equals(cpf9digitos)) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	@Override
	public String getidentificacao() {
		return getCpf();
	}
	
	public String toString() {
		return "Cliente com CPF " + cpf + ", nascido em " + dataNascimento + ", refere-se a: " + super.toString() 
		+ ", com nível de educacao " + educacao + ", do genero " + genero + ", da classe econômica " + classeEconomica +
		". \n";
	}
	
}