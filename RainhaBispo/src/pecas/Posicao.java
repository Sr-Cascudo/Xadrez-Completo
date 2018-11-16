package pecas;

public class Posicao {

	//CLASSE RESPONSAVEL UNICAMENTE PARA ARMAZENAR AS POSICOES LINHA E COLUNA DAS 
	//PECAS NA MATRIZ TABULEIRO
	
	private int linha;
	private int coluna;

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

}
