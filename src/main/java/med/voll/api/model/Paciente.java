package med.voll.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.Data;
import med.voll.api.dto.DadosAtualizacaoPaciente;
import med.voll.api.dto.DadosCadastroPaciente;

@Data
@Table(name = "tb_paciente")
@Entity(name = "Paciente")
public class Paciente {
	
	public Paciente(DadosCadastroPaciente dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
	}
	
	public Paciente() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	
	private Boolean ativo;

	public void atualizarInformacoes(@Valid DadosAtualizacaoPaciente dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;
		this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

	public void desativar() {
		this.ativo = false;
	}
	
}
