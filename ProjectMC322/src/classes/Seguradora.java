package classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String phone;
	private String mail;
	private String endereco;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Double> listaValorSeguros;
	
	public Seguradora(String cnpj, String nome, String phone, String mail, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.phone = phone;
		this.mail = mail;
		this.endereco = endereco;
		this.listaSeguros = new ArrayList<Seguro>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaValorSeguros = new ArrayList<>();
	}

	public String getCnpj() {
		return cnpj;
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
	
	public ArrayList<Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public ArrayList<Double> getListaValorSeguros() {
		return listaValorSeguros;
	}

	public void setListaValorSeguros(ArrayList<Double> listaValorSeguros) {
		this.listaValorSeguros = listaValorSeguros;
	}

	public Boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	public Boolean removerCliente(String id) {
		Iterator <Cliente> iterator = listaClientes.iterator();
		Iterator <Seguro> iterator2 = listaSeguros.iterator();
		while (iterator.hasNext()) {
			Cliente procurado = iterator.next();
			if(procurado.getidentificacao().equals(id)) {
				while(iterator2.hasNext()) {
					Seguro procurado2 = iterator2.next();
					iterator2.remove();
					}
				}
				iterator.remove();
				return true;
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
			if(tipoCliente.equals("PF") && cliente.getTipoCliente().equals("PF")) {
				System.out.println(cliente);
			} else if(tipoCliente.equals("PJ") && cliente.getTipoCliente().equals("PJ")) {
				System.out.println(cliente);
			} else {
				
			}
		}
	}
		
	public ArrayList<Seguro> getSegurosPorCliente (Cliente cliente) {
		ArrayList<Seguro> segurosCliente = new ArrayList<>() ;
		for(Seguro seguro : listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				segurosCliente.add(seguro);
			}
		}
		return segurosCliente ;
	}
	
	public ArrayList<Sinistro> getSinistrosPorCliente (Cliente cliente) {
		ArrayList<Sinistro> sinistrosCliente = new ArrayList<>() ;
		for(Seguro seguro : listaSeguros) {
			if (seguro.getCliente().equals(cliente)) {
				ArrayList<Sinistro> listasinistros = seguro.getListaSinistros();
				sinistrosCliente = listasinistros;
				break;
			}
		}
		return sinistrosCliente;
	}
	
	public void listarSeguros() {
		for(Seguro seguro : listaSeguros) {
				System.out.println(seguro);	
		}
	}
	
	
		
	public Boolean visualizarSeguro(String id) {
		int cont = 0;
		for(Cliente client : listaClientes) {
			if (client.getidentificacao().equals(id)) {
				for(Seguro seguro : listaSeguros) {
					if (seguro.getCliente().equals(client)) {
						System.out.println(seguro);
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
	
	public Double contarSeguros(Cliente cliente) {
		double contador = 0;
		for(Seguro seguro : listaSeguros) {
			if(seguro.getCliente().equals(cliente)){
				contador++;
			}
		}
		return contador;
	}
	
	public Boolean removerSeguro(String id) {
		Iterator <Cliente> iterator = listaClientes.iterator();
		Iterator <Seguro> iterator2 = listaSeguros.iterator();
		while (iterator.hasNext()) {
			Cliente procurado = iterator.next();
			if(procurado.getidentificacao().equals(id)) {
				while(iterator2.hasNext()) {
					Seguro procurado2 = iterator2.next();
					if(procurado2.getCliente().equals(procurado)) {
						iterator2.remove();
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public SeguroPF gerarSeguroPF(ClientePF cliente, Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo) {
		SeguroPF seguro = new SeguroPF(cliente, dataInicio, dataFim, seguradora, veiculo);
		return seguro;
	}
	
	public SeguroPJ gerarSeguroPJ(ClientePJ cliente, Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota) {
		SeguroPJ seguro = new SeguroPJ(cliente, dataInicio, dataFim, seguradora, frota);
		return seguro;
	}
	
	public Double calcularPrecoSeguroCliente(Cliente cliente, Seguro seguro) {
		double qtdSeguros = contarSeguros(cliente);
		String tipoCliente = cliente.getidentificacao();
		double preco;
		if(tipoCliente.equals("PF")) {
			preco = qtdSeguros * seguro.calculaValor();
		} else {
			preco = qtdSeguros * seguro.calculaValor();
		}
		
		//Atualizar valorSeguro do cliente
		double valorSeguro = preco * (seguro.calculaValor());
		return valorSeguro;
	}
	
	public Double calcularReceita(Seguradora seguradora, Seguro seg) {
		double receita = 0.0;
		double numero = 0.0;
		for (Cliente cliente : seguradora.listaClientes) {
			numero = calcularPrecoSeguroCliente(cliente, seg);
			listaValorSeguros.add(numero);
			receita += numero;
		}
		return receita;
	}
	
	public void transferencia (ClientePF cliente1, Seguro seg1, ClientePF cliente2, Seguro seg2) {
		double valorSeguro1 = calcularPrecoSeguroCliente(cliente1, seg1);
		double valorSeguro2 = calcularPrecoSeguroCliente(cliente2, seg2);
		System.out.printf("O valor do seguro do " + cliente1.getNome() + ", antes da transferência era" + valorSeguro1);
		System.out.printf("O valor do seguro do " + cliente2.getNome() + ", antes da transferência era" + valorSeguro2);
		for(Veiculo veiculo : cliente1.getListaVeiculos()) {
			cliente2.addVeiculo(veiculo);
			cliente1.removeVeiculo(veiculo);
		}
		System.out.println("Transferência de Seguro realizada com sucesso!");
		double preco1 = calcularPrecoSeguroCliente(cliente1, seg1);
		double preco2 = calcularPrecoSeguroCliente(cliente2, seg2);
		System.out.printf("O valor do seguro do " + cliente1.getNome() + ", depois da transferência é" + preco1);
		System.out.printf("O valor do seguro do " + cliente2.getNome() + ", depois da transferência é" + preco2);
		
	}
	
	public String toString() {
		return "Seguradora " + nome + ", com e-mail " + mail + ", telefone " + phone + 
				", no endereço: " + endereco + ". \n";
	}

}
