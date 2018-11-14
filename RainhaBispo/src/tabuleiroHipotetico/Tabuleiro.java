package tabuleiroHipotetico;

import pecas.Peca;
import pecas.Posicao;

public class Tabuleiro {
	private Peca matrizPeca[][] = new Peca[8][8];

	
	public Peca[][] getMatrizPeca() {
		return matrizPeca;
	}

	public void setMatrizPeca(Peca[][] matrizPeca) {
		this.matrizPeca = matrizPeca;
	}

	public Peca getPosicao(Posicao posicao) {
		return null;
	}

}
