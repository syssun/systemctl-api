package com.sys.systemctlapi.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

@RestController
@RequestMapping("/ctl")
public class Ctl {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    //锁屏
    @GetMapping("/lockscreen")
    public String lockScreen() {
        kafkaTemplate.send("lockscreenTopic", "open");
        return "1";
    }

    //un锁屏
    @GetMapping("/unlockscreen")
    public String unlockScreen() {
        kafkaTemplate.send("unlockscreenTopic", "open");
        return "1";
    }


    //计算器
    @GetMapping("/calc")
    public String calc() {
        kafkaTemplate.send("calcTopic", "open");
        return "1";
    }

    //60s 关机
    @GetMapping("/shutdown")
    public String shutdown() {
        System.out.println("60s 关机");
        kafkaTemplate.send("shutdownTopic", "open");
        return "1";
    }

    //10min 关机
    @GetMapping("/shutdownten")
    public String shutdownten() {
        System.out.println("10min 关机");
        kafkaTemplate.send("shutdowntenTopic", "open");
        return "1";
    }

    //立即关机
    @GetMapping("/shutdownnow")
    public String rononce() {
        kafkaTemplate.send("shutdownnowTopic", "open");
        return "1";
    }

    //取消关机命令
    @GetMapping("/canceshutdow")
    public String canceshutdown() {
        System.out.println("取消关机命令");
        kafkaTemplate.send("canceshutdowTopic", "open");
        return "1";
    }

    @GetMapping("/taskmgr")
    public String taskmgr() {
        kafkaTemplate.send("taskmgrTopic", "open");
        return "1";
    }

    // qq D:\qq\qq安装文件\Bin\qq.exe
    @GetMapping("/openqq")
    public String openqq() {
        kafkaTemplate.send("openqqTopic", "open");
        return "1";
    }

    // close qq  taskkill /f /im qq.exe
    @GetMapping("/closeqq")
    public String closeqq() {
        kafkaTemplate.send("closeqqTopic", "open");
        return "1";
    }

    // D:\微信\WeChat\wechat.exe
    @GetMapping("/openwechat")
    public String openwechat() {
        kafkaTemplate.send("openwechatTopic", "open");
        return "1";
    }

    //
    @GetMapping("/closewechat")
    public String closeWechat() {
        kafkaTemplate.send("closewechatTopic", "open");
        return "1";
    }

    //系统睡眠
    @GetMapping("/seleep")
    public String seleep() {
        kafkaTemplate.send("seleepTopic", "open");
        return "1";
    }

    //自定义命令
    @GetMapping("/autoctl")
    public String autoctl(String ctl) {
        kafkaTemplate.send("autoctlTopic", "open");
        return "1";
    }

}
