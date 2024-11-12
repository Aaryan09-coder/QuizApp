package com.aaryan.Quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
//Data is a lombok annotation used to implement getter, setters and toString
//model ie. it represents the table in the database
//we need to match the variable name used here and the entities in the table
//SQL is snake_casing and Java is camelCasing, but JPA will take care of it
@Entity
//This annotation is used to connect the class with the table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //To auto generate the id
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String category;

}
