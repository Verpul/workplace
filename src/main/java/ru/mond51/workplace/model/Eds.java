package ru.mond51.workplace.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Eds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Назначение обязательно к заполнению")
    private String purpose;

    @NotBlank(message = "Владелец обязателен к заполнению")
    private String owner;

    @NotNull(message = "Начало действия обязательно к заполнению")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;

    @NotNull(message = "Окончание действия обязательно к заполнению")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @NotBlank(message = "Изготовитель обязателен к заполнению")
    private String creator;

    private String comment;
    private boolean active = true;

}
