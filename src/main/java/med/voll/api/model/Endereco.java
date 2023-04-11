package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import med.voll.api.dto.DadosEndereco;

@Embeddable
@Data
public class Endereco {

	public Endereco(DadosEndereco endereco) {
		this.logradouro = endereco.logradouro();
		this.bairro = endereco.bairro();
		this.cep = endereco.cep();
		this.numero = endereco.numero();
		this.complemento = endereco.complemento();
		this.cidade = endereco.cidade();
		this.uf = endereco.uf();
	}

	public Endereco() {
	}

	private String logradouro;

	private String bairro;

	private String cep;

	private String numero;

	private String complemento;

	private String cidade;

	private String uf;

}
