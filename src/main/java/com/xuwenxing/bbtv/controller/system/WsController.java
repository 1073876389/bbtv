package com.xuwenxing.bbtv.controller.system;

import com.xuwenxing.bbtv.domain.system.WiselyMessage;
import com.xuwenxing.bbtv.domain.system.WiselyReponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * webSocket控制器
 * Created by xuwx on 2018/8/20.
 */
@Controller
public class WsController {

    @MessageMapping("/ws")//注解开启webSocket访问地址映射
    @SendTo("/topic/getResponse")
    public WiselyReponse say(WiselyMessage message) throws Exception {
        //等待三秒返回消息内容
        Thread.sleep(3000);
        return new WiselyReponse("欢迎使用webScoket:"+message.getName());
    }
}
