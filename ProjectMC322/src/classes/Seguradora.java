package classes;

import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String phone;
	private String mail;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	// boolean gerarSinistro(): 
	// boolean visualizarSinistro (String cliente): 
	
	public Seguradora(String nome, String phone, String mail, String endereco) {
		this.nome = nome;
		this.phone = phone;
		this.mail = mail;
		this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
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
	
	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public boolean cadastrarCliente(Cliente cliente) {
		return listaClientes.add(cliente);
	}
	
	public boolean removeCliente(Cliente cliente) {
		return listaClientes.remove(cliente);
	}
	
	public Cliente searchCliente(String nome) {
		for(Cliente cliente : listaClientes) {
			if(cliente.getNome().equals(nome)) {
				return cliente;
			}
		}
		return null;
	}
	
	/*public void listarClientes(String tipoCliente) {
		if(tipoCliente.equals("PF")) {
			for(ClientePF cliente : listaClientes) {
				System.out.println(cliente);	
		} else if(tipoCliente.equals("PJ")) {
			for(ClientePJ cliente : listaClientes) {
				System.out.println(cliente);
		}
	}*/
		
	public void listarSinistros() {
		for(Sinistro sinistro : listaSinistros) {
				System.out.println(sinistro);	
		}
	}
	
	/*public void visualizarSinistro(String cliente) {
		for(Cliente client : listaClientes) {
				System.out.println(cliente);	
		}
	}*/
	
	public String toString() {
		return "Seguradora " + nome + ", com e-mail " + mail + ", telefone " + phone + 
				", no endereço: " + endereco + ". \n";
	}

}
