package classes;
import java.util.Date;

public class ClientePF extends Cliente {
	private final String cpf;
	private Date dataNascimento;
	
	public ClientePF (String nome, String endereco, Date dataLicenca, String educacao, 
			String genero, String classeEconomica, List <Veiculo> listaVeiculos, String cpf, 
			Date dataNascimento) {
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	//CPF nao tem setCPF, pois é do tipo final
	public String getCpf() {
		return cpf;
	}

	public Date getdataNascimento() {
		return dataNascimento;
	}

	public void setdataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public boolean validarCPF(String cpf) {
	    // Only numbers
	    cpf = cpf.replaceAll("[^\\d]", "");

	    // 11 digits
	    int tamanho = cpf.length();

	    // Verificar se todos os numeros são iguais
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
	    
	    // Verify digits
	    int[] mult1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
	    int[] mult2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	    String cpf9digitos = cpf.substring(0, 9);
	    //System.out.println(cpf9digitos);
	    int soma = 0;
	    for (int i = 0; i < (tamanho-2); i++) {
	    // 48 eh a posicao de '0' na tabela ASCII
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
	    
	    // True CPF
	    if (cpf.equals(cpf9digitos)) {
	    	return true;
	    } else {
	    	return false;
	    }
	}

	
	public String toString() {
		return "ClientePF [cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", toString()=" + super.toString() + "]";
	}

	
	
}