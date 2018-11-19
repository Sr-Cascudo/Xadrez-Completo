package pecas;
/**
 * 
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Torre extends Peca {

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesTorre[][] = new Peca[8][8];
		Torre torre = new Torre();
		restricoesTorre = tabuleiro.getMatrizPeca();
		// antigaPosicao = (ATRIBUIR POSICAO INICIAL DA TORRE)

		if (restricoesTorre[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
			if (torre.isCorPreta() != restricoesTorre[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {
				// SE HOUVER UMA PECA DE COR DIFERENTE DA TORRE O CODIGO CONTINUA A EXECUCAO
				// COM AS PROXIMAS VERIFICACOES
			} else {
				return false;
				// SE A PECA NA NOVA POSICAO FOR DA MESMA COR QUE A RAINHA A JOGADA JÁ É
				// INVALIDADA IMPEDINDO A MOVIMENTACAO DA TORRE
			}
		}

		for (int linha = 0; linha < restricoesTorre.length; linha++) {
			for (int coluna = 0; coluna < restricoesTorre.length; coluna++) {
				// VARREDURA DE TODAS AS POSICOES DA MATRIZ
				if (posicao.getColuna() == antigaPosicao.getColuna()) {
				//SELECIONA A COLUNA DA TORRE

					// HORIZONTAIS
					if (posicao.getColuna() < coluna) {
						if (restricoesTorre[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA HORIZONTAL A ESQUEDA

						}
					}
					if (posicao.getColuna() > coluna) {
						if (restricoesTorre[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA HORIZONTAL A DIREITA
						}
					}
				}

				if (posicao.getLinha() == antigaPosicao.getLinha()) {
				//SELECIONA A LINHA DA TORRE
					
					// VERTICAIS
					if (posicao.getLinha() < linha) {
						if (restricoesTorre[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA VERTICAL INFERIOR
						}
					}

					if (posicao.getLinha() > linha) {
						if (restricoesTorre[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA VERTICAL SUPERIOR
						}
					}
				}
			}

			if (antigaPosicao.getColuna() == posicao.getColuna()) {
				restricoesTorre[posicao.getLinha()][posicao.getColuna()] = torre;
				tabuleiro.setMatrizPeca(restricoesTorre);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
				antigaPosicao = posicao;
				return true;
				// MOVE TORRE NA HORIZONTAL
			}

			if (antigaPosicao.getLinha() == posicao.getLinha()) {
				restricoesTorre[posicao.getLinha()][posicao.getColuna()] = torre;
				tabuleiro.setMatrizPeca(restricoesTorre);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
				antigaPosicao = posicao;
				return true;
				// MOVE TORRE NA VERTICAL
			}
		}
		return false;
	}
}
