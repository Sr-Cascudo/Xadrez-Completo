package pecas;
/**
 * 
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Bispo extends Peca {

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesBispo[][] = new Peca[8][8];
		Bispo Bispo = new Bispo();
		restricoesBispo = tabuleiro.getMatrizPeca();
		
			// antigaPosicao = (ATRIBUIR POSICAO INICIAL DO BISPO)

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

				if (posicao.getLinha() + posicao.getColuna() == linha + coluna
						|| antigaPosicao.getColuna() - antigaPosicao.getLinha() == coluna - linha) {
					// SELECIONA AS DIAGONAIS

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

			}
		}

		if ((antigaPosicao.getLinha() + antigaPosicao.getColuna()) == (posicao.getLinha() + posicao.getColuna())) {
			restricoesBispo[posicao.getLinha()][posicao.getColuna()] = Bispo;
			tabuleiro.setMatrizPeca(restricoesBispo);// ATUALIZA A POSICAO DO BISPO NO TABULEIRO
			antigaPosicao = posicao;
			return true;
			// MOVE O BISPO NA DIAGONAL PRINCIPAL
		}

		if ((antigaPosicao.getColuna() - antigaPosicao.getLinha()) == (posicao.getColuna() - posicao.getLinha())) {
			restricoesBispo[posicao.getLinha()][posicao.getColuna()] = Bispo;
			tabuleiro.setMatrizPeca(restricoesBispo);// ATUALIZA A POSICAO DO BISPO NO TABULEIRO
			antigaPosicao = posicao;
			return true;
			// MOVE O BISPO NA DIAGONAL SECUNDARIA
		}
		return false;
	}
}
