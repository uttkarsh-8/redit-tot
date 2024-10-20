package com.example.redistutorial.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "stream notes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note implements Serializable {
    @Id
    private String id;
    private String title;
    private String content;
    private String addedDate;
    private boolean live = false;
}
