package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//微服务热更新
//@RefreshScope

public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${pattern.dateformat}")
//    private String dateformat;

    //自动配置PatternProperties对象

    @Autowired
    private PatternProperties properties;


    @GetMapping("/prop")
    public String prop(){
        return properties.getEnvSharedValue();
    }

    @GetMapping("now")
    public String  now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }


    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth",required = false) String truth) {
        System.out.println(truth);
        return userService.queryById(id);
    }
}
