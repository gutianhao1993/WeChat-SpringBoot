package com.yaao.service.impl;

import com.yaao.dao.SendMessageDao;
import com.yaao.entity.Alarm;
import com.yaao.entity.Template;
import com.yaao.entity.TemplateParam;
import com.yaao.service.SendMessageService;
import com.yaao.servlet.InitServlet;
import com.yaao.util.CommonUtil;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.ConnectException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 推送告警模板消息接口实现类
 *
 * @author GuTianHao
 */
@Service
public class SendMessageServiceImpl implements SendMessageService {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Resource
    private SendMessageDao sendMessageDao;

    @Override
    public void sendTemplateMsg() {
        boolean k = true;
        getTemplate(k);
    }

    @Override
    public void resendTemplateMsg() {
        boolean k = false;
        getTemplate(k);
    }

    @Override
    public void setExpireMsg() {
        sendMessageDao.setExpireSendFailMsg();
    }


    public void getTemplate(boolean k) {
        String token = InitServlet.accessToken.getAccessToken();

        //设置路径
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", token);
        if (k == false) {
            sendMessageDao.setExpireSendFailMsg();
        }
        List<Alarm> alarms = k ? sendMessageDao.getAlarmIDByFlag(0) : sendMessageDao.getAlarmIDByFlag(2);
        if (alarms != null && alarms.size() != 0) {
            for (Alarm alarm : alarms) {
                Integer id = alarm.getID();
                Integer memberID = alarm.getMemberID();
                //发送信息参数
                //用户OpenID,遍历发送给每一个用户
                List<String> openID = sendMessageDao.getOpenID(memberID);
                if (openID == null || openID.isEmpty()) {
                    sendMessageDao.setFlag(id, 3);
                    continue;
                }
                Template tem = new Template();
                //模板ID
                tem.setTemplateId("MTOGZgNpEoTbEn4FohF00d8kpHd1Kix-Zhq25kmlx8U");
                //设置顶部颜色
                tem.setTopColor("#00DD00");
                //模板信息详情路径
                tem.setUrl("http://suser.cn/WeChat/detailInfo.do?AlarmID=" + id + "&flag=0");
                //信息内容参数
                List<TemplateParam> paras = new ArrayList<>();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                alarm = sendMessageDao.sendMessageByAlarmID(id);
                if (alarm != null) {
                    if (alarm.getAlarmStr().indexOf("恢复") != -1) {
                        paras.add(new TemplateParam("first", "告警恢复", "#696969"));
                    } else {
                        paras.add(new TemplateParam("first", "告警开始", "#5F9EA0"));
                    }
                    if (alarm.getSoName() != null && alarm.getSoName().trim() != "") {
                        paras.add(new TemplateParam("keyword1", alarm.getSoName(), "#0044BB"));
                    }
                    if (alarm.getAreaName() != null && alarm.getAreaName().trim() != "") {
                        paras.add(new TemplateParam("keyword2", alarm.getAreaName(), "#0044BB"));
                    }
                    if (alarm.getAlarmMsg() != null && alarm.getAlarmMsg().trim() != "") {
                        paras.add(new TemplateParam("keyword3", alarm.getAlarmMsg(), "#0044BB"));
                    }
                    if (alarm.getAlarmLevel() != null && alarm.getAlarmLevel().toString().trim() != "") {
                        int alarmLevel = alarm.getAlarmLevel();
                        String level = "";
                        String color = "";
                        switch (alarmLevel) {
                            case 1:
                                level = "一级";
                                color = "#FF0000";
                                break;
                            case 2:
                                level = "二级";
                                color = "#FFC125";
                                break;
                            case 3:
                                level = "三级";
                                color = "#6495ED";
                                break;
                            case 4:
                                level = "四级";
                                color = "#66CD00";
                                break;
                            default:
                        }
                        paras.add(new TemplateParam("keyword4", level, color));
                    }
                    if (alarm.getAlarmTime() != null && alarm.getAlarmTime() != "") {
                        try {
                            paras.add(new TemplateParam("keyword5", sdf.format(sdf.parse(alarm.getAlarmTime())), "#0044BB"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    paras.add(new TemplateParam("remark", "请及时处理!", "#AAAAAA"));

                    tem.setTemplateParamList(paras);

                    JSONObject jsonResult;
                    for (int j = 0; j < openID.size(); j++) {
                        tem.setToUser(openID.get(j));
                        try {
                            jsonResult = CommonUtil.httpsRequest(requestUrl, "POST", tem.toJSON());
                            if (jsonResult != null) {
                                int errorCode = jsonResult.getInt("errcode");
                                String errorMessage = jsonResult.getString("errmsg");
                                if (errorCode == 0) {
                                    logger.info("模板信息发送成功! OpenID = {},AlarmNo = {}", openID.get(j), alarm.getAlarmNo());
                                    sendMessageDao.setFlag(id, 1);
                                } else {
                                    logger.error("模板消息发送失败:" + errorCode + "," + errorMessage + "," + openID.get(j));
                                    if (k) {
                                        sendMessageDao.setFlag(id, 2);
                                    } else {
                                        sendMessageDao.setReserver(id);
                                    }
                                }
                            }
                        } catch (ConnectException e) {
                            if (k) {
                                //若第一次发送微信超时,Flag设置为2
                                sendMessageDao.setFlag(id, 2);
                            } else {
                                //若已处于重发状态时发送超时,累计重发次数
                                sendMessageDao.setReserver(id);
                            }
                            logger.error("连接超时,稍后尝试重发...AlarmID = {}", alarm.getAlarmId());
                            e.printStackTrace();
                        } catch (Exception e) {
                            logger.error("https连接异常...");
                            e.printStackTrace();
                        }

                    }
                }
            }
        } else if (k == true) {
            logger.info("无告警信息");
        }
    }
}
