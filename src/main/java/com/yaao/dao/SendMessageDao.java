package com.yaao.dao;

import com.yaao.entity.Alarm;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 推送告警模板信息
 *
 * @author GuTianHao
 */
public interface SendMessageDao {
    /**
     * 通过alarmNo查询告警对应信息
     *
     * @param id
     * @return
     */
    Alarm sendMessageByAlarmID(@Param("ID") Integer id);

    /**
     * 查询告警
     *
     * @param flag
     * @return
     */
    List<Alarm> getAlarmIDByFlag(@Param("flag") Integer flag);

    /**
     * Flag=1 发送成功 Flag=2 发送失败 Flag=3 没有发送目标
     *
     * @param id
     * @param flag
     */
    void setFlag(@Param("ID") Integer id, @Param("flag") Integer flag);

    /**
     * 通过告警的MemberID查询绑定的人员OpenID 发送告警
     *
     * @param memberID
     * @return
     */
    List<String> getOpenID(@Param("memberID") Integer memberID);

    /**
     * 重发计数
     *
     * @param id
     */
    void setReserver(@Param("ID") Integer id);

    /**
     * 标记过期失效告警
     */
    void setExpireSendFailMsg();
}
