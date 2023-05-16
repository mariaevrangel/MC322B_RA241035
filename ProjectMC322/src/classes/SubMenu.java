package classes;

public enum SubMenu {
	CADASTRAR_CLIENTE ("Novo Cliente"),
	CADASTRAR_VEICULO ("Novo Veículo"),
	CADASTRAR_SEGURADORA ("Nova Seguradora"),
	LISTAR_CLIENTE ("Listar Cliente por Seguradora"),
	LISTAR_SINISTRO_SEG ("Listar Sinistros por Seguradora"),
	LISTAR_SINISTRO_CLIENTE ("Listar Sinistros por Cliente"),
	LISTAR_VEICULO_CLIENTE ("Listar Veículos por Cliente"),
	LISTAR_VEICULO_SEG ("Listar Veículos por Seguradora"),
	EXCLUIR_CLIENTE ("Excluir Cliente"),
	EXCLUIR_VEICULO ("Excluir Veiculo"),
	EXCLUIR_SINISTRO ("Excluir Sinistro"),
	VOLTAR ("Voltar");
	
	private final String operacao;
	
	SubMenu (String operacao) {
		this.operacao = operacao;
	}
	
	public String getOperacao () {
		return this.operacao;
	}
}