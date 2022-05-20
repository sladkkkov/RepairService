package ru.lastuhinaa.RepairService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Details {
    @Id
    private Long id;
    private String name;
    private String maker;
    private String model;
    private String compatModel; //совместимые модели
    private Integer cost;
    private Integer available; //количество шт в наличие
}
