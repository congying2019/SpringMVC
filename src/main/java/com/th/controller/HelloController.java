package com.th.controller;

import com.th.pojo.UploadedImageFile;
import com.th.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @RequestMapping("/path/{name}/{age}")
    public String path(ModelMap map, @PathVariable String name, @PathVariable Integer age) {
        map.addAttribute("name", name);
        map.addAttribute("age", age);
        map.addAttribute("message", "hello world");
        return "path";
    }

    @RequestMapping("/url")
    public ModelAndView url(ModelAndView mv, @RequestParam String name, @RequestParam Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        modelAndView.addObject("message", "hello world");
        modelAndView.setViewName("url");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("password", user.getPassword());
        modelAndView.addObject("message", "loginSuccess");
        modelAndView.setViewName("loginSuccess");
        return modelAndView;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Integer i = (Integer) session.getAttribute("count");
        if (i == null) {
            i = 0;
        }
        i++;
        if (i > 5) {
            i = 0;
            mv.setViewName("index");
        } else {
            mv.setViewName("check");
        }
        session.setAttribute("count", i);
        return mv;

    }

    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping("/uploadImage")
    public ModelAndView uploadImage(HttpServletRequest request, UploadedImageFile file) throws IOException {
        String name = "201910090942";
        String newFileName = name + ".png";
        File newFile = new File(request.getSession().getServletContext().getRealPath("/image"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        ModelAndView mv=new ModelAndView();
        mv.addObject("imageName", newFileName);
        mv.setViewName("showUploadFile");
        return mv;
    }

}
