package com.dinheiro.monitor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/financeiro")
@RequiredArgsConstructor
public class DinheiroController {
    private final DinheiroService dinheiroService;

    @PostMapping("/adicionar")
    public ResponseEntity<DinheiroResponse> criar(@Valid @RequestBody DinheiroRequest dinheiroRequest) {
        return ResponseEntity.ok(dinheiroService.criar(dinheiroRequest));

    }

    @GetMapping("/lista")
    public ResponseEntity<List<DinheiroResponse>> lista() {
        return ResponseEntity.ok(dinheiroService.lista());
    }

    @GetMapping("/{id}/infomation")
    public ResponseEntity<DinheiroResponse> dinheiro(@PathVariable Long id) {
        return ResponseEntity.ok(dinheiroService.dinheiro(id));
    }

    @DeleteMapping("/{id}/deleta")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        dinheiroService.delete(id);
    }
}