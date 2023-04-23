package classes;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
		
	public ClientePJ (String nome, String endereco, String tipoCliente, String cnpj, Date dataFundacao) {
		super(nome, endereco, tipoCliente);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
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

	// O oitavo digito não foi considerado como DV modulo 10 (mudanca de 1993)
	public boolean validarCNPJ(String cnpj) {
	    // So numero
	    cnpj = cnpj.replaceAll("[^\\d]", "");

	    // 14 digitos
	    int tamanho = cnpj.length();

	    // Verificar se todos os numeros sao iguais
	    boolean resposta = false;
	    char primeiro = cnpj.charAt(0);
	    for (int i = 1; i < tamanho; i++) {
	        if (cnpj.charAt(i) != primeiro) {
	            resposta = true;
	            break;
	        }
	    }
	    
	    if (tamanho != 14 || resposta == false) {
	    	return false;
	    }
	    
	    // Verificar digitos
	    int[] mult1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	    int[] mult2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	    String cnpj12digitos = cnpj.substring(0, 12);
	    int soma = 0;
	    for (int i = 0; i < (tamanho-2); i++) {
	    // 48 = posicao de '0' na tabela ASCII
	        int digito = (cnpj12digitos.charAt(i) - 48);
	        soma += digito * mult1[i];
	    }
	    int resto = 11 - (soma % 11);
	    // Nao sera usado 'X' 
	    char digit1 = '0';
	    if ((soma % 11) != 0 || (soma % 11) != 1) {
	    	digit1 = (char)(resto + 48);
	    }
	    cnpj12digitos += digit1;
	    soma = 0;
	    for (int i = 0; i < (tamanho - 1); i++) {
	    	int digito = (cnpj12digitos.charAt(i) - 48);
	        soma += digito * mult2[i];
	    }
	    resto = 11 - (soma % 11);
	    // Nao sera usado 'X'
	    char digit2 = '0';
	    if ((soma % 11) != 0 || (soma % 11) != 1) {
	    	digit2 = (char)(resto + 48);
	    }
	    cnpj12digitos += digit2;
	    
	    // CNPJ verdadeiro
	    if (cnpj.equals(cnpj12digitos)) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
	public String getidentificacao() {
		return getCnpj();
	}
	
	public String toString() {
		return "Cliente do CNPJ " + cnpj + ", fundado em " + dataFundacao + ", referente ao: " + super.toString() + ". \n";
	}
	
}