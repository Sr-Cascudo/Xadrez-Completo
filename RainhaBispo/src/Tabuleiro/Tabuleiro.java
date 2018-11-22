package Tabuleiro;
/**
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
import pecas.Peca;
import pecas.Posicao;

public class Tabuleiro {
	
	private static Peca matrizPeca[][] = new Peca[8][8];
	
	public static Peca getPosicao(Posicao posicao) {
		return matrizPeca[posicao.getLinha()][posicao.getColuna()];
	}
	public static Peca[][] getMatrizPeca() {
		return matrizPeca;
	}
	public static void setMatrizPeca(Peca[][] matrizPeca) {
		Tabuleiro.matrizPeca = matrizPeca;
	}

}
