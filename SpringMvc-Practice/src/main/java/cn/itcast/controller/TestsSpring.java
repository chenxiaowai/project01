package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class TestsSpring {
    /**
     * 返回找是String
     * @param model
     * @return
     */
    @RequestMapping("/testSpring")
    public String testSpring(Model model){
        System.out.println("执行了");

        User user = new User();
        user.setUsername("aaa");
        user.setPassword("111");
        user.setAge(11);
        model.addAttribute("user",user);

        return "success";
    }

    /**
     * 返回值是void
     */
    @RequestMapping("/testVoid")
    public void  testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("void执行了");

        //1.转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);


        //2.重定向
//        response.sendRedirect(request.getContextPath()+"/response.jsp");
//        System.out.println(request.getContextPath());


        //3.直接进行响应
        //3.1设置编码及响应文本
        response.setCharacterEncoding("utf-8");
        //3.2设置文本格式
        response.setContentType("text/html;charset=utf-8");

        //打印到控制台
        response.getWriter().print("helloSpringMvc");
        return;
    }


    /**
     * ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

        //1.直接new一个ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了");

        User user = new User();
        user.setUsername("bbb");
        user.setPassword("222");
        user.setAge(111);

        //2.把user对象存储到mv中，底层还是存储到request域中
        mv.addObject("user",user);

        //3.跳转到哪个页面，底层依然是视图解析器
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了");

        //1.转发关键字forward，需要将路径写完整
        //return "forward:/WEB-INF/pages/success.jsp";

        //2.重定向，不需要加项目名，虚拟路径，因为框架底层已经配置好了
        return "redirect:/response.jsp";

    }

}
