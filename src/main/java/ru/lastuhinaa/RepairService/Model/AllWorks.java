package ru.lastuhinaa.RepairService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllWorks {
    @Id
    private Long id;
    private String info;
    private Long cost;
    private Timestamp garanty;
}
