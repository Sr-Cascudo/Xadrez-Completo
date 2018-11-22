package pecas;

import Tabuleiro.Tabuleiro;

/**
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 21/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Rei extends Peca {

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesRei[][] = new Peca[8][8];
		Rei rei = new Rei();
		restricoesRei = Tabuleiro.getMatrizPeca();

		Posicao posicaoAtual = new Posicao();
		for (int linha = 0; linha < restricoesRei.length; linha++) {
			for (int coluna = 0; coluna < restricoesRei.length; coluna++) {
				if (restricoesRei[linha][coluna] instanceof Rei) {
					if (posicao.getColuna() == coluna + 1
						||posicao.getColuna() == coluna - 1
						|| posicao.getLinha() == linha + 1
						|| posicao.getLinha() == linha - 1) {
						posicaoAtual.setLinha(linha);
						posicaoAtual.setColuna(coluna);	
					}
				}
			}
		}
		
		
		if (restricoesRei[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
			if (rei.isCorPreta() != restricoesRei[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {
				// SE HOUVER UMA PECA DE COR DIFERENTE DO REI O CODIGO CONTINUA A EXECUCAO
				// COM AS PROXIMAS VERIFICACOES
			} else {
				return false;
				// SE A PECA NA NOVA POSICAO FOR DA MESMA COR QUE A DO REI A JOGADA É
				// INVALIDADA IMPEDINDO A MOVIMENTACAO DO REI
			}
		}

		if ((posicao.getLinha() == posicaoAtual.getLinha() + 1 || posicao.getLinha() == posicaoAtual.getLinha() - 1)
				&& (posicao.getColuna() == posicaoAtual.getColuna() + 1
						|| posicao.getColuna() == posicaoAtual.getColuna() - 1)) {
			restricoesRei[posicao.getLinha()][posicao.getColuna()] = rei;
			restricoesRei[posicaoAtual.getLinha()][posicaoAtual.getColuna()] = null;
			Tabuleiro.setMatrizPeca(restricoesRei);
			return true;
			// MOVIMENTA REI NAS DIAGONAIS PRINCIPAL E SECUNDARIA
		}

		if (posicaoAtual.getLinha() == posicao.getLinha() && (posicao.getColuna() == posicaoAtual.getColuna() + 1
				|| posicao.getColuna() == posicaoAtual.getColuna() - 1)) {
			restricoesRei[posicao.getLinha()][posicao.getColuna()] = rei;
			restricoesRei[posicaoAtual.getLinha()][posicaoAtual.getColuna()] = null;
			Tabuleiro.setMatrizPeca(restricoesRei);
			return true;
			// MOVIMENTA REI NA HORIZONTAL
		}

		if (posicaoAtual.getColuna() == posicao.getColuna() && (posicao.getLinha() == posicaoAtual.getLinha() + 1
				|| posicao.getLinha() == posicaoAtual.getLinha() - 1)) {
			restricoesRei[posicao.getLinha()][posicao.getColuna()] = rei;
			restricoesRei[posicaoAtual.getLinha()][posicaoAtual.getColuna()] = null;
			Tabuleiro.setMatrizPeca(restricoesRei);
			return true;
			// MOVIMENTA REI NA VERTICAL
		}
		return false;
	}
}
