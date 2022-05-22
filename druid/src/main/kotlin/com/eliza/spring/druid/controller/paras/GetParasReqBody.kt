package com.eliza.spring.druid.controller.paras

import com.eliza.spring.library.utils.LogTools
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/parasRb")
class GetParasReqBody {

    @RequestMapping(value = ["/getHead"], method = [RequestMethod.POST])
    @GetMapping(value = ["/getHead"])
    fun getHead(
        @RequestHeader("Accept") accept: String,
        @RequestHeader("User-Agent") userAgent: String,
        @RequestHeader("Host") host: String

    ) {
        LogTools.LogPrintln("获取 Req 请求头", 11)
        LogTools.LogPrintln(accept, 12)
        LogTools.LogPrintln(userAgent, 12)
        LogTools.LogPrintln(host, 12)
    }

    /**
     * Get req body
     * 获取请求体 （string）
     * @param body
     */
    @RequestMapping(value = ["/getReqBody"], method = [RequestMethod.POST])
    fun getReqBody(@RequestBody body: String) {
        LogTools.LogPrintln("获取 Req 请求体", 11)
        LogTools.LogPrintln(body, 12)
    }


}