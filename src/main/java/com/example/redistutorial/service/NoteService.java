package com.example.redistutorial.service;

import com.example.redistutorial.model.Note;
import com.example.redistutorial.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    @CachePut(value = "notes", key = "#note.id")
    public Note createNote(Note note){
        note.setId(UUID.randomUUID().toString());
        return noteRepository.save(note);
    }

//    @Cacheable(value = "notes", key = "#noteId")
    public List<Note> getAll(){
        return noteRepository.findAll();
    }

    @Cacheable(value = "notes", key = "#noteId")
    public Optional<Note> getById(String noteId){
        return noteRepository.findById(noteId);
    }

    public Note updateNote(String noteId, Note note){
        Note lastNote = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note with give id not found"));
        lastNote.setTitle(note.getTitle());
        lastNote.setContent(note.getContent());
        lastNote.setLive(note.isLive());

        return noteRepository.save(lastNote);
    }

    @CacheEvict(value = "notes", key = "#noteId")
    public void deleteNote(String noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note with given id not found"));
        noteRepository.delete(note);
    }

}
