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

	    // Exigencia 11 dígitos
	    int tamanho = cpf.length();
	    if (tamanho != 11) {
	        return false;
	    }

	    // Verificar se todos os numeros são iguais
	    boolean resposta = false;
	    char primeiro = cpf.charAt(0);
	    for (int i = 1; i < tamanho; i++) {
	        if (cpf.charAt(i) != primeiro) {
	            resposta = true;
	            break;
	        }
	    }
	    return resposta;

	    // Calcular os dígitos verificadores

	    // Verificar se os dígitos verificadores calculados são iguais aos dígitos verificadores do CPF
	    
	}

	public String toString() {
		return "Cliente " + nome + ", CPF " + cpf + ", nascido em " + birth + ", com " + age +
				" anos, e endereço:" + address + ".";
	}

}
