package com.aaryan.Quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    //We use this annotation as we have a quiz with multiple questions and we need to use it in List<Question>
    @ManyToMany
    private List<Question> questions;
}
