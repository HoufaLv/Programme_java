package com.ksit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @GetMapping("/upload")
    public String fileUpload(){

        //直接跳转到上传文件页面去
        return "fileUpload";
    }

    @PostMapping(value = "/upload",produces ="text/html;charset=UTF-8")
    public String fileUpload(String filename, MultipartFile uploadFile, RedirectAttributes redirectAttributes) throws IOException {

        if (!uploadFile.isEmpty()){

            /*获取文件相关信息*/
            System.out.println(new String(uploadFile.getOriginalFilename().getBytes(),"UTF-8"));
            System.out.println(uploadFile.getSize());

            //将文件复制到本地磁盘
            uploadFile.transferTo(new File("D:/upload/" + new String(uploadFile.getOriginalFilename().getBytes(),"UTF-8")));
            System.out.println("上传成功");
        }

        //通过 redirectAttribute 变量带一个闪现参数到前端去
        redirectAttributes.addFlashAttribute("message",uploadFile.getOriginalFilename());
        
        return "redirect:/upload";
    }
}
