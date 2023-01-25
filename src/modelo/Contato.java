package modelo;

public class Contato {

	private String nome;
	private String telefone;
	private String tipo;
	private String email;
	private Boolean favorito;

	public Contato(String nome, String telefone, String tipo, String email, Boolean favorito) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.tipo = tipo;
		this.email = email;
		this.favorito = favorito;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

}
