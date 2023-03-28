package classes;

public class Seguradora {
	private String nome;
	private String phone;
	private String mail;
	private String endereco;
	private List <Sinistro> listaSinistros;
	private List <Cliente> listaClientes;
	
	// adicionar listas no construtor
	// fazer gets e sets das listas
	// boolean cadastrarCliente(Cliente cliente):
	// boolean removerCliente (String cliente):
	// List <Cliente> listarClientes (String tipoCliente):
	// boolean gerarSinistro(): 
	// boolean visualizarSinistro (String cliente):
	// List <Sinistro> listarSinistros(): 
	
	public Seguradora(String nome, String phone, String mail, String endereco) {
		this.nome = nome;
		this.phone = phone;
		this.mail = mail;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		return "Seguradora " + nome + ", com e-mail " + mail + ", telefone " + phone + 
				", no endereço: " + endereco + ". \n";
	}

}
