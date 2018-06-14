package edu.nju.cookery.service;

import edu.nju.cookery.vo.NoteVO;

import java.util.List;

public interface SearchService {

    List<NoteVO> search(String key,int pageIndex);

    int searchTotal(String key);

    List<NoteVO> searchFromPeople(int userId, String key, int pageIndex);

    int searchFromPeopleTotal(int userId, String key);
}
