package pecas;
/**
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Cavalo extends Peca {

	@Override
	public boolean mover(Posicao posicao) {		
		Peca restricoesCavalo[][] = new Peca[8][8];
		Cavalo cavalo = new Cavalo();
		restricoesCavalo = tabuleiro.getMatrizPeca();
		// antigaPosicao = (POSICAO INICIAL DO CAVALO)
		
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
		
		if (antigaPosicao.getLinha() < posicao.getLinha()
				// CAVALO SE MOVENTO PARA A PARTE INFERIOR DA MATRIZ
				|| antigaPosicao.getLinha() > posicao.getLinha()) {
				// CAVALO SE MOVENDO PARA A PARTE SUPERIOR DA MATRIZ

			if (posicao.getLinha() - antigaPosicao.getLinha() == 2
				//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL INFERIOR
					|| antigaPosicao.getLinha() - posicao.getLinha() == 2) {
					//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO VERTICAL SUPERIOR
				
				if (posicao.getColuna() == antigaPosicao.getColuna() - 1
						//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO HORIZONTAL A ESQUERDA
						|| posicao.getColuna() == antigaPosicao.getColuna() + 1 ) {
						//GARANTE QUE O CAVALO NÃO SE MOVA ALÉM DO PERMITIDO NO SENTIDO HORIZONTAL A DIREITA
					restricoesCavalo[posicao.getLinha()][posicao.getColuna()] = cavalo;
					tabuleiro.setMatrizPeca(restricoesCavalo);
					antigaPosicao = posicao;
					return true;
				}
			}
		}
		return false;
		//SE NENHUM DOS "IF" ACIMA FOREM ATENDIDOS SIGNIFICA
		//QUE O CAVALO ESTA TENTANDO UM MOVIMENTO INVALIDO
	}
}
