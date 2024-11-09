package org.example.services;

import org.example.datebase.FuncionarioDAO;
import org.example.datebase.FuncionarioVendaDAO;
import org.example.funcionario.Cargo;
import org.example.funcionario.DTO.FuncionarioMaxBenefitsDTO;
import org.example.funcionario.Funcionario;
import org.example.vendas.DTO.FuncionarioMaxSalesDTO;

import java.time.LocalDateTime;
import java.util.List;

public class VendasServices {
    public void savefuncionario(Funcionario funcionario, Double venda, LocalDateTime datavenda) {

        FuncionarioVendaDAO dao = new FuncionarioVendaDAO();
        if (funcionario.getRole() == Cargo.VENDEDOR) {
            dao.save(funcionario, venda, datavenda);

        }
        System.out.println("Só é permitido vendedores");
    }

    public List<FuncionarioMaxSalesDTO> getFuncionarioMaxSales() {
        FuncionarioVendaDAO dao = new FuncionarioVendaDAO();
        return dao.buscarfuncionarioPorMaiorVenda();
    }
}