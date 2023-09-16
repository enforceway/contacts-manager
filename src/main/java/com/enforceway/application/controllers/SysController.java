package com.enforceway.application.controllers;

import com.enforceway.application.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class SysController {

    @RequestMapping("/refreshToken")
    public String refreshToken() {
        return null;
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public R updateImage(@RequestParam(value = "file") MultipartFile files) throws IOException {
        Resource resource = new ClassPathResource("static/1.txt");
        String path = resource.getFile().getPath();
        System.out.println(path);
//        for (MultipartFile file : files) {
//            file.transferTo();
//            System.out.println(file.getOriginalFilename());
//        }
//        System.out.println(param1);
//        System.out.println(param2);
        return null;
    }

}
