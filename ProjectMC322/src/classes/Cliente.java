package classes;

public abstract class Cliente {
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private final String tipoCliente;
	
	
	public Cliente(String nome, String telefone, String endereco, String email, String tipoCliente) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.tipoCliente = tipoCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String address) {
		this.endereco = address;
	}
	
	public abstract String getidentificacao();
	
	public String toString() {
		return nome + ", com o telefone" + telefone + "e e-mail" + email + ", residente no endereço " + endereco;
	}

}
