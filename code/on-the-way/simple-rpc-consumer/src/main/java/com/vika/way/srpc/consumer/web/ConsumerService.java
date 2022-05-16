package com.vika.way.srpc.consumer.web;

import com.vika.way.srpc.provider.client.service.GreetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenwei.tjw
 * @date 2022/5/13
 **/
@RestController
@RequestMapping("/rpc")
public class ConsumerService {

    @Resource
    private GreetService greetService;

    @GetMapping("/hello")
    public String hello(String user) {
        return greetService.hello(user);
    }

    @GetMapping("/goodbye")
    public String goodbye(String user) {
        return greetService.goodbye(user);
    }
}
