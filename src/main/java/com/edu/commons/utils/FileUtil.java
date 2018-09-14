package com.edu.commons.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUtil {
    //保存图片并返回保存路径
    public static List<String> toString(List<CommonsMultipartFile> list, HttpServletRequest request){
        List<String> filenames = new ArrayList<>();
        File dir = new File(new File(request.getServletContext().getRealPath("/")).getParent(), "kitchenphoto");
        if(!dir.exists()){
            dir.mkdirs();
        }

        for(MultipartFile file : list){
            String filename = file.getOriginalFilename();
            if(filename.length() > 50){
                filename = filename.substring(filename.length() - 50);
            }
            filename = UUID.randomUUID().toString().replace("-","") + filename;
            filenames.add(filename);
            File newdir = new File(dir, filename);
            try {
                file.transferTo(newdir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return filenames;
    }
}
