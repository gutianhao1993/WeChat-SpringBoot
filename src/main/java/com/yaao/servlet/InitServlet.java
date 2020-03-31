package com.yaao.servlet;

import com.yaao.entity.Token;
import com.yaao.util.CommonUtil;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 程序运行时启动,定时获取access_token
 *
 * @author GuTianHao
 */
@WebServlet(name = "initServlet",urlPatterns = "",
        initParams = {
                @WebInitParam(name = "appid", value = "wx7c93014354297ece"),
                @WebInitParam(name = "appsecret", value = "fac813fd0536d3bc42a2905faa71503d")
        },
        loadOnStartup = 0)
public class InitServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    /**
     * 第三方用户唯一凭证
     */
    public static String appid = "wx7c93014354297ece";
    /**
     * 第三方用户唯一凭证密钥
     */
    public static String appsecret = "fac813fd0536d3bc42a2905faa71503d";
    public static Token accessToken = null;

    /**
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        // 获取web.xml中配置的参数
        InitServlet.appid = getInitParameter("appid");
        InitServlet.appsecret = getInitParameter("appsecret");

        logger.info("weixin api appid:{}", InitServlet.appid);
        logger.info("weixin api appsecret:{}", InitServlet.appsecret);

        // 未配置appid、appsecret时给出提示
        if ("".equals(InitServlet.appid) || "".equals(InitServlet.appsecret)) {
            logger.error("appid and appsecret configuration error, please check carefully.");
        } else {
            start();
        }

    }

    public void start() {
        // 启动定时获取access_token的线程
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                accessToken = CommonUtil.getToken(appid, appsecret);
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
                String currentTime = sdf.format(System.currentTimeMillis());

                if (accessToken != null) {
                    logger.info("获取access_token成功，有效时长{}秒", accessToken.getExpiresIn());
                    logger.info("获取到的access_token为:" + accessToken.getAccessToken());
                    logger.info("获取时间为:" + currentTime);
                } else {
                    try {
                        logger.error("1分钟之后尝试重新获取access_token...");
                        Thread.sleep(60000);
                        start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 1, TimeUnit.HOURS);
    }
}

