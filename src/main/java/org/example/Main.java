package org.example;

import org.example.funcionario.Cargo;
import org.example.funcionario.Funcionario;
import org.example.services.FuncionarioService;
import org.example.services.VendasServices;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        FuncionarioService f1 = new FuncionarioService();
        LocalDateTime localDateTime = LocalDateTime.now();
//        f1.savefuncionario(new Funcionario("Jorge Carvalho", Cargo.SECRETARIO, 7000.00, 20, localDateTime.withYear(2018).withMonth(1)));
//        f1.savefuncionario(new Funcionario("Maria Souza", Cargo.SECRETARIO, 7000.00, 20, localDateTime.withYear(2015).withMonth(12)));
//        f1.savefuncionario(new Funcionario("Ana Silva", Cargo.VENDEDOR, 12000.00, 30, localDateTime.withYear(2021).withMonth(12)));
//        f1.savefuncionario(new Funcionario("Joao Mendes", Cargo.VENDEDOR, 12000.00, 30, localDateTime.withYear(2021).withMonth(12)));
//        f1.savefuncionario(new Funcionario("Juliana Alves", Cargo.GERENTE, 20000.00, 0, localDateTime.withYear(2017).withMonth(7)));
//        f1.savefuncionario(new Funcionario("Bento Albino", Cargo.GERENTE, 20000.00, 0, localDateTime.withYear(2014).withMonth(3)));


        VendasServices v1 = new VendasServices();
//        Funcionario fbyname = f1.getFuncionarioByName("Ana Silva");
//        v1.savefuncionario(fbyname, 5200.00, localDateTime.withYear(2021).withMonth(12));
//        v1.savefuncionario(fbyname, 4000.00, localDateTime.withYear(2022).withMonth(1));
//        v1.savefuncionario(fbyname, 4200.00, localDateTime.withYear(2022).withMonth(2));
//        v1.savefuncionario(fbyname, 5850.00, localDateTime.withYear(2022).withMonth(3));
//        v1.savefuncionario(fbyname, 5900.00, localDateTime.withYear(2022).withMonth(4));
//
//        Funcionario fbyname2 = f1.getFuncionarioByName("Joao Mendes");
//        v1.savefuncionario(fbyname2, 3400.00, localDateTime.withYear(2021).withMonth(12));
//        v1.savefuncionario(fbyname2, 7700.00, localDateTime.withYear(2022).withMonth(1));
//        v1.savefuncionario(fbyname2, 5000.00, localDateTime.withYear(2021).withMonth(2));
//        v1.savefuncionario(fbyname2, 5900.00, localDateTime.withYear(2021).withMonth(3));
//        v1.savefuncionario(fbyname2, 6500.00, localDateTime.withYear(2021).withMonth(4));


        System.out.println(v1.getFuncionarioMaxSales());
        System.out.println(f1.getFuncionarioMaxBenefits());
        System.out.println(f1.getFuncionarioMaxSalary());
        System.out.println(f1.getFuncionarioBenefitsSalary());
        System.out.println(f1.getFuncionarioSalaries());
        System.out.println(f1.getFuncionarioBenefits());


    }

}