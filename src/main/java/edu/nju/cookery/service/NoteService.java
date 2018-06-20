package edu.nju.cookery.service;

import edu.nju.cookery.vo.NewNoteVO;
import edu.nju.cookery.vo.NoteVO;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface NoteService {

    /**
     * 获取用户列表
     * @param userID
     * @return
     */
    List<NoteVO> getBlogListByUserID(int userID);

    /**
     * 查找用户收藏笔记
     * @param userID
     * @return
     */
    List<NoteVO> getCollectedBlog(int userID);

    /**
     * 获取总笔记数
     */
    int getBlogsTotal(int userID);

    /**
     * 获得喜欢人数最多的若干篇笔记
     * @param num 笔记数量
     * @return
     */
    List<NoteVO> getTopPopularNote(int num);

    /**
     * 获得推荐的笔记
     * @param num
     * @return
     */
    Set<NoteVO> getRecommendNote(int num);
    /**
     * 按照页数和用户id获取笔记列表
     * @param userID 用户id
     * @param page 页数
     * @return
     */
    List<NoteVO> getNoteListByUserIdAndPage(int userID, int page);

    HashMap<String, Object> getIndexRecommend();

    /**
     * 笔记收藏/取消收藏
     * @param userid
     * @param noteid
     * @return 收藏成功，返回0; 已经收藏过则取消收藏，返回1
     */
    int addCollect(int userid,int noteid);

    /**
     * 笔记喜欢/取消喜欢
     * @param userid
     * @param noteid
     * @return 喜欢成功，返回0; 已经喜欢则取消喜欢，返回1
     */
    int addLike(int userid,int noteid);

    /**
     * 得到用户是否喜欢该笔记
     * @param userid
     * @param noteid
     * @return 喜欢，返回0，还没有喜欢，返回1
     */
    int isLike(int userid,int noteid);

    /**
     * 得到用户是否收藏了该笔记
     * @param userid
     * @param noteid
     * @return 收藏了，返回0；还未收藏，返回1
     */
    int isCollect(int userid,int noteid);

    /**
     * 新增笔记
     * @param newnoteVO
     * @return 新增成功，返回0；新增失败，返回1
     */
    int createNote(NewNoteVO newnoteVO);
}
