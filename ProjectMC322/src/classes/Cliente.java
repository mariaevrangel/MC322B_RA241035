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

	
	//funcao toString, pode usar a pronta? aparece aquele link
	
	//fazer funcao validarCPF
	
}
