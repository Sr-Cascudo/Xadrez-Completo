package pecas;
/**
 * AUTOR : JOHN HELDER CARDOSO ALVES
 * DATA : 15/11/2018
 * INSTITUICAO : UNIVERSIDADE ESTADUAL DO TOCANTINS
 * */
import tabuleiro.Tabuleiro;

public abstract class Peca {

	private boolean corPreta;
	private boolean nuncaMovimentado;
	private String urlImagem;
	protected Posicao antigaPosicao;
	Tabuleiro tabuleiro = new Tabuleiro();
	
	public boolean isCorPreta() {
		return corPreta;
	}

	public void setCorPreta(boolean corPreta) {
		this.corPreta = corPreta;
	}

	public boolean isNuncaMovimentado() {
		return nuncaMovimentado;
	}

	public void setNuncaMovimentado(boolean nuncaMovimentado) {
		this.nuncaMovimentado = nuncaMovimentado;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public boolean mover(Posicao posicao) {

		return true;
	}

}
