package ru.lastuhinaa.RepairService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data // Из ломбока, добавляет все Геттеры и Сеттеры
@AllArgsConstructor // Конструктор по умолчанию со всеми параметрами
@NoArgsConstructor // Конструктор по умолчанию без пармаметров
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Для увелечения автоматического айди на 1
    @EqualsAndHashCode.Include
    private Integer orderId;

    private String customerProblem;

    private String realProblem;

    private String status;

    private java.util.Date dateAcceptance;

    private java.util.Date dateFinish;

    private Double cost;
}
