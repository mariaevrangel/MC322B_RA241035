package classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Seguradora {
	private String nome;
	private String phone;
	private String mail;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
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
	
	public Boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	public Boolean removeCliente(String id) {
		Iterator <Cliente> iterator = listaClientes.iterator();
		Iterator <Sinistro> iterator2 = listaSinistros.iterator();
		while (iterator.hasNext()) {
			Cliente procurado = iterator.next();
			if(procurado.getidentificacao().equals(id)) {
				while(iterator2.hasNext()) {
					Sinistro procurado2 = iterator2.next();
					if(procurado2.getCliente().equals(procurado)) {
						ArrayList <Veiculo> lista = procurado.getListaVeiculos();
						Iterator <Veiculo> iterator3 = lista.iterator();
						while (iterator3.hasNext()) {
							Veiculo procurado3 = iterator3.next();
							iterator3.remove();
						}
						iterator2.remove();
					}
				}
				iterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public Cliente searchCliente(String nome) {
		for(Cliente cliente : listaClientes) {
			if(cliente.getNome().equals(nome)) {
				return cliente;
			}
		}
		return null;
	}
	
	public void listarClientes(String tipoCliente) {
		for(Cliente cliente : listaClientes) {
			if(tipoCliente.equals("PF") && cliente.gettipoCliente().equals("PF")) {
				System.out.println(cliente);
			} else if(tipoCliente.equals("PJ") && cliente.gettipoCliente().equals("PJ")) {
				System.out.println(cliente);
			} else {
				
			}
		}
	}
		
	public void listarSinistros() {
		for(Sinistro sinistro : listaSinistros) {
				System.out.println(sinistro);	
		}
	}
	
	public Boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
		listaSinistros.add(sinistro);
		return true;
	}
		
	public Boolean visualizarSinistro(String id) {
		int cont = 0;
		for(Cliente client : listaClientes) {
			if (client.getidentificacao().equals(id)) {
				for(Sinistro sinistro : listaSinistros) {
					if (sinistro.getCliente().equals(client)) {
						System.out.println(sinistro);
						cont++;
					}
				}
			}
		}
		if (cont > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "Seguradora " + nome + ", com e-mail " + mail + ", telefone " + phone + 
				", no endereço: " + endereco + ". \n";
	}

}
