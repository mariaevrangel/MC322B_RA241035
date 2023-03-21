package classes;

public class Cliente {
	private String nome;
	private String cpf;
	private String birth;
	private int age;
	private String address;
	
	public Cliente(String nome, String cpf, String birth, int age, String address) {
		this.nome = nome;
		this.cpf = cpf;
		this.birth = birth;
		this.age = age;
		this.address = address;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "Cliente " + nome + ", CPF " + cpf + ", nascido em " + birth + ", com " + age +
				" anos, e endereço: " + address + ". \n";
	}

}
