package org.example.vendas;

import org.example.funcionario.Funcionario;

import java.time.LocalDateTime;
import java.util.UUID;

public class TabelaDeVendas {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Funcionario vendedor;
    private Double venda;
    private LocalDateTime dataVenda;

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Double getVenda() {
        return venda;
    }

    public void setVenda(Double venda) {
        this.venda = venda;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public TabelaDeVendas(Funcionario vendedor, Double venda, LocalDateTime dataVenda) {
        this.vendedor = vendedor;
        this.venda = venda;
        this.dataVenda = dataVenda;
    }
}
