package com.dinheiro.monitor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dinheiro.monitor.Erros.UsuarioException;
import com.dinheiro.monitor.Erros.UsuarioException.BuscasException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DinheiroService {
    private final DinheiroRepository repository;

    @Transactional
    public DinheiroResponse criar(DinheiroRequest dinheiroRequest) {
        BigDecimal salario = dinheiroRequest.getSalario();
        BigDecimal gasto = dinheiroRequest.getGasto();
        BigDecimal minimo = dinheiroRequest.getMinimo();

        BigDecimal resultado = salario.subtract(gasto);
        if (resultado.compareTo(minimo) < 0) {
            throw new UsuarioException("O saldo restante ficou abaixo do mínimo permitido");
        }

        DinheiroDado salva = new DinheiroDado();
        salva.setSalario(resultado);
        salva.setGasto(dinheiroRequest.getGasto());
        salva.setMinimo(dinheiroRequest.getMinimo());

        DinheiroDado salvo = repository.save(salva);
        return new DinheiroResponse(salvo.getSalario(), salvo.getGasto(), salvo.getMinimo());

    }

    public List<DinheiroResponse> lista() {
        return repository.findAll()
                .stream()
                .map(salvo -> new DinheiroResponse(salvo.getSalario(), salvo.getGasto(), salvo.getMinimo()))
                .toList();

    }

    public DinheiroResponse dinheiro(Long id) {
        DinheiroDado salvo = repository.findById(id)
                .orElseThrow(() -> new BuscasException("Informação não encontrada"));

        return new DinheiroResponse(salvo.getSalario(), salvo.getGasto(), salvo.getMinimo());
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new BuscasException("Informação não encontrada");
        }
        repository.deleteById(id);
    }

}
