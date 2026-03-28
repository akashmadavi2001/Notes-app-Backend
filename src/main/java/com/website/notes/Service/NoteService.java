package com.website.notes.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.website.notes.Entity.Notes;
import com.website.notes.Error.NotesNotFound;
import com.website.notes.Repository.NoteRepository;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Notes> findAll() {
        return noteRepository.findAll();
    }

    public Notes saveNotes(Notes notes) {
        return noteRepository.save(notes);
    }

    public Notes findNote(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotesNotFound(id));
    }

    public void deleteNotes(Long id) {
        noteRepository.deleteById(id);
    }

    public Notes findbyid(Long id, Notes notes) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setNote(notes.getNote());
                    return noteRepository.save(note);
                }).orElseThrow(() -> new NotesNotFound(id));
    }
}
