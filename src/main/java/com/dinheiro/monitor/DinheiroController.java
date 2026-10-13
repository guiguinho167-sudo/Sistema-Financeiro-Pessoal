package com.dinheiro.monitor;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/financeiro")
@RequiredArgsConstructor
public class DinheiroController {
    private final DinheiroService dinheiroService;

    @PostMapping("/adicionar")
    public ResponseEntity<DinheiroResponse> criar(@RequestBody DinheiroRequest dinheiroRequest) {
        return ResponseEntity.ok(dinheiroService.criar(dinheiroRequest));

    }

    @GetMapping("/lista")
    public ResponseEntity<List<DinheiroResponse>> lista() {
        return ResponseEntity.ok(dinheiroService.lista());
    }

    @GetMapping("/{ganho}/salario")
    public ResponseEntity<DinheiroResponse> dinheiro(@RequestParam BigDecimal salario) {
        return ResponseEntity.ok(dinheiroService.dinheiro(salario));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        dinheiroService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DinheiroResponse> atualizar(
            @PathVariable Long id,
            @RequestBody DinheiroRequest request) {
        return ResponseEntity.ok(dinheiroService.atualizar(id, request));
    }
}