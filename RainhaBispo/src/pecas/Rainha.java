package pecas;

public class Rainha extends Peca {
	static private Posicao antigaPosicao = null;

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesRainha[][] = new Peca[8][8];
		Rainha rainha = new Rainha();
		restricoesRainha = tabuleiro.getMatrizPeca();

		if (isNuncaMovimentado()) {
			// antigaPosicao = (ATRIBUIR POSICAO INICIAL DA RAINHA)
		} 
		else {
			antigaPosicao = posicao;
		}

		if (restricoesRainha[posicao.getLinha()][posicao.getColuna()] instanceof Peca								//=======================================//
				&& rainha.isCorPreta() != restricoesRainha[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {	//=======================================//
		}																											//=ESSE BLOCO É RESPONSAVEL POR GARANTIR=//
		else {																										//=SE HA UMA PECA ADVERSARIA NA POSICAO =//
			return false;																							//=======================================//
		}																											//=======================================//
		
		for (int linha = 0; linha < restricoesRainha.length; linha++) {			//VARREDURA DE TODAS
			for (int coluna = 0; coluna < restricoesRainha.length; coluna++) {	//AS POSICOES DA MATRIZ
				
				if (posicao.getLinha() + posicao.getColuna() == linha + coluna
						|| antigaPosicao.getColuna() - antigaPosicao.getLinha() == coluna - linha) {//SELECIONA AS DIAGONAIS  
					
					if (posicao.getLinha() < linha) {//VERIFICA SE A RAINHA QUER SE MOVER NAS DIAGONAIS INFERIOR

						if (restricoesRainha[linha][coluna] instanceof Peca) {//VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA POSICAO PELAS DIAGONAIS INFERIOR
							return false;
						}	
					}
					if (posicao.getLinha() > linha) {//VERIFICA SE A RAINHA QUER SE MOVER NA DIAGONAIS SUPERIOR
		
						if (restricoesRainha[linha][coluna] instanceof Peca) {//VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA POSICAO PELAS DIAGONAIS SUPERIOR
							return false;
						}
					}
				}
			
				//HORIZONTAIS
				if (posicao.getColuna() < coluna) {
					if (restricoesRainha[linha][coluna] instanceof Peca) {//VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA POSICAO PELA HORIZONTAL A ESQUEDA
						return false;
					}	
				}
				if (posicao.getColuna() > coluna) {
					if (restricoesRainha[linha][coluna] instanceof Peca) {//VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA POSICAO PELA HORIZONTAL A DIREITA
						return false;
					}	
				}
				
				//VERTICAIS
				if (posicao.getLinha() < linha) {
					if (restricoesRainha[linha][coluna] instanceof Peca) {//VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA POSICAO PELA VERTICAL INFERIOR;
						return false;
					}
				}
				
				if (posicao.getLinha() > linha) {
					if (restricoesRainha[linha][coluna] instanceof Peca) {//VERIFICA SE UMA PECA NO CAMINHO ATÉ A NOVA POSICAO PELA VERTICAL SUPERIOR;
						return false;
					}
				}
			}
		}
		
		
		
		if ((antigaPosicao.getLinha() + antigaPosicao.getColuna()) == (posicao.getLinha() + posicao.getColuna())) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);//ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			return true;
			// MOVE A RAINHA NA DIAGONAL PRINCIPAL
		}

		if ((antigaPosicao.getColuna() - antigaPosicao.getLinha()) == (posicao.getColuna() - posicao.getLinha())) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);//ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			return true;
			// MOVE A RAINHA NA DIAGONAL SECUNDARIA
		}

		if (antigaPosicao.getColuna() == posicao.getColuna()) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);//ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			return true;
			// MOVE RAINHA NA HORIZONTAL
		}

		if (antigaPosicao.getLinha() == posicao.getLinha()) {
			restricoesRainha[posicao.getLinha()][posicao.getColuna()] = rainha;
			tabuleiro.setMatrizPeca(restricoesRainha);//ATUALIZA A POSICAO DA RAINHA NO TABULEIRO
			return true;
			// MOVE RAINHA NA VERTICAL
		}

		return false;
	}
}
