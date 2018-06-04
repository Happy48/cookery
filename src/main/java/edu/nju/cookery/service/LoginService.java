package edu.nju.cookery.service;

public interface LoginService {

    /**
     * 登陆
     * @param email 邮箱
     * @param pass 密码
     * @return  -1 无此用户 -2  密码有误 else 登陆成功
     */
    int login(String email,String pass);


}
