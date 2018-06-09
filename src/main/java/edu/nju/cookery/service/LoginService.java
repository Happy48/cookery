package edu.nju.cookery.service;

public interface LoginService {

    /**
     * 登陆
     * @param email 邮箱
     * @param pass 密码
     * @return  -1 无此用户 -2  密码有误 else 登陆成功
     */
    int login(String email,String pass);

    /**
     * 根据用户名查找用户id
     * @param userName
     * @return
     */
    int getUserIDByName(String userName);

    /**
     * 注册
     * @param name 用户名
     * @param pass 密码
     * @param email 邮箱
     * @return
     */
    int register(String name, String pass, String email);
}
