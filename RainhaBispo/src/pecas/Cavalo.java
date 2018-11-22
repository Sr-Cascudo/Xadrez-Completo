package pecas;

import Tabuleiro.Tabuleiro;

/**
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 21/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Cavalo extends Peca {
	@Override
	public boolean mover(Posicao posicao) {		
		Peca restricoesCavalo[][] = new Peca[8][8];
		Cavalo cavalo = new Cavalo();
		restricoesCavalo = Tabuleiro.getMatrizPeca();
		Posicao posicaoAtual = new Posicao();
		
		//OS BLOCOS "FOR" A SEGUIR SAO RESPONSAVEIS POR DETERMINAR A POSICAO ATUAL
		//DA RAINHA COM BASE PARA ONDE ELA DESEJA SE MOVER.
		//ESSA ACAO É NECESSARIA POIS É PRECISO DA POSICAO ATUAL DA PECA PARA EXECUTAR 
		//AS COMPARACOES AO LONGO DO CODIGO DA PECA;
		
		//BLOCO EM DESTAQUE EM FUNCAO DA IMPORTANCIA:
		
//==============================================================================================
		
		for (int linha = 0; linha < restricoesCavalo.length; linha++) {
			for (int coluna = 0; coluna < restricoesCavalo.length; coluna++) {
				if ((posicao.getColuna() == coluna + 1
					|| posicao.getColuna() == coluna - 1)
						&& (posicao.getLinha() == linha + 2 
							||posicao.getLinha() == linha - 2)) {
					if (restricoesCavalo[linha][coluna] instanceof Cavalo) {
						posicaoAtual.setLinha(linha);
						posicaoAtual.setColuna(coluna);
					}
				}
			}
		}
//==============================================================================================		
		
		if (restricoesCavalo[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
			if (cavalo.isCorPreta() != restricoesCavalo[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {
				// SE HOUVER UMA PECA DE COR DIFERENTE DO CAVALO O CODIGO CONTINUA A EXECUCAO
				// COM AS PROXIMAS VERIFICACOES
			} 
			else {
				return false;
				// SE A PECA NA NOVA POSICAO FOR DA MESMA COR QUE A RAINHA A JOGADA JÁ É
				// INVALIDADA IMPEDINDO A MOVIMENTACAO DA RAINHA
			}
		}
		
		if (posicaoAtual.getLinha() < posicao.getLinha()
				// CAVALO SE MOVENTO PARA A PARTE INFERIOR DA MATRIZ
				|| posicaoAtual.getLinha() > posicao.getLinha()) {
				// CAVALO SE MOVENDO PARA A PARTE SUPERIOR DA MATRIZ

			if (posicao.getLinha() - posicaoAtual.getLinha() == 2
				//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL INFERIOR
					|| posicaoAtual.getLinha() - posicao.getLinha() == 2) {
					//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL SUPERIOR
				
				if (posicao.getColuna() == posicaoAtual.getColuna() - 1
						//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL A ESQUERDA
						|| posicao.getColuna() == posicaoAtual.getColuna() + 1 ) {
						//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL A DIREITA
					restricoesCavalo[posicao.getLinha()][posicao.getColuna()] = cavalo;
					Tabuleiro.setMatrizPeca(restricoesCavalo);
					restricoesCavalo[posicaoAtual.getLinha()][posicaoAtual.getColuna()] = null;
					return true;
				}
			}
		}
		
		if (posicaoAtual.getColuna() < posicao.getColuna()
				// CAVALO SE MOVENTO PARA A DIREITA DA MATRIZ
				|| posicaoAtual.getColuna() > posicao.getColuna()) {
				// CAVALO SE MOVENDO PARA A ESQUERDA DA MATRIZ

			if (posicao.getColuna() - posicaoAtual.getColuna() == 2
				//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL INFERIOR
					|| posicaoAtual.getColuna() - posicao.getColuna() == 2) {
					//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL SUPERIOR
				
				if (posicao.getLinha() == posicaoAtual.getLinha() - 1
						//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO HORIZONTAL A ESQUERDA
						|| posicao.getLinha() == posicaoAtual.getLinha() + 1 ) {
						//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO HORIZONTAL A DIREITA
					restricoesCavalo[posicao.getLinha()][posicao.getColuna()] = cavalo;
					restricoesCavalo[posicaoAtual.getLinha()][posicaoAtual.getColuna()] = null;
					Tabuleiro.setMatrizPeca(restricoesCavalo);
					return true;
				}
			}
		}
		return false;
		//SE NENHUM DOS "IF" ACIMA FOREM ATENDIDOS SIGNIFICA
		//QUE O CAVALO ESTA TENTANDO UM MOVIMENTO INVALIDO
	}
}
