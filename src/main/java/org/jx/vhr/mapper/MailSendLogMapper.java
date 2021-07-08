package org.jx.vhr.mapper;

import org.jx.vhr.entity.MailSendLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (MailSendLog)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 13:00:57
 */
public interface MailSendLogMapper {
    Integer updateMailSendLogStatus(@Param("msgId") String msgId, @Param("status") Integer status);

    Integer insert(MailSendLog mailSendLog);

    List<MailSendLog> getMailSendLogsByStatus();

    Integer updateCount(@Param("msgId") String msgId, @Param("date") Date date);

}

