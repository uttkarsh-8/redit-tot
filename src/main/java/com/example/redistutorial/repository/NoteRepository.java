package com.example.redistutorial.repository;

import com.example.redistutorial.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, String> {
}
