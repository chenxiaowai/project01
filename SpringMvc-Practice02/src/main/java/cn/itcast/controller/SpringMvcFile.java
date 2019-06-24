package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class SpringMvcFile {

    /**
     * springMvc上传文件
     *
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springMvc文件上传");
        //1.使用fileupload组件完成上传
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //2.判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //3.获取上传文件名称
        String filename = upload.getOriginalFilename();
        //4.把文件名称设置成谓一致，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //5.完成文件上传
        upload.transferTo(new File(path, filename));
        return "success";
    }


    /**
     * 跨服务器上传文件
     *
     * @param upload
     * @return
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器上传文件");

        //1. 定义上传文件服务器路径
        String path = "http://localhost:9090/";
        //3.获取上传文件名称
        String filename = upload.getOriginalFilename();
        //4.把文件名称设置成唯一致，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //5.创建客户端的对象
        Client client = Client.create();
        //6.和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        //7.上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
