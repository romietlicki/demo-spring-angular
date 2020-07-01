package com.example.algamoney.api.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

/**
 * @author Rodrigo
 *
 */
@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Optional<Pessoa> pessoaSalva = buscarPessoaPeloCodigo(codigo);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva.get(), "codigo");
		return pessoaRepository.save(pessoaSalva.get());

	}


	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		
		Optional<Pessoa> pessoaSalva = buscarPessoaPeloCodigo(codigo);
			pessoaSalva.get().setAtivo(ativo);
				pessoaRepository.save(pessoaSalva.get());
	}
	
	public Optional<Pessoa> buscarPessoaPeloCodigo(Long codigo) {
		Optional<Pessoa> pessoaSalva = pessoaRepository.findById(codigo);
		
		if (pessoaSalva == null) {
			throw new NoSuchElementException("Not Found");
		}
		return pessoaSalva;
	}
}
