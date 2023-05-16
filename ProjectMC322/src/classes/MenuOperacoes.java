package classes;

public enum MenuOperacoes {
	CADASTRAR ("Cadastros", new SubMenu[]{
		SubMenu.CADASTRAR_CLIENTE,
		SubMenu.CADASTRAR_VEICULO,
		SubMenu.CADASTRAR_SEGURADORA,
		SubMenu.VOLTAR
	}),
	LISTAR ("Listar", new SubMenu[]{
			SubMenu.LISTAR_CLIENTE,
			SubMenu.LISTAR_SINISTRO_SEG,
			SubMenu.LISTAR_SINISTRO_CLIENTE,
			SubMenu.LISTAR_VEICULO_CLIENTE,
			SubMenu.LISTAR_VEICULO_SEG,
			SubMenu.VOLTAR
	}),
	EXCLUIR ("Excluir", new SubMenu[]{
			SubMenu.EXCLUIR_CLIENTE,
			SubMenu.EXCLUIR_VEICULO,
			SubMenu.EXCLUIR_SINISTRO,
			SubMenu.VOLTAR
	}),
	GERAR_SINISTRO ("Gerar Sinistro", new SubMenu[] {SubMenu.VOLTAR}),
	TRANSFERIR_SEGURO ("Transferir Seguro", new SubMenu[] {SubMenu.VOLTAR}),
	CALCULAR_RECEITA_SEGURADORA ("Calcular Receita Seguradora", new SubMenu[] {SubMenu.VOLTAR}),
	SAIR ("Sair", new SubMenu[]{});
	
	private final String operacao;
	public final SubMenu[] subMenu;
	
	MenuOperacoes (String operacao, SubMenu[] subMenu) {
		this.operacao = operacao;
		this.subMenu = subMenu;
	}
	
	public String getOperacao () {
		return this.operacao;
	}
	
	public SubMenu[] getSubmenu(){
		return subMenu;
	}
}
