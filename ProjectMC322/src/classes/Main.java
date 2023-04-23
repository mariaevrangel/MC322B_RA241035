package classes;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatadata = new SimpleDateFormat("dd/mm/yyyy");
		
		//PESSOA FÍSICA 
		Date dateLicenca = formatadata.parse("11/03/2015");
		Date dateBirth = formatadata.parse("17/06/2023");
		
		ClientePF clientePF1 = new ClientePF("Maria Rangel", "Campinas", dateLicenca, "Ensino Médio", "Feminino", "B", "PF", "385.575.678-39", dateBirth);
		Boolean verificaCPF = clientePF1.validarCPF(clientePF1.getCpf());
		
		ClientePF clientePF2 = new ClientePF("George Cooper", "São Paulo", dateLicenca, "Mestrado", "Masculino", "B", "PF", "124.643.231-68", dateBirth);
		Boolean verificaCPF2 = clientePF2.validarCPF(clientePF2.getCpf());
		
		//PESSOA JURÍDICA
		Date dateFundacao = formatadata.parse("04/06/2023");
		
		ClientePJ clientePJ1 = new ClientePJ ("Google Inc", "California", "PJ", "06.990.590/0001-23", dateFundacao);
		Boolean verificaCNPJ = clientePJ1.validarCNPJ(clientePJ1.getCnpj());
		
		ClientePJ clientePJ2 = new ClientePJ ("Amazon SA", "Boston", "PJ", "65.991.567/0001-59", dateFundacao);
		Boolean verificaCNPJ2 = clientePJ2.validarCNPJ(clientePJ2.getCnpj());
		
		//VEICULO
		Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA", 2017);
		Veiculo veiculo2 = new Veiculo("ABD1024", "BMW", "325", 2018);
		Veiculo veiculo3 = new Veiculo("ABE1025", "Volvo", "XC60", 2019);
		Veiculo veiculo4 = new Veiculo("AVV1026", "Porsche", "911", 2020);
		Veiculo veiculo5 = new Veiculo("AXC1027", "Chevrolet", "Tracker", 2021);
		
		clientePF1.addVeiculo(veiculo1);
		clientePF1.addVeiculo(veiculo2);
		clientePF2.addVeiculo(veiculo3);
		clientePJ1.addVeiculo(veiculo4);
		clientePJ2.addVeiculo(veiculo5);
		
		//SEGURADORA
		Seguradora seguradora1 = new Seguradora("Seguradora ABC", "(11)3644-6441", "segabc@hotmail.com", "Barão Geraldo");
		seguradora1.cadastrarCliente(clientePF1);
		seguradora1.cadastrarCliente(clientePF2);
		seguradora1.cadastrarCliente(clientePJ1);
		seguradora1.cadastrarCliente(clientePJ2);
				
		//SINISTRO
		seguradora1.gerarSinistro("01/01/2023", "Campinas", seguradora1, veiculo1, clientePF1);
		seguradora1.gerarSinistro("03/02/2023", "São Paulo", seguradora1, veiculo2, clientePF1);
		seguradora1.gerarSinistro("07/04/2023", "São Roque", seguradora1, veiculo5, clientePJ2);
		
		//Menu
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Bem-vindo ao menu interativo!\nCaso queira imprimir todos os dados existentes, tecle 1.\n"
				+ "Caso queira listar todos os clientes da Seguradora" + seguradora1.getNome() + ", tecle 2.\n"
				+ "Caso queira visualizar todos sinistros de um cliente na Seguradora" + seguradora1.getNome() + ", tecle 3.\n"
				+ "Caso queira listar todos os sinistros da Seguradora" + seguradora1.getNome() + ", tecle 4.\n"
				+ "Caso queira remover um cliente, tecle 5.\n" 
				+ "Caso queira cadastrar um cliente, tecle 6.\n"
				+ "Caso queira ver todos os requisitos do LAB 3, tecle 7.\n");
		int comando = entrada.nextInt();
		entrada.nextLine();
		if (comando != 1 && comando !=2 && comando != 3 && comando != 4 && comando != 5 && comando != 6 && comando != 7) {
			Boolean input = false;
			while (input == false) {
				System.out.print("Favor teclar um número válido para acessar os menus correspondentes.\n");
				int comando2 = entrada.nextInt();
				entrada.nextLine();
				if (comando2 == 1 || comando2 == 2 || comando == 3 || comando == 4 || comando == 5 || comando == 6 || comando == 7) {
					comando = comando2;
					input = true;
				} else {
					input = false;
				}
			}
		} else if (comando == 1) {
			System.out.println(clientePF1);
			System.out.printf("Seu CPF%s é válido.\n", verificaCPF ? "" : " não");
			System.out.println(clientePF2);
			System.out.printf("Seu CPF%s é válido.\n", verificaCPF2 ? "" : " não");
			System.out.println(clientePJ1);
			System.out.printf("Seu CPNJ%s é válido.\n", verificaCNPJ ? "" : " não");
			System.out.println(clientePJ2);
			System.out.printf("Seu CPNJ%s é válido.\n", verificaCNPJ2 ? "" : " não");
			System.out.println(veiculo1);
			System.out.println(veiculo2);
			System.out.println(veiculo3);
			System.out.println(veiculo4);
			System.out.println(veiculo5);
			System.out.println(seguradora1);
			seguradora1.listarSinistros();
		} else if (comando == 2) {
			System.out.print("Em caso de pessoa física, pressione 1.\nEm caso de pessoa jurídica, pressione 2.\n");
			int comandoCliente = entrada.nextInt();
			entrada.nextLine();
			if (comandoCliente != 1 && comandoCliente !=2) {
				Boolean inputCliente = false;
				while (inputCliente == false) {
					System.out.print("Favor teclar 1 ou 2 para acessar os menus correspondentes.\n");
					int comandoCliente2 = entrada.nextInt();
					entrada.nextLine();
					if (comandoCliente2 == 1 || comandoCliente2 == 2) {
						comandoCliente = comandoCliente2;
						inputCliente = true;
					} else {
						inputCliente = false;
					}
				}
			} else if (comandoCliente == 1) {
				seguradora1.listarClientes("PF");
			} else {
				seguradora1.listarClientes("PJ");
			}
		} else if (comando == 3) {
			System.out.print("Qual o CPF/CNPJ do cliente?\n");
			String id = entrada.nextLine();
			Boolean existe = seguradora1.visualizarSinistro(id);
			if (existe == false) {
				System.out.print("Não há sinistros nesse CPF/CNPJ.\n");
			}
		} else if (comando == 4) {
			seguradora1.listarSinistros();
		} else if (comando == 5) {
			System.out.print("Qual o CPF/CNPJ que busca remover?\n");
			String identificacao = entrada.nextLine();
			Boolean remove = seguradora1.removeCliente(identificacao);
			if (remove == true) {
				System.out.print("Cliente removido.\n");
			} else {
				System.out.print("Cliente não encontrado.\n");
			}
		} else if (comando == 6) {
			System.out.print("Em caso de pessoa física, pressione 1.\nEm caso de pessoa jurídica, pressione 2.\n");
			int comandoCliente = entrada.nextInt();
			entrada.nextLine();
			if (comandoCliente != 1 && comandoCliente !=2) {
				boolean inputCliente = false;
				while (inputCliente == false) {
					System.out.print("Favor teclar 1 ou 2 para acessar os menus correspondentes.\n");
					int comandoCliente2 = entrada.nextInt();
					entrada.nextLine();
					if (comandoCliente2 == 1 || comandoCliente2 == 2) {
						comandoCliente = comandoCliente2;
						inputCliente = true;
					} else {
						inputCliente = false;
					}
				}
			} else if (comandoCliente == 1) {
				//PF
				System.out.printf("Cliente, qual o seu nome?\n");
				String nomePF = entrada.nextLine();
				System.out.printf("Qual a sua data de nascimento? DD/MM/AAAA \n");
				String dataBirth = entrada.nextLine();
				System.out.print("Qual o seu gênero? Preencha F para Feminino, M para Masculino ou U para Não-Binário.\n");
				String genero = entrada.nextLine();
				System.out.print("Qual o seu endereço residencial?\n");
				String enderecoPF = entrada.nextLine();
				System.out.print("Qual o seu CPF?\n");
				String cpf = entrada.nextLine();
				System.out.print("Qual a data de licença do seu documento?\n");
				String dataLicenca = entrada.nextLine();
				System.out.print("Qual a sua classe econômica?\nPara rendas superiores a R$20k, classe A.\nPara rendas entre R$10k a R$20k, classe B.\nPara rendas entre R$5k a R$10k, classe C.\nPara rendas inferiores a R$5k, classe D.\n");
				String classeEcon = entrada.nextLine();
				System.out.print("Qual o seu nível de educação?\n");
				String educacao = entrada.nextLine();
				//Converter String para Date
				Date dateLicenca2 = formatadata.parse(dataLicenca);
				//Converter String para Date
				Date dateBirth2 = formatadata.parse(dataBirth);
				ClientePF clientePF3 = new ClientePF(nomePF, enderecoPF, dateLicenca2, educacao, genero, classeEcon, "PF", cpf, dateBirth2);
				System.out.printf("Bem-vindo %s! Seus dados são:\n", nomePF);
				System.out.println(clientePF3);
			} else if (comandoCliente == 2) {
				//PJ
				System.out.print("Empresa, qual a sua razão social?\n");
				String nomePJ = entrada.nextLine();
				System.out.print("Qual a sua data de fundação? DD/MM/AAAA\n");
				String dataFundacao = entrada.nextLine();
				System.out.print("Qual o seu endereço principal?\n");
				String enderecoPJ = entrada.nextLine();
				System.out.print("Qual o seu CNPJ?\n");
				String cnpj = entrada.nextLine();
				//Converter String para Date
				Date dateFundacao3 = formatadata.parse(dataFundacao);
				ClientePJ clientePJ3 = new ClientePJ(nomePJ, enderecoPJ, "PJ", cnpj, dateFundacao3);
				System.out.printf("Bem-vindo %s! Seus dados são:\n", nomePJ);
				System.out.println(clientePJ3);
			}
		} else {
			System.out.println(clientePF1);
			System.out.printf("Seu CPF%s é válido.\n", verificaCPF ? "" : " não");
			System.out.println(clientePF2);
			System.out.printf("Seu CPF%s é válido.\n", verificaCPF2 ? "" : " não");
			System.out.println(clientePJ1);
			System.out.printf("Seu CPNJ %s é válido.\n", verificaCNPJ ? "" : "não");
			System.out.println(clientePJ2);
			System.out.printf("Seu CPNJ %s é válido.\n", verificaCNPJ2 ? "" : "não");
			
			System.out.println(veiculo1);
			System.out.println(veiculo2);
			System.out.println(veiculo3);
			System.out.println(veiculo4);
			System.out.println(veiculo5);
			
			System.out.println(seguradora1);
			
			seguradora1.listarSinistros();
			
			seguradora1.listarClientes("PF");
			seguradora1.listarClientes("PJ");
			
			System.out.print("Qual o CPF/CNPJ do cliente que quer visualizar o(s) sinistro(s)?\n");
			String id = entrada.nextLine();
			Boolean existe = seguradora1.visualizarSinistro(id);
			if (existe == false) {
				System.out.print("Não há sinistros nesse CPF/CNPJ.\n");
			}
			
			System.out.print("Qual o CPF/CNPJ que busca remover?\n");
			String identificacao = entrada.nextLine();
			Boolean remove = seguradora1.removeCliente(identificacao);
			if (remove == true) {
				System.out.print("Cliente removido.\n");
			} else {
				System.out.print("Cliente não encontrado.\n");
			}
		}
		entrada.close();
	}
}
