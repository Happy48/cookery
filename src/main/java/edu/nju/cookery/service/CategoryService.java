package edu.nju.cookery.service;

import edu.nju.cookery.vo.NoteVO;

import java.util.List;

public interface CategoryService {

    /**
     * 根据标签名找笔记
     * @param clazz
     * @return
     */
    public List<NoteVO> getNoteByClazz(String clazz,int page) ;

    /**
     * 获得总条数
     */
    public int getNoteTotalByClazz(String clazz) ;
}
