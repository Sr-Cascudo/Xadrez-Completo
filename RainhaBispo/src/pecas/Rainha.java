package pecas;

import tabuleiroHipotetico.Tabuleiro;

public class Rainha extends Peca {
	static Posicao antigaPosicao = null;
	
	
	@Override
	public boolean mover(Posicao posicao) {
		if (isNuncaMovimentado()) {
			//antigaPosicao = (ATRIBUIR POSICAO INICIAL DA RAINHA)
		}
		else {
			antigaPosicao = posicao;
		}

		if ((antigaPosicao.getLinha() + antigaPosicao.getColuna()) == (posicao.getLinha() + posicao.getColuna()) ) {
			return true;
			//MOVE A RAINHA NA DIAGONAL PRINCIPAL
		}
		
		if ((antigaPosicao.getColuna() - antigaPosicao.getLinha()) == (posicao.getColuna() - posicao.getLinha())) {
			return true;
			//MOVE A RAINHA NA DIAGONAL SECUNDARIA
		}
		
		if (antigaPosicao.getColuna() == posicao.getColuna()) {
			return true;
			//MOVE RAINHA NA HORIZONTAL
		}
		
		if (antigaPosicao.getLinha() == antigaPosicao.getLinha()) {
			return true;
			//MOVE RAINHA NA VERTICAL
		}
		return false;
	}
}
