package com.eliza.spring.druid.controller.fileController

import com.eliza.spring.library.utils.LogTools
import org.springframework.util.ResourceUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.time.LocalDateTime


/*-*- coding:utf-8 -*-
 * @Author  : debi
 * @Time    : 4/19/22
 * @Software: IntelliJ IDEA
 */

@RestController
@RequestMapping("/FileUpload")
class FileUpload {
    // 读取配置文件中的路径 static/files

    @PostMapping("upload")
    @ResponseBody
    fun upload(file: MultipartFile) {
//        /home/debi/Code/JAVA/SPRING/SPRING/Druid/src/main/resources/getFileFrom
        // 获得 classpath 的绝对路径
        val realPath = ResourceUtils.getURL("classpath:").path + "/getFileFrom"
        LogTools.LogPrintln(realPath, 45)
        val newFile = File(realPath)
        // 如果文件夹不存在、则新建
        if (!newFile.exists()) newFile.mkdirs()
        // 上传
        val fileName: String = ("${LocalDateTime.now()}@${file.originalFilename}").toString()
        file.transferTo(File(newFile, fileName))
    }


}