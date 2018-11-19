package tabuleiro;
/**
 * 
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
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
