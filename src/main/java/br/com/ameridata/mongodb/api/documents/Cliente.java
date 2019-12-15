package br.com.ameridata.mongodb.api.documents;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {

	@Id
	private String id;

	@Size(min = 2, max = 100, message = "Nome deve conter entre 2 e 100 caracteres")
	private String nome;

	@Size(min = 14, max = 18, message = "Documento deve conter entre 14 e 18 caracteres")
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
