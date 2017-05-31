package ru.kpfu.itis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "operation", schema = "public", catalog = "postgres")
public class Operation {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "calculator_id")

    private Calculator calculator;
}
