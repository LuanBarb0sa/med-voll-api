package med.voll.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id,
		String nome,
		@Pattern(regexp = "\\d{8,11}")
		String telefone,
		DadosEndereco endereco) {
}
