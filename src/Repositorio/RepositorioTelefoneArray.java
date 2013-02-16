package Repositorio;
import java.util.ArrayList;
import java.util.List;

import Negocios.Telefone;


public class RepositorioTelefoneArray {

	private int quantidade;
	private int posGravar;
	private Telefone[] telefoneArray;

	public RepositorioTelefoneArray(int quantidade) {
		this.quantidade = quantidade;
		
		telefoneArray = new Telefone[this.quantidade];
		this.posGravar = 0;
		
	}
	
	public void inserir(Telefone telefone) throws TelefoneArrayOverFlow
	{
		int posicao = getPosGravar();
		if (posicao >= 0 && posicao <= this.quantidade -1) {
			
			telefoneArray[posicao] = telefone;
			
			setPosGravar(posicao + 1);
		}
		else{
			throw (new TelefoneArrayOverFlow());
		}
		
	}
	
	public Telefone procurar (String codigo){
		Telefone telefone = null;
		
		for (int i = 0; i < this.posGravar; i++){ //posGravar para n�o verificar elemento vazio no array
			if (telefoneArray[i].getCodigo().equals(codigo)){
				telefone = telefoneArray[i];
				break;
			}
		}
		return telefone;
	}
	
	public void atualizar(Telefone telefone) throws TelefoneInexistente{// assumindo que a interface nao passe telefone = null
		String codigo = telefone.getCodigo();
		if (existe(codigo)) {
			Telefone telefoneAntigo = procurar(codigo);
			telefoneAntigo.setDescricao(telefone.getDescricao());
		}
		else{
			throw (new TelefoneInexistente());
		}
		
	}
	
	public boolean existe(String codigo){
		boolean existe = false;
		Telefone telefone = procurar(codigo);
		if (telefone != null)
			existe = true;
		
		return existe;
	}
	
	public void remover(String codigo) throws TelefoneInexistente{
		// manter integridade
		// reordenar array
		if(existe(codigo)){
			for (int i = 0; i < this.posGravar; i++){ //posGravar para n�o verificar elemento vazio no array
				if (telefoneArray[i].getCodigo().equals(codigo)){
					// o ultimo elemento nao nulo (posicao - 1) passa a ocupar o lugar do telefone atual
					// posGravar � decrementado em uma posi��o
					int indexUltimo = posGravar - 1;
					if (indexUltimo >= 0){
						telefoneArray[i] = telefoneArray[indexUltimo];
						telefoneArray[indexUltimo] = null;
					}
					else{ // removemos o primeiro elemento
						telefoneArray[i] = null;
					}
					// Decrementa ponteiro
					posGravar = indexUltimo;
					break;
				}
			}
		}
		else{
			throw (new TelefoneInexistente());
		}
		
	}
	public Telefone[] listarTelefones(int idFuncionario){
		Telefone[] telefones;
		List<Telefone> listaTelefones = new ArrayList<Telefone>();    
		
		for (int i = 0; i < this.posGravar; i++){ //posGravar para n�o verificar elemento vazio no array
			if (telefoneArray[i].getIdFuncionario() == idFuncionario){
				listaTelefones.add(telefoneArray[i]);
			}
		}
		telefones = listaTelefones.toArray(new Telefone[listaTelefones.size()]);
		return telefones;
	}

	public int getPosGravar() {
		return posGravar;
	}

	public void setPosGravar(int posGravar) {
		this.posGravar = posGravar;
	}
	
}

class TelefoneArrayOverFlow extends Exception{
	public TelefoneArrayOverFlow()
	{
		super();
	}
	
	public TelefoneArrayOverFlow(String s)
	{
		super(s);
	}
}

class TelefoneInexistente extends Exception{
	public TelefoneInexistente()
	{
		super();
	}
	
	public TelefoneInexistente(String s)
	{
		super(s);
	}
}
