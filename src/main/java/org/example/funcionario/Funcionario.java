package org.example.funcionario;

import java.time.LocalDateTime;
import java.util.UUID;

public class Funcionario {
    private Integer id;
    private String name;
    private Cargo role;
    private Double salary;
    private Integer benefits;
    private LocalDateTime contractor;

    public Funcionario() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cargo getRole() {
        return role;
    }

    public void setRole(Cargo role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getBenefits() {
        return benefits;
    }

    public void setBenefits(Integer benefits) {
        this.benefits = benefits;
    }

    public LocalDateTime getContractor() {
        return contractor;
    }

    public void setContractor(LocalDateTime contractor) {
        this.contractor = contractor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario(String nome, Cargo role, Double salary, Integer benefits, LocalDateTime contractor) {
        this.name = nome;
        this.role = role;
        this.salary = salary;
        this.benefits = benefits;
        this.contractor = contractor;

    }



}
