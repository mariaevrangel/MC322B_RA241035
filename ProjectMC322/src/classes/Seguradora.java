package classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String phone;
	private String mail;
	private String endereco;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Cliente> listaClientes;
	private Double valorSeguro;
	
	public Seguradora(String cnpj, String nome, String phone, String mail, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.phone = phone;
		this.mail = mail;
		this.endereco = endereco;
		this.listaSeguros = new ArrayList<Seguro>();
		this.listaClientes = new ArrayList<Cliente>();
		this.valorSeguro = 0.0;
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
	
	public double calculaScore(ClientePF cliente) {
		double score;
		double quantidadeCarros = contarVeiculos(cliente);
		score = CalcSeguro.VALOR_BASE.getOperacao() * quantidadeCarros;
		return score;
	}
	
	public double calculaScore(ClientePF cliente) {
		double score, fator;
		double idade = cliente.calculaIdade(cliente.getdataNascimento());
		if (idade <= 30.0) {
			fator = CalcSeguro.FATOR_18_30.getOperacao();
		} else if (idade > 30.0 && idade <= 60.0) {
			fator = CalcSeguro.FATOR_30_60.getOperacao();
		} else if (idade > 60.0 && idade <= 90.0) {
			fator = CalcSeguro.FATOR_60_90.getOperacao();
		} else {
			fator = 0;
		}
		score = fator;
		return score;
	}
	
	public double calculaScore(ClientePJ cliente) {
		double score;
		double funcionarios = cliente.getQtdDeFuncionarios();
		score = super.calculaScore(cliente) * (1 + (funcionarios/100));
		return score;
	}
	
	public Double calcularPrecoSeguroCliente(Cliente cliente) {
		double qtdSeguros = contarSeguros(cliente);
		String tipoCliente = cliente.getidentificacao();
		double preco;
		if(tipoCliente.equals("PF")) {
			preco = qtdSeguros * cliente.calculaScore(cliente);
		} else {
			preco = qtdSeguros * cliente.calculaScore(cliente);
		}
		
		//Atualizar valorSeguro do cliente
		cliente.setValorSeguro(preco * (cliente.calculaScore(cliente)));
		
		return preco;
	}
	
	public Double calcularReceita(Seguradora seguradora) {
		double receita = 0.0;
		double numero = 0.0;
		for (Cliente cliente : seguradora.listaClientes) {
			numero = calcularPrecoSeguroCliente(cliente);
			receita += numero;
		}
		return receita;
	}
	
	public void transferencia (Cliente cliente1, Cliente cliente2) {
		System.out.printf("O valor do seguro do " + cliente1.getNome() + ", antes da transferência era" + cliente1.getValorSeguro());
		System.out.printf("O valor do seguro do " + cliente2.getNome() + ", antes da transferência era" + cliente2.getValorSeguro());
		for(Veiculo veiculo : cliente1.getListaVeiculos()) {
			cliente2.addVeiculo(veiculo);
			cliente1.removeVeiculo(veiculo);
		}
		System.out.println("Transferência de Seguro realizada com sucesso!");
		double preco1 = calcularPrecoSeguroCliente(cliente1);
		double preco2 = calcularPrecoSeguroCliente(cliente2);
		System.out.printf("O valor do seguro do " + cliente1.getNome() + ", depois da transferência é" + preco1);
		System.out.printf("O valor do seguro do " + cliente2.getNome() + ", depois da transferência é" + preco2);
		
	}
	
	public String toString() {
		return "Seguradora " + nome + ", com e-mail " + mail + ", telefone " + phone + 
				", no endereço: " + endereco + ". \n";
	}

}
