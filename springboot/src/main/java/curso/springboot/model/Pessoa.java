package curso.springboot.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.websocket.OnOpen;

import org.springframework.beans.factory.annotation.Autowired;
import antlr.collections.List;

@Entity // Toda Tabela que será criada no banco de dados tem que ser anotada com a anotação @Entity
public class Pessoa implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	@NotNull (message = "Nome não pode ser nulo")
	private String nome;
	
	@NotEmpty(message = "Sobrenome não pode ser vazio")
	@NotNull (message = "Sobrenome não pode ser nulo")
	private String sobrenome;
	
	@Min(value = 18, message = "Idade inválida")
	private int idade;	
	
	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	private java.util.List<Telefone> telefones;
	
	
	
	public java.util.List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(java.util.List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
	
}
