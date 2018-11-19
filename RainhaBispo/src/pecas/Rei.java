package pecas;
/**
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Rei extends Peca {

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesRei[][] = new Peca[8][8];
		Rei rei = new Rei();
		restricoesRei = tabuleiro.getMatrizPeca();
		// antigaPosicao = (POSICA INICIAL DO REI)

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

		if ((posicao.getLinha() == antigaPosicao.getLinha() + 1 || posicao.getLinha() == antigaPosicao.getLinha() - 1)
				&& (posicao.getColuna() == antigaPosicao.getColuna() + 1
						|| posicao.getColuna() == antigaPosicao.getColuna() - 1)) {
			restricoesRei[posicao.getLinha()][posicao.getColuna()] = rei;
			tabuleiro.setMatrizPeca(restricoesRei);
			antigaPosicao = posicao;
			return true;
			// MOVIMENTA REI NAS DIAGONAIS PRINCIPAL E SECUNDARIA
		}

		if (antigaPosicao.getLinha() == posicao.getLinha() && (posicao.getColuna() == antigaPosicao.getColuna() + 1
				|| posicao.getColuna() == antigaPosicao.getColuna() - 1)) {
			restricoesRei[posicao.getLinha()][posicao.getColuna()] = rei;
			tabuleiro.setMatrizPeca(restricoesRei);
			antigaPosicao = posicao;
			return true;
			// MOVIMENTA REI NA HORIZONTAL
		}

		if (antigaPosicao.getColuna() == posicao.getColuna() && (posicao.getLinha() == antigaPosicao.getLinha() + 1
				|| posicao.getLinha() == antigaPosicao.getLinha() - 1)) {
			restricoesRei[posicao.getLinha()][posicao.getColuna()] = rei;
			tabuleiro.setMatrizPeca(restricoesRei);
			antigaPosicao = posicao;
			return true;
			// MOVIMENTA REI NA VERTICAL
		}
		return false;
	}
}
