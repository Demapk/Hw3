package ru.kpfu.itis.model;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "calculator", schema = "public", catalog = "postgres")
public class Calculator {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstNumber;

    private String secondNumber;

    private String operation;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "calculator")
    private List<Operation> user;

    public List<Operation> getUser() {
        return user;
    }

    public void setUser(List<Operation> user) {
        this.user = user;
    }

    public Calculator() {
    }

    public Calculator(String firstNumber, String secondNumber, String operation) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
    }

    @Pattern(regexp = "^[-]?\\d+(\\.\\d+)?$", message = "Должно быть числом")
    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Pattern(regexp = "^[-]?\\d+(\\.\\d+)?$", message = "Должно быть числом")
    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "firstNumber='" + firstNumber + '\'' +
                ", secondNumber='" + secondNumber + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    @Pattern(regexp = "[-+%/*]", message = "Должно быть одной из операций: +, -, %, /, *")
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
