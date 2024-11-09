package org.example.datebase;

import org.example.funcionario.Cargo;
import org.example.funcionario.DTO.*;
import org.example.funcionario.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public class FuncionarioDAO {
    public void save(String nome, Cargo role, Double salary, Integer benefits, LocalDateTime contractor) {
        String sql = "insert into funcionario(name, role, salary, benefits, contractor) values (?, ?, ?, ?, ?)";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, role.toString());
            ;
            preparedStatement.setDouble(3, salary);
            preparedStatement.setInt(4, benefits);
            preparedStatement.setObject(5, contractor);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionario Salvo com sucesso!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("nao foi possivel salvar");
        }
    }

    public List<FuncionarioBenefitsSalaryDTO> buscaTodosFuncionarioPorSalarioeBeneficio() {
        List<FuncionarioBenefitsSalaryDTO> funcionarios = new ArrayList<>();
        String sql = "select salary, benefits from funcionario";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet r = preparedStatement.executeQuery()) {
            while (r.next()) {
                Integer benefits = r.getInt("benefits");
                Double salary = r.getDouble("salary");
                funcionarios.add(new FuncionarioBenefitsSalaryDTO(benefits, salary));
            }

        } catch (SQLException e) {
            System.out.println("nao foi possivel buscar todos os funcionarios");
            throw new RuntimeException(e);

        }
        return funcionarios;
    }

    public List<FuncionarioSalariesDTO> buscaTodosFuncionarioPorSalario() {
        List<FuncionarioSalariesDTO> funcionarios = new ArrayList<>();
        String sql = "select salary from funcionario";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet r = preparedStatement.executeQuery()) {
            while (r.next()) {
                Double salary = r.getDouble("salary");
                funcionarios.add(new FuncionarioSalariesDTO(salary));
            }
        } catch (SQLException e) {
            System.out.println("nao foi possivel buscar todos os salarios dos funcionarios");
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    public List <FuncionarioBenefitsDTO> buscaFuncionarioPorBeneficio() {
        List<FuncionarioBenefitsDTO> funcionarios = new ArrayList<>();
        String sql = "select benefits from funcionario";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet r = preparedStatement.executeQuery()){
        while (r.next()) {
            Integer benefits = r.getInt("benefits");
            funcionarios.add(new FuncionarioBenefitsDTO(benefits));
        }


        } catch (SQLException e) {
            System.out.println("nao foi possivel buscar todos os beneficios dos funcionarios");
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    public List <FuncionarioMaxSalary> buscaFuncionarioPorMaiorSalario() {
        List<FuncionarioMaxSalary> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario WHERE salary = (SELECT MAX(salary) FROM funcionario)";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet r = preparedStatement.executeQuery()) {
            while (r.next()) {
                Double salary = r.getDouble("salary");
                String nome = r.getString("name");
                funcionarios.add(new FuncionarioMaxSalary(nome, salary));
            }
        } catch(SQLException e){
            System.out.println("nao foi possivel buscar todos os beneficios dos funcionarios");
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    public List <FuncionarioMaxBenefitsDTO> buscarfuncionarioPorMaiorBeneficio(){
        List<FuncionarioMaxBenefitsDTO> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario WHERE benefits = (SELECT MAX(benefits) FROM funcionario)";

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet r = preparedStatement.executeQuery()) {
            while (r.next()) {
                Integer benefits = r.getInt("benefits");
                String nome = r.getString("name");
                funcionarios.add(new FuncionarioMaxBenefitsDTO(nome, benefits));
            }
        } catch(SQLException e){
            System.out.println("nao foi possivel buscar o maior beneficio dos funcionarios");
            throw new RuntimeException(e);
        }
        return funcionarios;

    }

    public Funcionario buscaFuncionarioPorNome(String nome) {
        String sql = "select * from funcionario where name like ?";

        Funcionario f1 = null;

        try (Connection connection = DateBase.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            try (ResultSet r = preparedStatement.executeQuery()) {
                if (r.next()) {
                    f1 = new Funcionario();
                    f1.setId(r.getInt("funcionario_id"));
                    f1.setName(r.getString("name"));
                    f1.setSalary(r.getDouble("salary"));
                    f1.setBenefits(r.getInt("benefits"));
                    Date date = r.getTimestamp("contractor");
                    LocalDateTime contractorDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    f1.setContractor(contractorDate);
                }
            }

        } catch (SQLException e) {
            System.out.println("nao foi possivel buscar pelo nome do funcionario ");
            throw new RuntimeException(e);
        }
        return f1;
    }

}
