/**
 * FileName: FanoutReciver
 * Author:   linwd
 * Date:     2021/5/3 15:10
 * Description: Fanout策略的发送
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yangxf.demoRabbitMQ.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Fanout策略的发送〉
 *
 * @author linwd
 * @create 2021/5/3
 * @since 1.0.0
 */
@Component
public class FanoutReciver {

    @RabbitListener(queues = "queue-one")
    public void handle1(String msg){
        System.out.println("FanoutReciver:handle1:"+msg);
    }

    @RabbitListener(queues = "queue-two")
    public void handle2(String msg){
        System.out.println("FanoutReciver:handle2:"+msg);
    }
}
