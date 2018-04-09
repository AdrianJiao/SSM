package com.company.controller;

import com.company.bean.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    //文件上传的MultipartFile一定注意要与表单的file的name一致否则会空指针
    @RequestMapping("/register")
    public void register(User user,
                         MultipartFile picture,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        User isExist = userService.isUserExist(user.getUsername());

        //用户名存在
        if(isExist!=null){
            response.getWriter().write("该用户名已存在！3s后返回注册界面！");
            response.setHeader("Refresh","3;"+request.getContextPath()+"/register.jsp");
            return;
        }

        //生成新文件名
       String originalFilename = picture.getOriginalFilename();
       String newFileName = UUID.randomUUID().toString() +
               originalFilename.substring(originalFilename.lastIndexOf("."));
       String realPath = request.getServletContext().getRealPath("file");

       //创建父目录
       File  directory = new File(realPath);
       directory.mkdir();

       //上传位置
       File uploadPic = new File(realPath+File.separator+newFileName);

       //上传
       picture.transferTo(uploadPic);
       user.setHeadportrait(newFileName);

       //添加用户
       boolean ret = userService.addUser(user);

       if(ret){
           response.getWriter().write("注册成功！3s后返回登陆界面！");
           response.setHeader("Refresh","3;"+request.getContextPath()+"/login.jsp");
       }else {
           response.getWriter().write("注册失败！3s后返回注册界面！");
           response.setHeader("Refresh","3;"+request.getContextPath()+"/register.jsp");
       }
    }

    //注意这里最好不直接传入User
    //否则Spring会默认将你的User类型的参数放入model的request中
    @RequestMapping("/login")
    public String login(String username,
                        String password,
                        HttpSession session,
                        HttpServletResponse response,
                        HttpServletRequest request) throws IOException {
        User queryUser = userService.isUserExist(username);
        System.out.println(queryUser);

        if(queryUser.getUsername().equals(username)
                &&queryUser.getPassword().equals(password)){

            //将用户信息放入session
            session.setAttribute("user",queryUser);
            return "/WEB-INF/user/userInfo.jsp";
        }else {
           return "/login.jsp";
        }
    }
}
