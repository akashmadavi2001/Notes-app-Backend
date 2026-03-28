package com.website.notes.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.website.notes.Entity.Notes;
import com.website.notes.Service.NoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins="http://localhost:3000/")
public class NoteController {
    
@Autowired
private NoteService noteService;

@GetMapping
public List<Notes> getNotes(Notes notes) {
    return noteService.findAll();
}

@GetMapping("/{id}")
public Notes findnote(@PathVariable Long id) {
    return noteService.findNote(id);
}


@PostMapping
public Notes postNotes(@RequestBody Notes notes) {
    return noteService.saveNotes(notes);
}

@DeleteMapping("/{id}")
public void deleteNotes(@PathVariable Long id){
    noteService.deleteNotes(id);
}

@PutMapping("/{id}")
public Notes putNotes(@PathVariable Long id, @RequestBody Notes notes) {
    return noteService.findbyid(id,notes);
}

}
