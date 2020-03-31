package com.yaao.service.impl;

import com.yaao.entity.*;
import com.yaao.service.MenuService;
import com.yaao.util.CommonUtil;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 微信自定义菜单接口实现类
 *
 * @author GuTianHao
 */
@Service
public class MenuServiceImpl implements MenuService {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Override
    public Menu getMenu() {
        //首先创建二级菜单
        ViewButton vb_1 = new ViewButton();
        vb_1.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2frealTimeAlarm.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        vb_1.setName("实时告警");
        vb_1.setType("view");


        //创建第一个一级菜单
        ComplexButton cx_1 = new ComplexButton();
        cx_1.setName("告警信息");
        cx_1.setSub_button(new Button[]{vb_1});


        //继续创建二级菜单
        /*ViewButton vb_2 = new ViewButton();
        vb_2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2frealTimeData.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        vb_2.setName("实时数据");
        vb_2.setType("view");

        //创建第二个一级菜单
        ComplexButton cx_2 = new ComplexButton();
        cx_2.setName("数据信息");
        cx_2.setSub_button(new Button[]{vb_2});*/

        //继续创建二级菜单
        ViewButton vb_3 = new ViewButton();
        vb_3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2finfo.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        vb_3.setName("个人信息");
        vb_3.setType("view");

        //继续创建二级菜单
        ViewButton vb_4 = new ViewButton();
        vb_4.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2fpushSetting.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        vb_4.setName("推送设置");
        vb_4.setType("view");

        //创建第二个一级菜单
        ComplexButton cx_3 = new ComplexButton();
        cx_3.setName("个人中心");
        cx_3.setSub_button(new Button[]{vb_3, vb_4});

        //封装菜单数据
        Menu menu = new Menu();
        menu.setButton(new ComplexButton[]{cx_1, cx_3});

        return menu;
    }

    @Override
    public int createMenu(Menu menu) {
        String jsonMenu = JSONObject.fromObject(menu).toString();

        int status = 0;

        logger.info("菜单：" + jsonMenu);
        Token token = CommonUtil.getToken("wx7c93014354297ece", "fac813fd0536d3bc42a2905faa71503d");
        String path = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + token.getAccessToken();
        try {
            URL url = new URL(path);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.connect();
            OutputStream os = http.getOutputStream();
            os.write(jsonMenu.getBytes("UTF-8"));
            os.close();

            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] bt = new byte[size];
            is.read(bt);
            String message = new String(bt, "UTF-8");
            JSONObject jsonMsg = JSONObject.fromObject(message);
            status = Integer.parseInt(jsonMsg.getString("errcode"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return status;
    }
}
