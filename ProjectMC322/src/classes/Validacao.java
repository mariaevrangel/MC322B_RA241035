package classes;

public class Validacao {
	public static boolean validarNome(String nome) {
			for(char letra : nome.toCharArray()) {
				if (Character.isDigit(letra)) {
					return false;
				}
			}
			return true;
		}
		
	public static boolean validarCPF(String cpf) {
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
	
	// O oitavo digito não foi considerado como DV modulo 10 (mudanca de 1993)
		public static boolean validarCNPJ(String cnpj) {
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
}