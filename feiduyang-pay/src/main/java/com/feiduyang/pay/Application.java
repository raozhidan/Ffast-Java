package com.feiduyang.pay;

import com.feiduyang.pay.modules.weixinpay.util.ConfigUtil;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

/**
 * @param
 * @description * 支付主控(启动的时候一定要把main方法的注释去掉，配置好支付宝、微信以及银联相关参数)
 * * 启动   java -jar feiduyang-pay.jar --server.port=8886
 * * linux 下 后台启动  nohup java -jar feiduyang-pay.jar --server.port=8886 &
 * @Author Zhidan.Rao
 * @Version 1.0.0
 * @return 统一返回对象
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ImportResource({"classpath:spring-context-dubbo.xml"})
@Controller
public class Application extends WebMvcConfigurerAdapter {
    private static final Logger logger = Logger.getLogger(Application.class);

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/cert/**").addResourceLocations(
                "classpath:/cert/");
        super.addResourceHandlers(registry);
        logger.info("自定义静态资源目录,这只是个Demo,生产肯定不会暴露");
    }

    public static void main(String[] args) throws InterruptedException,
            IOException {
        SpringApplication.run(Application.class, args);
        //初始化 支付宝-微信-银联相关参数,涉及机密,此文件不会提交,请自行配置相关参数并加载
        //Configs.init("zfbinfo.properties");//支付宝
        ConfigUtil.init("wxinfo.properties");//微信
        //SDKConfig.getConfig().loadPropertiesFromSrc();//银联
        logger.info("支付项目启动 ");
    }

}