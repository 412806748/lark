package com.lark.xw.core.app.model.api;

/**
 * ================================================
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 * <p>
 * Created by MVPArmsTemplate
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Api {
    String BASE_URL = "http://10.187.134.81:8881/api/";
    /**
     * post
     * <p>
     * 参数：josn字符串
     * {
     * "username":"admin",
     * "password":"12345"
     * }
     */
    String REGESTER_URL = "account/register";
    /**
     * post
     * <p>
     * 参数：josn字符串
     * {
     * "username":"admin",
     * "password":"12345"
     * }
     */
    String LOGIN_URL = "account/login";


}
