package classes;

import java.util.ArrayList;
import java.util.Date;

public class Condutor {
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNasc;
	private ArrayList<Sinistro> listaSinistros;
	
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = dataNasc;
		this.listaSinistros = new ArrayList<Sinistro>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public ArrayList<Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}

	public String getCpf() {
		return cpf;
	}

	//sem setCpf() por ser do tipo final
	
	public Boolean adicionarSinistro(Sinistro sinistro) {
		listaSinistros.add(sinistro);
		return true;
	}
	
	public Boolean removerSinistro(int id) {
		for (Sinistro sinistro : listaSinistros) {
			if(sinistro.getId() == id) {
				listaSinistros.remove(sinistro);
				return true;
			}
		}
		return false;
	}
	
	public Boolean visualizarSinistro(int id) {
		int cont = 0;
		for(Sinistro sinistro : listaSinistros) {
			int idAtual = sinistro.getId();
			if (idAtual == id) {
				System.out.println(sinistro);
				cont++;
			}
		}
		if (cont > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Condutor [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", email=" + email + ", dataNasc=" + dataNasc + ", listaSinistros=" + listaSinistros + "]";
	}

}