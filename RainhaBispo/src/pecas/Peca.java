package pecas;
import Tabuleiro.Tabuleiro;

public abstract class Peca {

	private Posicao posicao;
	private boolean corPreta;
	private boolean nuncaMovimentado;
	private String urlImagem;
	
	public Peca() {
		
	}

	public Peca(Posicao posicao, boolean corPreta) {
		super();
		this.posicao = posicao;
		this.corPreta = corPreta;
		this.nuncaMovimentado = true;
		this.urlImagem = null;
	}

	public abstract boolean mover(Posicao posicao);

	public boolean isCorPreta() {
		return true;
	}

	public Posicao getPosicao() {
		
		return this.posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public void setCorPreta(boolean valor) {
		this.corPreta = valor;
	}

	public boolean isNuncaMovimentada() {
		return true;
	}

	public void setNuncaMovimentado(boolean valor) {
		this.nuncaMovimentado = valor;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

}
