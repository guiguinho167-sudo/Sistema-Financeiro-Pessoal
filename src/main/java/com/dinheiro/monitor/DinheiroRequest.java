package com.dinheiro.monitor;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DinheiroRequest {
    @NotNull(message = "Seu salario não pode ser sem valor")
    private BigDecimal salario;
    @NotNull(message = "Seu gasto não pode ser sem valor")
    private BigDecimal gasto;
    @NotNull(message = "Sem você não tiver digite 0")
    private BigDecimal minimo;

}
