package org.example.services;

import org.example.datebase.FuncionarioDAO;
import org.example.funcionario.DTO.*;
import org.example.funcionario.Funcionario;

import java.util.List;

public class FuncionarioService {

    public void savefuncionario(Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.save(funcionario.getName(), funcionario.getRole(), funcionario.getSalary(), funcionario.getBenefits(), funcionario.getContractor());
    }

    public List <FuncionarioBenefitsSalaryDTO> getFuncionarioBenefitsSalary() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.buscaTodosFuncionarioPorSalarioeBeneficio();
    }

    public  List <FuncionarioSalariesDTO> getFuncionarioSalaries() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.buscaTodosFuncionarioPorSalario();
    }

    public List <FuncionarioBenefitsDTO> getFuncionarioBenefits() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.buscaFuncionarioPorBeneficio();
    }

    public List <FuncionarioMaxSalary> getFuncionarioMaxSalary() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.buscaFuncionarioPorMaiorSalario();
    }

    public List <FuncionarioMaxBenefitsDTO> getFuncionarioMaxBenefits() {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.buscarfuncionarioPorMaiorBeneficio();
    }

    public Funcionario getFuncionarioByName(String name) {
        FuncionarioDAO dao = new FuncionarioDAO();
        return dao.buscaFuncionarioPorNome(name);

    }



}
