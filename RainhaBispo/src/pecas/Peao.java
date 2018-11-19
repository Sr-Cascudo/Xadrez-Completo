package pecas;
/**
 * 
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
public class Peao extends Peca {

	@Override
	public boolean mover(Posicao posicao) {
		Peca restricoesPeao[][] = new Peca[8][8];
		Peao peao = new Peao();
		restricoesPeao = tabuleiro.getMatrizPeca();
		// antigaPosicao = (ATRIBUIR POSICAO INICIAL DA PEAO)

		if (peao.isNuncaMovimentado()) {
			//SE O PEAO NUNCA TIVER SIDO MOVIMENTADO ELE ATENDE A ESSAS CONDICIONAIS
			if (antigaPosicao.getColuna() == posicao.getColuna() && (posicao.getLinha() == antigaPosicao.getLinha() + 1
					|| posicao.getLinha() == antigaPosicao.getLinha() + 2)) {
				//GARANTE AS REGRAS DE PRIMEIRO MOVIMENTO DO PEAO
				//PODENDO ELE SE MOVER ATÉ DUAS POSICOES NO PRIMEIRO MOVIMENTO
				if (restricoesPeao[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
					return false;
					//SE HOUVER UMA PECA NA FRENTE DO PEAO, ELE NAO PODE CAPTURA-LA
				}
				restricoesPeao[posicao.getLinha()][posicao.getColuna()] = peao;
				tabuleiro.setMatrizPeca(restricoesPeao);
				antigaPosicao = posicao;
				return true;
			}
		}
		
		if (antigaPosicao.getColuna() == posicao.getColuna() && posicao.getLinha() == antigaPosicao.getLinha() + 1) {
			//GARANTE QUE O PEAO VAI SE MOVER NA MESMA COLUNA E APENAS UMA LINHA ACIMA
			if (restricoesPeao[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
				return false;
				//SE HOUVER UMA PECA NA FRENTE DO PEAO, ELE NAO PODE CAPTURA-LA
			}
			restricoesPeao[posicao.getLinha()][posicao.getColuna()] = peao;
			tabuleiro.setMatrizPeca(restricoesPeao);
			antigaPosicao = posicao;
			return true;
		}

		if (antigaPosicao.getColuna() != posicao.getColuna()) {
			if (restricoesPeao[posicao.getLinha()][posicao.getColuna()] instanceof Peca) {
				//VERIFICA SE A POSICAO PARA ONDE O PEAO DESEJA SER MOVIDO HA UMA PECA
				if (peao.isCorPreta() != restricoesPeao[posicao.getLinha()][posicao.getColuna()].isCorPreta()) {
					//VERIFICA SE PECA NA POSICAO É ADVERSARIA
					if (posicao.getLinha() == antigaPosicao.getLinha() + 1
							&& (posicao.getColuna() == antigaPosicao.getColuna() + 1
									|| posicao.getColuna() == antigaPosicao.getColuna() - 1)) {
						//GARANTE QUE O PEÃO SÓ VAI CAPTURAR A PECA SE ESSA ESTIVER
						//A UM ALCANCE VALIDO DO PEAO
						restricoesPeao[posicao.getLinha()][posicao.getColuna()] = peao;
						tabuleiro.setMatrizPeca(restricoesPeao);
						antigaPosicao = posicao;
						return true;
					}
				}
			}
		}

		return false;
	}

}
