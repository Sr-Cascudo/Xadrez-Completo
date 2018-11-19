package pecas;
/**
 * 
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Rainha extends Peca {
	
	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesRainha[][] = new Peca[8][8];
		Rainha rainha = new Rainha();
		restricoesRainha = tabuleiro.getMatrizPeca();
		// antigaPosicao = (ATRIBUIR POSICAO INICIAL DA RAINHA)

		if (restricoesRainha[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
			if (rainha.isCorPreta() != restricoesRainha[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {
				// SE HOUVER UMA PECA DE COR DIFERENTE DA RAINHA O CODIGO CONTINUA A EXECUCAO
				// COM AS PROXIMAS VERIFICACOES
			} 
			else {
				return false;
				// SE A PECA NA NOVA POSICAO FOR DA MESMA COR QUE A RAINHA A JOGADA JÁ É
				// INVALIDADA IMPEDINDO A MOVIMENTACAO DA RAINHA
			}
		}

		for (int linha = 0; linha < restricoesRainha.length; linha++) { 	   
			for (int coluna = 0; coluna < restricoesRainha.length; coluna++) { 
				// VARREDURA DE TODAS AS POSICOES DA MATRIZ

				if (posicao.getLinha() + posicao.getColuna() == linha + coluna
						|| antigaPosicao.getColuna() - antigaPosicao.getLinha() == coluna - linha) {
					// SELECIONA AS DIAGONAIS

					if (posicao.getLinha() < linha) {
						// VERIFICA SE A RAINHA QUER SE MOVER NAS DIAGONAIS INFERIOR

						if (restricoesRainha[linha][coluna] instanceof Peca) {
							return false;									  
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A
							// NOVA POSICAO PELAS DIAGONAIS INFERIOR
						}
					}
					if (posicao.getLinha() > linha) {
						// VERIFICA SE A RAINHA QUER SE MOVER NA DIAGONAIS SUPERIOR
						
						if (restricoesRainha[linha][coluna] instanceof Peca) {																				
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A
							// NOVA POSICAO PELAS DIAGONAIS SUPERIOR		
						}
					}
				}

				if (posicao.getColuna() == antigaPosicao.getColuna()) {
				//SELECIONA COLUNA DA RAINHA
					
					// HORIZONTAIS
					if (posicao.getColuna() < coluna) {
						if (restricoesRainha[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA HORIZONTAL A ESQUEDA

						}
					}
					if (posicao.getColuna() > coluna) {
						if (restricoesRainha[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA HORIZONTAL A DIREITA
						}
					}
					
				}

				if (posicao.getLinha() == antigaPosicao.getLinha()) {
				//SELECIONA LINHA DA RAINHA
					
					// VERTICAIS
					if (posicao.getLinha() < linha) {
						if (restricoesRainha[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA VERTICAL INFERIOR
						}
					}

					if (posicao.getLinha() > linha) {
						if (restricoesRainha[linha][coluna] instanceof Peca) {
							return false;
							// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
							// POSICAO PELA VERTICAL SUPERIOR
						}
					}	
				}
			}
		}

		if ((antigaPosicao.getLinha() + antigaPosicao.getColuna()) == (posicao.getLinha() + posicao.getColuna())) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			antigaPosicao = posicao;
			return true;
			// MOVE A RAINHA NA DIAGONAL PRINCIPAL
		}

		if ((antigaPosicao.getColuna() - antigaPosicao.getLinha()) == (posicao.getColuna() - posicao.getLinha())) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			antigaPosicao = posicao;
			return true;
			// MOVE A RAINHA NA DIAGONAL SECUNDARIA
		}

		if (antigaPosicao.getColuna() == posicao.getColuna()) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			antigaPosicao = posicao;
			return true;
			// MOVE RAINHA NA HORIZONTAL
		}

		if (antigaPosicao.getLinha() == posicao.getLinha()) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			antigaPosicao = posicao;
			return true;
			// MOVE RAINHA NA VERTICAL
		}

		return false;
	}
}
