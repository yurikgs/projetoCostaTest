package br.com.politelearning.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // Utilizada para informar que uma classe também é uma entidade.
//Assim, a classe será uma entidade e terá uma tabela de mesmo nome no banco de dados.
@Table(name = "tb_tema") // Possui atributos que possibilitam ao desenvolvedor sobrescrever.
public class TemaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo descrição não pode estar vazio e deve ter um mínimo de 5 caracteres e no máximo 1000 caracteres")
	@Size(min = 5, max = 1000) 
	private String descricao;
	
	
	private String imagem;// imagem relacionada ao tema, não obrigatório

	@NotNull (message = "Não pode estar vazio e deve ter um mínimo de 2 caracteres e no máximo 30")
	@Size(min = 2, max = 30)
	private String relacionados;// temas relacionados ao tema em questão postado pelo usuário (Seria o nosso Hashtag)
	
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("tema")
	private List<PostagemModel> postagem;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getRelacionados() {
		return relacionados;
	}

	public void setRelacionados(String relacionados) {
		this.relacionados = relacionados;
	}
	
}
