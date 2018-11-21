package pecas;
/**
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
		restricoesRainha[0][3] = rainha;
		Posicao posicaoAtual = new Posicao();
		
		//OS BLOCOS "FOR" A SEGUIR SAO RESPONSAVEIS POR DETERMINAR A POSICAO ATUAL
		//DA RAINHA COM BASE PARA ONDE ELA DESEJA SE MOVER.
		//ESSA ACAO É NECESSARIA POIS É PRECISO DA POSICAO ATUAL DA PECA PARA EXECUTAR 
		//AS COMPARACOES AO LONGO DO CODIGO DA PECA;
		
		//BLOCO EM DESTAQUE EM FUNCAO DA IMPORTANCIA:
		
//==============================================================================================
		for (int linha = 0; linha < restricoesRainha.length; linha++) {
			for (int coluna = 0; coluna < restricoesRainha.length; coluna++) {
				if (posicao.getLinha() + posicao.getColuna() == linha + coluna
						|| posicao.getColuna() - posicao.getLinha() == coluna - linha
						|| posicao.getColuna() == coluna
						|| posicao.getLinha() == linha) {
					if (restricoesRainha[linha][coluna] instanceof Rainha) {
						posicaoAtual.setLinha(linha);
						posicaoAtual.setColuna(coluna);
					}
				}
			}
		}
//==============================================================================================		
		
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
				
				if ((posicao.getLinha() + posicao.getColuna() == linha + coluna
						&& posicaoAtual.getLinha() + posicaoAtual.getColuna() == linha + coluna)
					//SELECIONA DIAGONAL PRINCIPAL
						|| (posicao.getColuna() - posicao.getLinha() == coluna - linha
						&& posicaoAtual.getColuna() - posicaoAtual.getLinha() == coluna - linha)) {
						//SELECIONA AS DIAGONAL SECUNDARIA

					if (!(posicaoAtual.getLinha() == linha && posicaoAtual.getColuna() == coluna)) {
						//EVITA QUE VERIFIQUE SE A ESTANCIA DE PECA NA POSICAO DA PROPRIA PECA
						
						if (posicao.getLinha() < posicaoAtual.getLinha()) {
							// VERIFICA SE A RAINHA QUER SE MOVER NAS DIAGONAIS INFERIOR

							if (restricoesRainha[linha][coluna] instanceof Peca) {
								return false;									  
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A
								// NOVA POSICAO PELAS DIAGONAIS INFERIOR
							}
						}
						if (posicao.getLinha() > posicaoAtual.getLinha()) {
							// VERIFICA SE A RAINHA QUER SE MOVER NA DIAGONAIS SUPERIOR
							
							if (restricoesRainha[linha][coluna] instanceof Peca) {																				
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A
								// NOVA POSICAO PELAS DIAGONAIS SUPERIOR		
							}
						}
					}

					if (posicao.getColuna() == posicaoAtual.getColuna() && posicaoAtual.getColuna() == coluna) {
					//SELECIONA COLUNA DA RAINHA
						
						// HORIZONTAIS
						if (posicao.getColuna() < posicaoAtual.getColuna()) {
							if (restricoesRainha[linha][coluna] instanceof Peca) {
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
								// POSICAO PELA HORIZONTAL A ESQUEDA

							}
						}
						if (posicao.getColuna() > posicaoAtual.getColuna()) {
							if (restricoesRainha[linha][coluna] instanceof Peca) {
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
								// POSICAO PELA HORIZONTAL A DIREITA
							}
						}
						
					}

					if (posicao.getLinha() == posicaoAtual.getLinha() && posicaoAtual.getLinha() == linha) {
					//SELECIONA LINHA DA RAINHA
						
						// VERTICAIS
						if (posicao.getLinha() < posicaoAtual.getLinha()) {
							if (restricoesRainha[linha][coluna] instanceof Peca) {
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
								// POSICAO PELA VERTICAL INFERIOR
							}
						}

						if (posicao.getLinha() > posicaoAtual.getLinha()) {
							if (restricoesRainha[linha][coluna] instanceof Peca) {
								return false;
								// VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA
								// POSICAO PELA VERTICAL SUPERIOR
							}
						}
					}	
				}
			}
		}
		
		if ((posicaoAtual.getLinha() + posicaoAtual.getColuna()) == (posicao.getLinha() + posicao.getColuna())) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			posicaoAtual = posicao;
			return true;
			// MOVE A RAINHA NA DIAGONAL PRINCIPAL
		}

		if ((posicaoAtual.getColuna() - posicaoAtual.getLinha()) == (posicao.getColuna() - posicao.getLinha())) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			posicaoAtual = posicao;
			return true;
			// MOVE A RAINHA NA DIAGONAL SECUNDARIA
		}

		if (posicaoAtual.getColuna() == posicao.getColuna()) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			posicaoAtual = posicao;
			return true;
			// MOVE RAINHA NA HORIZONTAL
		}

		if (posicaoAtual.getLinha() == posicao.getLinha()) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);// ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			posicaoAtual = posicao;
			return true;
			// MOVE RAINHA NA VERTICAL
		}

		return false;
	}
}
