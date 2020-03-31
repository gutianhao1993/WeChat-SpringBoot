package com.yaao.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


/**
 * 获取openID工具类
 *
 * @author GuTianHao
 */
public class OpenIDUtil {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static String getOpenID(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String openID = null;
        //针对get获取get参数
        Map<String, String[]> params = request.getParameterMap();
        //拿到的code的值
        String[] codes = params.get("code");

        if (codes != null) {
            //code
            String code = codes[0];
            //这一步就是拼写微信api请求地址并通过微信的appid和微信公众号的AppSecret 以及我们获取到的针对用户授权回调的code 拿到 这个用户的 openid和access_token
            String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code".replace("APPID", "wx7c93014354297ece").replace("APPSECRET", "fac813fd0536d3bc42a2905faa71503d").replace("CODE", code);
            //我们需要自己写或者在网上找一个 doGet 方法 发送doGet请求
            String requestResult = doGet(requestUrl);
            //把请求成功后的结果转换成JSON对象
            JSONObject getCodeResultJson = JSON.parseObject(requestResult);
            if (getCodeResultJson == null || getCodeResultJson.getInteger("errcode") != null || getCodeResultJson.getString("openid") == null) {
                throw new Exception();
            }
            //拿到openid
            openID = getCodeResultJson.getString("openid");
            return openID;
        } else {
            return null;
        }
    }

    public static String doGet(String requestUrl) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(requestUrl);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                logger.info(key + "--->" + map.get(key));
            }
            //定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static String getOpenIDByInterfaceOrSession(HttpServletRequest request, HttpServletResponse response) {
        String openID = null;
        try {
            //通过微信接口获取用户openID
            openID = OpenIDUtil.getOpenID(request, response);
            if (openID == null || openID == "") {
                openID = (String) request.getSession().getAttribute("openID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openID;
    }
}
