package org.example.datebase;

import org.example.funcionario.Cargo;
import org.example.funcionario.DTO.FuncionarioMaxBenefitsDTO;
import org.example.funcionario.Funcionario;
import org.example.vendas.DTO.FuncionarioMaxSalesDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioVendaDAO {

    public void save(Funcionario vendedor, Double venda, LocalDateTime datavenda) {
        String sql = "insert into vendas (vendedor, venda, datavenda, funcionario_id) values (?, ?, ?,?)";
        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, vendedor.getName());
            preparedStatement.setDouble(2, venda);
            preparedStatement.setObject(3, datavenda);
            preparedStatement.setInt(4, vendedor.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionario Salvo com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FuncionarioMaxSalesDTO> buscarfuncionarioPorMaiorVenda() {
        List<FuncionarioMaxSalesDTO> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM vendas WHERE venda = (SELECT MAX(venda) FROM vendas)";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet r = preparedStatement.executeQuery()) {
            while (r.next()) {
                Double venda = r.getDouble("venda");
                String nome = r.getString("vendedor");
                funcionarios.add(new FuncionarioMaxSalesDTO(nome, venda));
            }
        } catch (SQLException e) {
            System.out.println("nao foi possivel buscar todas as vendas dos funcionarios");
            throw new RuntimeException(e);
        }
        return funcionarios;
    }
}