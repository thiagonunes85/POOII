package br.edu.ifgoias.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.services.AlunoService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> alunos = alunoService.findAll();
		return ResponseEntity.ok().body(alunos);
	}

	@GetMapping(value = "/{idaluno}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer idaluno) {
		Aluno aluno = alunoService.findById(idaluno);
		return ResponseEntity.ok().body(aluno);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno) {
		aluno = alunoService.insert(aluno);
		return ResponseEntity.ok().body(aluno);
	}

	@PutMapping(value = "/{idaluno}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Aluno> update(@PathVariable Integer idaluno, @RequestBody Aluno aluno) {
		aluno = alunoService.update(idaluno, aluno);
		return ResponseEntity.ok().body(aluno);
	}

	@DeleteMapping(value = "/{idaluno}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer idaluno) {
		alunoService.delete(idaluno);
	}
}
