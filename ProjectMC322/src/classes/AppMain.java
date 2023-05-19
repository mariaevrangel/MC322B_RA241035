package classes;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppMain {
	public static void exibirMenuExterno() {
		System.out.println("Menu Principal:\n");
		MenuOperacoes menuOpcoes[] = MenuOperacoes.values();
		for (MenuOperacoes mo: menuOpcoes) {
			System.out.print(mo.ordinal() + " - " + mo.getOperacao() +"\n");
		}
	}
	
	public static void exibirSubMenu(MenuOperacoes op) {
		SubMenu[] submenu = op.getSubmenu();
		System.out.println(op.getOperacao() + "\n");
		for (int i = 0; i < submenu.length; i++) {
			System.out.print(i + " - " + submenu[i].getOperacao() +"\n");
		}
	}
	
	public static MenuOperacoes lerOpMenuExterno() {
		int opUsuario;
		Scanner scanner = new Scanner(System.in);
		MenuOperacoes opUsuarioConst;
		do {
			System.out.print("Digite uma opção: ");
			opUsuario = scanner.nextInt();
		} while (opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);
		
		// Passagem do comando desejado
		opUsuarioConst = MenuOperacoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	public static SubMenu lerOpSubMenu(MenuOperacoes op) {
		int opUsuario;
		Scanner scanner = new Scanner(System.in);
		SubMenu opUsuarioConst;
		do {
			System.out.print("Digite uma opção: ");
			opUsuario = scanner.nextInt();
		} while (opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		
		// Passagem do comando desejado
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	public static void executarOpcaoMenuExterno (MenuOperacoes op) throws ParseException {
		//Instanciar
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
		Date dateLicenca = formatadata.parse("11/03/2015");
		Date dateBirth = formatadata.parse("17/06/2023");
		Date dateFundacao = formatadata.parse("04/06/2023");
		ClientePF clientePF1 = new ClientePF("Maria Rangel", "Campinas", dateLicenca, "Ensino Médio", "Feminino", "B", "PF", "385.575.678-39", dateBirth);
		ClientePF clientePF2 = new ClientePF("George Cooper", "São Paulo", dateLicenca, "Mestrado", "Masculino", "B", "PF", "124.643.231-68", dateBirth);
		ClientePJ clientePJ1 = new ClientePJ ("Google Inc", "California", "PJ", "06.990.590/0001-23", dateFundacao, 4);
		ClientePJ clientePJ2 = new ClientePJ ("Amazon SA", "Boston", "PJ", "65.991.567/0001-59", dateFundacao, 23);
		Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA", 2017);
		Veiculo veiculo2 = new Veiculo("ABD1024", "BMW", "325", 2018);
		Veiculo veiculo3 = new Veiculo("ABE1025", "Volvo", "XC60", 2019);
		Veiculo veiculo4 = new Veiculo("AVV1026", "Porsche", "911", 2020);
		Veiculo veiculo5 = new Veiculo("AXC1027", "Chevrolet", "Tracker", 2021);
		Seguradora seguradora1 = new Seguradora("Seguradora ABC", "(11)3644-6441", "segabc@hotmail.com", "Barão Geraldo");
		
		switch(op) {
		case CADASTRAR:
			executarSubmenu(op);
			break;
		case CALCULAR_RECEITA_SEGURADORA:
			seguradora1.cadastrarCliente(clientePF1);
			seguradora1.cadastrarCliente(clientePF2);
			seguradora1.cadastrarCliente(clientePJ1);
			seguradora1.cadastrarCliente(clientePJ2);
			seguradora1.gerarSinistro("01/01/2023", "Campinas", seguradora1, veiculo1, clientePF1);
			seguradora1.gerarSinistro("03/02/2023", "São Paulo", seguradora1, veiculo2, clientePF1);
			seguradora1.gerarSinistro("07/04/2023", "São Roque", seguradora1, veiculo5, clientePJ2);
			double receita = seguradora1.calcularReceita(seguradora1);
			System.out.println("A Receita da " + seguradora1.getNome() + " é de " + receita);
			executarSubmenu(op);
		case EXCLUIR:
			executarSubmenu(op);
			break;
		case GERAR_SINISTRO:
			seguradora1.gerarSinistro("01/01/2023", "Campinas", seguradora1, veiculo1, clientePF1);
			seguradora1.gerarSinistro("03/02/2023", "São Paulo", seguradora1, veiculo2, clientePF1);
			seguradora1.gerarSinistro("07/04/2023", "São Roque", seguradora1, veiculo5, clientePJ2);
			executarSubmenu(op);
			break;
		case LISTAR:
			executarSubmenu(op);
			break;
		case TRANSFERIR_SEGURO:
			seguradora1.transferencia(clientePF2, clientePF1);
			executarSubmenu(op);
			break;
		case SAIR:
			break;
		}
	}
	
	public static void executarOpcaoSubmenu (SubMenu opSubmenu) throws ParseException {
		//Instanciar
				Scanner entrada = new Scanner(System.in);
				SimpleDateFormat formatadata = new SimpleDateFormat("dd/MM/yyyy");
				Date dateLicenca = formatadata.parse("11/03/2015");
				Date dateBirth = formatadata.parse("17/06/2023");
				Date dateFundacao = formatadata.parse("04/06/2023");
				ClientePF clientePF1 = new ClientePF("Maria Rangel", "Campinas", dateLicenca, "Ensino Médio", "Feminino", "B", "PF", "385.575.678-39", dateBirth);
				ClientePF clientePF2 = new ClientePF("George Cooper", "São Paulo", dateLicenca, "Mestrado", "Masculino", "B", "PF", "124.643.231-68", dateBirth);
				ClientePJ clientePJ1 = new ClientePJ ("Google Inc", "California", "PJ", "06.990.590/0001-23", dateFundacao, 4);
				ClientePJ clientePJ2 = new ClientePJ ("Amazon SA", "Boston", "PJ", "65.991.567/0001-59", dateFundacao, 23);
				Veiculo veiculo1 = new Veiculo("ABC1023", "Mercedes", "GLA", 2017);
				Veiculo veiculo2 = new Veiculo("ABD1024", "BMW", "325", 2018);
				Veiculo veiculo3 = new Veiculo("ABE1025", "Volvo", "XC60", 2019);
				Veiculo veiculo4 = new Veiculo("AVV1026", "Porsche", "911", 2020);
				Veiculo veiculo5 = new Veiculo("AXC1027", "Chevrolet", "Tracker", 2021);
				Seguradora seguradora1 = new Seguradora("Seguradora ABC", "(11)3644-6441", "segabc@hotmail.com", "Barão Geraldo");
				
		//Operation
		switch (opSubmenu) {
		case CADASTRAR_CLIENTE:
			boolean verificaNome1 = Validacao.validarNome(clientePF1.getNome());
			System.out.printf("\nO Nome%s de " + clientePF1.getNome() + " é válido.\n", verificaNome1 ? "" : " não");
			boolean verificaCPF1 = Validacao.validarCPF(clientePF1.getCpf());
			System.out.printf("\nO CPF%s de " + clientePF1.getNome() + " é válido.\n", verificaCPF1 ? "" : " não");
			if(verificaNome1 && verificaCPF1) {
				seguradora1.cadastrarCliente(clientePF1);
				System.out.printf("\nCliente " + clientePF1.getNome() + " cadastrado com sucesso!");
			}
			
			
			boolean verificaNome2 = Validacao.validarNome(clientePF2.getNome());
			System.out.printf("\nO Nome%s de " + clientePF2.getNome() + " é válido.\n", verificaNome2 ? "" : " não");
			boolean verificaCPF2 = Validacao.validarCPF(clientePF2.getCpf());
			System.out.printf("\nO CPF%s de " + clientePF2.getNome() + " é válido.\n", verificaCPF2 ? "" : " não");
			if(verificaNome2 && verificaCPF2) {
				seguradora1.cadastrarCliente(clientePF2);
				System.out.printf("\nCliente " + clientePF2.getNome() + " cadastrado com sucesso!");
			}
			
			boolean verificaNome3 = Validacao.validarNome(clientePJ1.getNome());
			System.out.printf("\nO Nome%s de " + clientePJ1.getNome() + " é válido.\n", verificaNome3 ? "" : " não");
			boolean verificaCNPJ1 = Validacao.validarCNPJ(clientePJ1.getCnpj());
			System.out.printf("\nO CPNJ%s de " + clientePJ1 + " é válido.\n", verificaCNPJ1 ? "" : " não");
			if(verificaNome3 && verificaCNPJ1) {
				seguradora1.cadastrarCliente(clientePJ1);
				System.out.printf("\nCliente " + clientePJ1.getNome() + " cadastrado com sucesso!");
			}
		
			boolean verificaNome4 = Validacao.validarNome(clientePJ2.getNome());
			System.out.printf("\nO Nome%s de " + clientePJ2.getNome() + " é válido.\n", verificaNome4 ? "" : " não");
			boolean verificaCNPJ2 = Validacao.validarCNPJ(clientePJ2.getCnpj());
			System.out.printf("\nO CPNJ%s de " + clientePJ2 + " é válido.\n", verificaCNPJ2 ? "" : " não");
			if(verificaNome4 && verificaCNPJ2) {
				seguradora1.cadastrarCliente(clientePJ2);
				System.out.printf("\nCliente " + clientePJ2.getNome() + " cadastrado com sucesso!");
			}
			break;
		case CADASTRAR_VEICULO:
			clientePF1.addVeiculo(veiculo1);
			clientePF1.addVeiculo(veiculo2);
			clientePF2.addVeiculo(veiculo3);
			clientePJ1.addVeiculo(veiculo4);
			clientePJ2.addVeiculo(veiculo5);
			System.out.printf("Veiculos cadastrados com sucesso!");
			break;
		case CADASTRAR_SEGURADORA:
			System.out.print("Qual a sua razão social?\\n");
			String nomeSeguradora = entrada.nextLine();
			System.out.print("Qual o seu endereço principal?\\n");
			String enderecoSeg = entrada.nextLine();
			System.out.print("Qual o seu telefone principal? (XX)XXXX-XXXX\\n");
			String telSeg = entrada.nextLine();
			System.out.print("Qual o seu e-mail principal?\\n");
			String mailSeg = entrada.nextLine();
			Seguradora seguradora2 = new Seguradora(nomeSeguradora, telSeg, mailSeg, enderecoSeg);
			//Print
			System.out.println(seguradora2);
			break;
		case LISTAR_CLIENTE:
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
				System.out.print("Os clientes (Pessoa Física) da " + seguradora1.getNome() + " são:\n");
				seguradora1.listarClientes("PF");
			} else {
				System.out.print("Os clientes (Pessoa Jurídica) da " + seguradora1.getNome() + " são:\n");
				seguradora1.listarClientes("PJ");
			}
			break;
		case LISTAR_SINISTRO_SEG:
			seguradora1.listarSinistros();
			break;
		case LISTAR_SINISTRO_CLIENTE:
			System.out.print("Qual o CPF/CNPJ do cliente que quer visualizar o(s) sinistro(s)?\n");
			String id = entrada.nextLine();
			Boolean existe = seguradora1.visualizarSinistro(id);
			if (existe == false) {
				System.out.print("Não há sinistros nesse CPF/CNPJ.\n");
			}
			break;
		case LISTAR_VEICULO_CLIENTE:
			System.out.print("Qual o CPF/CNPJ do cliente que quer visualizar o(s) carro(s)?\n");
			String id_car = entrada.nextLine();
			for (Cliente cliente : seguradora1.getListaClientes()) {
				if (cliente.getidentificacao().equals(id_car)) {
					for(Veiculo veiculo : cliente.getListaVeiculos()) {
						System.out.println(veiculo);
					}
				}
			}
			break;
		case LISTAR_VEICULO_SEG:
			for (Cliente cliente : seguradora1.getListaClientes()) {
				for(Veiculo veiculo : cliente.getListaVeiculos()) {
						System.out.println(veiculo);
				}
			}
			break;
		case EXCLUIR_CLIENTE:
			System.out.print("Qual o CPF/CNPJ que busca remover?\n");
			String identificacao = entrada.nextLine();
			Boolean remove = seguradora1.removerCliente(identificacao);
			if (remove == true) {
				System.out.print("Cliente removido.\n");
			} else {
				System.out.print("Cliente não encontrado.\n");
			}
			break;
		case EXCLUIR_VEICULO:
			System.out.print("Qual o seu CPF/CNPJ?\n");
			String id_dono = entrada.nextLine();
			System.out.print("Qual a placa do veículo que quer remover?\n");
			String placa = entrada.nextLine();
			for (Cliente cliente : seguradora1.getListaClientes()) {
				if (cliente.getidentificacao().equals(id_dono)) {
					for(Veiculo veiculo : cliente.getListaVeiculos()) {
						if(veiculo.getPlaca().equals(placa)){
							cliente.removeVeiculo(veiculo);
							break;
						}
					}
				}
			}
			break;
		case EXCLUIR_SINISTRO:
			System.out.print("Qual o CPF/CNPJ registrado no sinistro que deseja remover?\n");
			String identificacao2 = entrada.nextLine();
			Boolean remover = seguradora1.removerSinistro(identificacao2);
			if (remover == true) {
				System.out.print("Sinistro removido.\n");
			} else {
				System.out.print("Sinistro não encontrado.\n");
			}
			break;
		case VOLTAR:
			break;
		}
		
	}

	public static void executarSubmenu(MenuOperacoes op) throws ParseException {
		SubMenu opSub;
		do {
			exibirSubMenu(op);
			opSub = lerOpSubMenu(op);
			executarOpcaoSubmenu(opSub);
		} while(opSub != SubMenu.VOLTAR);
	}
	
	public static void main(String[] args) throws ParseException {
		MenuOperacoes op;
		do {
			exibirMenuExterno();
			op = lerOpMenuExterno();
			executarOpcaoMenuExterno(op);
		} while (op != MenuOperacoes.SAIR);
		System.out.println("Saiu do sistema.\n");
	}
}
