package com.dinheiro.monitor;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DinheiroResponse {
    private BigDecimal salario;
    private BigDecimal gasto;
    private BigDecimal minimo;

}
