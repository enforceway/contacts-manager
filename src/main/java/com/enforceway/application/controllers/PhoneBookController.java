package com.enforceway.application.controllers;

import com.enforceway.application.constants.SystemConstant;
import com.enforceway.application.entity.ContactItem;
import com.enforceway.application.services.PhoneBookService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import com.enforceway.application.entity.R;

import java.io.*;

@Slf4j
@RestController
public class PhoneBookController {

    private


    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    private PhoneBookService phoneBookService;

    @RequestMapping(value = "/phoneBook/loadAll", method = RequestMethod.GET)
    public R getAll() {
        return phoneBookService.retriveContactItems();
    }

    @RequestMapping(value = "/phoneBook/findById", method = RequestMethod.GET)
    public R findById(HttpServletRequest request) {
        String contactIdStr = request.getParameter("id");
        Integer contactId = Integer.parseInt(contactIdStr);
        return this.phoneBookService.retriveContactItemById(contactId);
    }

    @RequestMapping(value = "/phoneBook/save", method = RequestMethod.POST)
    public R save(@RequestBody ContactItem contactItem, HttpServletRequest request) {
        this.log.info("接受到的名字：" + contactItem.getName());
        return this.phoneBookService.saveContact(contactItem);
    }

    @RequestMapping(value = "/phoneBook/delete", method = RequestMethod.GET)
    public R removeContact(HttpServletRequest request) {
        String contactIdStr = request.getParameter("id");
        Integer contactId = Integer.parseInt(contactIdStr);
        return this.phoneBookService.removeContact(contactId);
    }

    @RequestMapping(value = "/phoneBook/avatar", method = RequestMethod.GET)
    public void contactAvatar(@RequestParam("imageName") String imageName, HttpServletResponse response) throws IOException {
        File imageFile = new File(SystemConstant.imageStorePath + File.separator + imageName);
        ServletOutputStream outputStream = response.getOutputStream();
        if (!imageFile.exists()) {
            this.log.info("访问图片地址不存在:" + imageFile.getPath());
            byte[] bytes = new byte[0];
            outputStream.write(bytes);
        } else {
            this.log.info("访问图片地址:" + imageFile.getPath());
            InputStream imageStream = new FileInputStream(imageFile);
            byte[] bytes = new byte[1024];
            int i = 0;
            while((i = imageStream.read(bytes)) != 0) {
                outputStream.write(bytes, 0, i);
            }
//            outputStream.close();
        }

//        Resource resource = this.resourceLoader.getResource("images");
//        try {
//            String path = resource.getFile().getPath();
//            System.out.println("path is :" + path);
//            return path;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
