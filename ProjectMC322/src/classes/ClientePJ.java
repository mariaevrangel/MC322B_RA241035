package classes;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
		
	public ClientePJ (String nome, String endereco, Date dataLicenca, String educacao, 
			String genero, String classeEconomica, List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao) {
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

	public String getCnpj() {
		return cnpj;
	}

	// Sem setCnpj por ser do tipo final
	
	// O oitavo dígito não foi considerado como DV módulo 10 (mudança de 1993)
	public boolean validarCNPJ(String cnpj) {
	    // Só número
	    cnpj = cnpj.replaceAll("[^\\d]", "");

	    // 14 dígitos
	    int tamanho = cnpj.length();

	    // Verificar se todos os números são iguais
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
	    
	    // Verificar dígitos
	    int[] mult1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	    int[] mult2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	    String cnpj12digitos = cnpj.substring(0, 12);
	    int soma = 0;
	    for (int i = 0; i < (tamanho-2); i++) {
	    // 48 = posição de '0' na tabela ASCII
	        int digito = (cnpj12digitos.charAt(i) - 48);
	        soma += digito * mult1[i];
	    }
	    int resto = 11 - (soma % 11);
	    // Não será usado 'X' 
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
	    // Não será usado 'X'
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
	
	public String toString() {
		return "ClientePJ do CNPJ " + cnpj + ", fundado em " + dataFundacao + ", referente ao: " + super.toString() + ". \n";
	}
	
}