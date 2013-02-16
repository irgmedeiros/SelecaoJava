package Repositorio;
import Negocios.Funcionario;

public class RepositorioFuncionarioArray {

	private int quantidade;
	private int posGravar;
	private Funcionario[] funcionarioArray;

	public RepositorioFuncionarioArray(int quantidade) {
		this.quantidade = quantidade;
		
		funcionarioArray = new Funcionario[this.quantidade];
		this.posGravar = 0;
	}
	
	public void inserir(Funcionario funcionario) throws FuncionarioArrayOverflow
	{// TODO: testar duplicado?
		int posicao = getPosGravar();
		if (posicao >= 0 && posicao <= this.quantidade -1) {
			
			funcionarioArray[posicao] = funcionario;
			setPosGravar(posicao + 1);
		}
		else{
			throw (new FuncionarioArrayOverflow());
		}
		
	}
	
	public Funcionario procurar (String cpf){
		Funcionario funcionario = null;
		
		for (int i = 0; i < this.posGravar; i++){ //posGravar para n�o verificar elemento vazio no array
			if ((funcionarioArray[i].getCpf()).equals(cpf)){
				funcionario = funcionarioArray[i];
				break;
			}
		}
		return funcionario;
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioInexistente{// assumindo que a interface nao passe funcionario = null
		String cpf = funcionario.getCpf();
		if (existe(cpf)) {
			Funcionario funcionarioAntigo = procurar(cpf);
			funcionarioAntigo.setNome(funcionario.getNome());
		}
		else{
			throw (new FuncionarioInexistente());
		}
		
	}
	
	public boolean existe(String cpf){
		boolean existe = false;
		Funcionario func = procurar(cpf);
		if (func != null)
			existe = true;
		return existe;
	}
	
	public void remover(String cpf) throws FuncionarioInexistente{
		// Manter integridade da estrutura de dados
		// Reordenar Array
		if(existe(cpf)){
			for (int i = 0; i < this.posGravar; i++){ // usa posGravar para n�o verificar elemento vazio no array
				if ((funcionarioArray[i].getCpf()).equals(cpf)){
					// O ultimo elemento nao nulo (posicao - 1) passa a ocupar o lugar do funcionario atual
					// posGravar � decrementado em uma posi��o
					int indexUltimo = posGravar - 1;
					if (indexUltimo >= 0){
						// Caso de mais de um elemento no Array
						funcionarioArray[i] = funcionarioArray[indexUltimo];
						funcionarioArray[indexUltimo] = null;
					}
					else{
						// Caso de apenas um elemento no Array
						// Removemos o primeiro elemento
						funcionarioArray[i] = null;
					}
					// Decrementa ponteiro
					posGravar = indexUltimo;
					break;
				}
			}
		}
		else{
			throw (new FuncionarioInexistente());
		}
		
	}

	public int getPosGravar() {
		return posGravar;
	}

	public void setPosGravar(int posGravar) {
		this.posGravar = posGravar;
	}
	
}

class FuncionarioArrayOverflow extends Exception{
	public FuncionarioArrayOverflow()
	{
		super();
	}
	
	public FuncionarioArrayOverflow(String s)
	{
		super(s);
	}
}

class FuncionarioInexistente extends Exception{
	public FuncionarioInexistente()
	{
		super();
	}
	
	public FuncionarioInexistente(String s)
	{
		super(s);
	}
}
