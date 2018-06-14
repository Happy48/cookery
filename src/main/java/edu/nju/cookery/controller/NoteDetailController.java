package edu.nju.cookery.controller;

import edu.nju.cookery.service.NoteDetailService;
import edu.nju.cookery.vo.NoteDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class NoteDetailController {

    @Autowired
    private NoteDetailService noteDetailService;

    @RequestMapping(value = "/api/getNoteDetail",method = RequestMethod.GET)
    @CrossOrigin
    public NoteDetailVO getNoteDetail(@RequestParam("noteId") int noteId){
        NoteDetailVO noteDetailVO = noteDetailService.getNoteDetail(noteId);
        return noteDetailVO;//???????
    }
}
