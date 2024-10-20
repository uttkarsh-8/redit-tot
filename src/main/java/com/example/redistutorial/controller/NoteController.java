package com.example.redistutorial.controller;

import com.example.redistutorial.model.Note;
import com.example.redistutorial.repository.NoteRepository;
import com.example.redistutorial.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService noteService;
    private final NoteRepository noteRepository;

    @PostMapping
    public ResponseEntity<Note> creatNote(@RequestBody Note note){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(note));
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.getAll());
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Optional<Note>> getNote(@PathVariable String noteId){
        return ResponseEntity.ok(noteService.getById(noteId));
    }

    @DeleteMapping("{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNote(@PathVariable String noteId){
        noteRepository.deleteById(noteId);
    }
}
