package br.edu.ifgoias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Aluno insert(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno update(Integer id, Aluno aluno) {
		
		Aluno alunoDB = findById(id);
		
		alunoDB.setNome(aluno.getNome());
		
		alunoDB.setMatricula(aluno.getMatricula());
		
		// Atualize outros campos conforme necessário
		return alunoRepository.save(alunoDB);
	}

	public void delete(Integer id) {
		Aluno aluno = findById(id);
		alunoRepository.delete(aluno);
	}
}
