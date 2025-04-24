package org.example.services;

import antlr.collections.List;
import org.example.entities.FormaPagamento;
import org.example.repositories.FormaPagamentoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FormaPagamentoService {
    @Autowired
    private FormaPagamentoRepository repository;

    public List<FormaPagamento> getAll() {
        return repository.findAll();
    }
    public FormaPagamento findById(long id) {
        Optional<FormaPagamento> optionalFormaPagamento = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public FormaPagamento insert(FormaPagamento formapagamento) {
        return repository.save(FormaPagamento);
    }

    public boolean update(Long id, FormaPagamento formapagamento) {
        Optional<FormaPagamento> optionalFormaPagamento = repository.findById(id);
        if (optionalFormaPagamento.isPresent()) {
         FormaPagamento formaPagamento = optionalFormaPagamento.get();
         formaPagamento.setFpgDescricao(formaPagamento.getFpgDescricao());
         repository.save(formaPagamento);
         return true;
        }
    }
    return false;
}
public void delete(long id) {
    repository.deleteById(id);
}

