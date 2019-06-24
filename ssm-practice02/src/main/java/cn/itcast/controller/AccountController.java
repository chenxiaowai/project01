package cn.itcast.controller;

import cn.itcast.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {
    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("findAll执行了。。。。");
        return "success";
    }



    @RequestMapping("/saveAccount")
    public  String saveAccount(Account account){
        System.out.println("saveAccount执行了。。。。");
        return "success";
    }
}
