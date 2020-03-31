package com.yaao.service.impl;

import com.yaao.entity.TextMessage;
import com.yaao.service.SubscribeService;
import com.yaao.util.MessageUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 订阅消息接口实现类(微信交互)
 *
 * @author GuTianHao
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {
    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 处理微信发来的请求
     *
     * @param request
     * @return
     */
    @Override
    public String wechatPost(HttpServletRequest request) {
        String respMessage = null;
        try {
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");

            request.getSession().setAttribute("openID", fromUserName);

            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 消息内容
            String content = requestMap.get("Content");

            //logger.info("FromUserName is:" + fromUserName + ", ToUserName is:" + toUserName + ", MsgType is:" + msgType);

            // 事件推送
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    TextMessage text = new TextMessage();
                    text.setContent("欢迎关注亚奥微动环,首次关注请完成账号绑定!\n<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx7c93014354297ece&redirect_uri=http%3a%2f%2fsuser.cn%2fWeChat%2flogin.do&response_type=code&scope=snsapi_base&state=123#wechat_redirect\">点击进入绑定页面</a>");
                    text.setToUserName(fromUserName);
                    text.setFromUserName(toUserName);
                    text.setCreateTime(System.currentTimeMillis() + "");
                    text.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

                    respMessage = MessageUtil.textMessageToXml(text);
                }
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {

                }
            }
        } catch (Exception e) {

        }
        return respMessage;
    }
}
