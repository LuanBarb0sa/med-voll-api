package med.voll.api.dto;

import med.voll.api.model.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String cpf) {

	public DadosListagemPaciente(Paciente paciente) {
		this(
			 paciente.getId(),	
			 paciente.getNome(),
			 paciente.getEmail(),
			 paciente.getCpf());
	}
	
	/* DTO destinado para trazer apenas os dados necessários da entidade */
}
