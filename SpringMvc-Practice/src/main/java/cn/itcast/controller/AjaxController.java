package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class AjaxController {
    /**
     * @RequestBody:获取ajax返回回来的json数据，已经封装到了javaBean对象中
     * @ResponseBody：将javaBean对象又转化成json对象返回到jsp页面中，省去了以前的转化步骤和writer写回到jsp页面中的步骤
     *
     * @param user
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("Ajax执行了....");
        System.out.println(user);

        //模拟将jsp页面的user数据进行查询数据库进行更改
        user.setUsername("哈哈");
        user.setAge(122);
        return user;
    }

}
