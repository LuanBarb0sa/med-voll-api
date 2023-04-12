package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.DadosAtualizacaoPaciente;
import med.voll.api.dto.DadosCadastroPaciente;
import med.voll.api.dto.DadosListagemPaciente;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {

		repository.save(new Paciente(dados));

	}
	
	@GetMapping
	public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemPaciente::new);
	}
	
	@PutMapping
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizarInformacoes(dados);
	}
	
}
