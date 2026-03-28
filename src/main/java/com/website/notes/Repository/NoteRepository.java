package com.website.notes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.website.notes.Entity.Notes;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {

}