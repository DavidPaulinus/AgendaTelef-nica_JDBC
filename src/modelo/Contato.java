package modelo;

public class Contato {

	private String nome;
	private String numero;
	private String tipo;
	private String email;
	private Boolean favorito;

	public Contato(String nome, String numero, String tipo, String email, Boolean favorito) {
		super();
		this.nome = nome;
		this.numero = numero;
		this.tipo = tipo;
		this.email = email;
		this.favorito = favorito;
	}

	public String getNome() {
		return nome;
	}

	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getFavorito() {
		return favorito;
	}

}
