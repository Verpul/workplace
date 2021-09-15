package ru.mond51.workplace.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Eds {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String purpose;
    private String owner;
    private Date beginDate;
    private Date expirationDate;
    private String comment;
    private boolean active = true;

}
