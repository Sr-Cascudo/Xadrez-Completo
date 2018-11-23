package pecas;

import Tabuleiro.Tabuleiro;

/**
 * AUTOR : JOHN HELDER CARDOSO ALVES 
 * DATA : 23/11/2018 
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 */
public class Bispo extends Peca {

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesBispo[][] = new Peca[8][8];
		Bispo Bispo = new Bispo();
		restricoesBispo = Tabuleiro.getMatrizPeca();
		Posicao posicaoAtual = new Posicao(0,0);

		// OS BLOCOS "FOR" A SEGUIR SAO RESPONSAVEIS POR DETERMINAR A POSICAO ATUAL
		// DA RAINHA COM BASE PARA ONDE ELA DESEJA SE MOVER.
		// ESSA ACAO É NECESSARIA POIS É PRECISO DA POSICAO ATUAL DA PECA PARA EXECUTAR
		// AS COMPARACOES AO LONGO DO CODIGO DA PECA;

		// BLOCO EM DESTAQUE EM FUNCAO DA IMPORTANCIA:

//==============================================================================================
		for (int linha = 0; linha < restricoesBispo.length; linha++) {
			for (int coluna = 0; coluna < restricoesBispo.length; coluna++) {
				if (posicao.getLinha() + posicao.getColuna() == linha + coluna
						|| posicao.getColuna() - posicao.getLinha() == coluna - linha || posicao.getColuna() == coluna
						|| posicao.getLinha() == linha) {
					if (restricoesBispo[linha][coluna] instanceof Bispo) {
						posicaoAtual.setLinha(linha);
						posicaoAtual.setColuna(coluna);
						
						//ENCERRA O LOOP QUANDO ACHA POSICAO INICIAL
						linha = 8;
						coluna = 8;
					}	
				}
			}
			if(linha == 7){
				return false;
			}
		}
//==============================================================================================	

		if (restricoesBispo[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
			if (Bispo.isCorPreta() != restricoesBispo[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {
				// SE HOUVER UMA PECA DE COR DIFERENTE DO BISPO O CODIGO CONTINUA A EXECUCAO COM
				// AS PROXIMAS VERIFICACOES
			} else {
				return false;
				// SE A PECA NA NOVA POSICAO FOR DA MESMA COR QUE O BISPO A JOGADA JÁ É
				// INVALIDADA, IMPEDINDO A MOVIMENTACAO DO BISPO
			}
		}

		for (int linha = 0; linha < restricoesBispo.length; linha++) {
			for (int coluna = 0; coluna < restricoesBispo.length; coluna++) {
				// VARREDURA DE TODAS AS POSICOES DA MATRIZ

				if ((posicao.getLinha() + posicao.getColuna() == linha + coluna
						&& posicaoAtual.getLinha() + posicaoAtual.getColuna() == linha + coluna)
						// SELECIONA DIAGONAL PRINCIPAL
						|| (posicao.getColuna() - posicao.getLinha() == coluna - linha
								&& posicaoAtual.getColuna() - posicaoAtual.getLinha() == coluna - linha)) {
					// SELECIONA AS DIAGONAL SECUNDARIA
					if (!(posicaoAtual.getLinha() == linha && posicaoAtual.getColuna() == coluna)) {

						if (posicao.getLinha() < linha) {
							// VERIFICA SE A RAINHA QUER SE MOVER NAS DIAGONAIS INFERIOR

							if (restricoesBispo[linha][coluna] instanceof Peca) {
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A
								// NOVA POSICAO PELAS DIAGONAIS INFERIOR
							}
						}
						if (posicao.getLinha() > linha) {
							// VERIFICA SE A RAINHA QUER SE MOVER NA DIAGONAIS SUPERIOR

							if (restricoesBispo[linha][coluna] instanceof Peca) {
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A
								// NOVA POSICAO PELAS DIAGONAIS SUPERIOR
							}
						}
					}

				}			}
		}

		if ((posicaoAtual.getLinha() + posicaoAtual.getColuna()) == (posicao.getLinha() + posicao.getColuna())) {
			restricoesBispo[posicao.getLinha()][posicao.getColuna()] = Bispo;
			Tabuleiro.setMatrizPeca(restricoesBispo);// ATUALIZA A POSICAO DO BISPO NO TABULEIRO
			posicaoAtual = posicao;
			return true;
			// MOVE O BISPO NA DIAGONAL PRINCIPAL
		}

		if ((posicaoAtual.getColuna() - posicaoAtual.getLinha()) == (posicao.getColuna() - posicao.getLinha())) {
			restricoesBispo[posicao.getLinha()][posicao.getColuna()] = Bispo;
			Tabuleiro.setMatrizPeca(restricoesBispo);// ATUALIZA A POSICAO DO BISPO NO TABULEIRO
			posicaoAtual = posicao;
			return true;
			// MOVE O BISPO NA DIAGONAL SECUNDARIA
		}
		return false;
	}
}
