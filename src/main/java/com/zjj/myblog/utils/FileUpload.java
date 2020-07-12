package com.zjj.myblog.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileUpload {
    public String upload(MultipartFile file, String path) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();//获取文件名
            fileName = this.getFileName(fileName);
            File filepath = new File(path, fileName);
            // 判断路径是否存在，不存在则新创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }// 将上传文件保存到目标文件目录
            file.transferTo(new File(path + File.separator + fileName));
            return path+fileName;
        } else {
            return "error";
        }
    }

    /**
     * 文件名后缀前添加一个时间戳
     */
    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        fileName = fileName.substring(0, index) + "_" + nowTimeStr + fileName.substring(index);
        return fileName;
    }

}
