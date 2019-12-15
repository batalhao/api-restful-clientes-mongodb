package br.com.ameridata.mongodb.api.documents;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {

	@Id
	private String id;

	@NotBlank(message = "Nome não informado")
	private String nome;

	@NotBlank(message = "Documento não informado")
	private String documento;

	@NotBlank(message = "Telefone não informado")
	private String telefone;

	@NotBlank(message = "Email não informado")
	@Email(message = "O email informado não é válido")
	private String email;

	public Cliente() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
