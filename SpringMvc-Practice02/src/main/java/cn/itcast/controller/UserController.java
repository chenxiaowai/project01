package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;
@SuppressWarnings("all")
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileupload1")
    public String testFileUpload(HttpServletRequest request) throws Exception{

        System.out.println("文件上传...");
        //1.使用fileupload组件完成文件上传
        //2.上传的文件
        String path = request.getSession().getServletContext().getRealPath("/uploadsA");
        //3.判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //3.1创建该文件夹
            file.mkdirs();
        }
        //4.解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //5.解析request

        List<FileItem> items = upload.parseRequest(request);
         //6.遍历
        for(FileItem item:items){

            if (item.isFormField()){
                //说明普通表单项
            }else {
                // 说明上传文件项
                // 获取上传文件的名称
                String filename = item.getName();
                //把文件的名称设置成唯一值，uuid
                 String uuid = UUID.randomUUID().toString().replace("-","");
                 filename = uuid+"_"+filename;
                 //完成文件上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }
}
