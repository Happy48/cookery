package edu.nju.cookery.repository;

import edu.nju.cookery.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository  extends JpaRepository<Work,Integer> {

    List<Work> findByNoteID(int noteId);
}
