package com.website.notes.Error;

public class NotesNotFound extends RuntimeException{
   public NotesNotFound(Long id) {
        super("Not found id: " + id);
    }
};
