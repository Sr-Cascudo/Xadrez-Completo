package pecas;

import tabuleiroHipotetico.Tabuleiro;

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
