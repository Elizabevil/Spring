package com.eliza.spring.druid.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/Jump")
class JumpController {

    /**
     * templates下的页面
     * @return
     */
    @GetMapping("/ToIndex")
    @RequestMapping("/ToIndex")
    fun ToIndex(): String {
        return "index"
    }

    /**
     * templates下的页面
     * @return
     */
    @GetMapping("/ToIndexHtml")
    @RequestMapping("/ToIndexHtml")
    fun ToIndexHtml(): String {
        return "getFromWeb.html"
    }

    /**
     * Error
     * */
    @GetMapping("/ToIndexRedirect")
    @RequestMapping("/ToIndexRedirect")
    fun ToIndexRedirect(): String {
        return "redirect:index"
    }

    /**
     * Error
     * */
    @GetMapping("/ToIndexHtmlRedirect")
    @RequestMapping("/ToIndexHtmlRedirect")
    fun ToIndexHtmlRedirect(): String {
        return "redirect:index.html"
    }

    /**
     * templates下的页面必须内部跳转 templates下的页面必须内部跳转
     */
    /**
     * ok
     * @return
     */

    @GetMapping("/ToTemp")
    @RequestMapping("/ToTemp")
    fun ToTemp(): String {
        return "Temp"
    }

    /**
     * ok
     * */
    @GetMapping("/ToTempHtml")
    @RequestMapping("/ToTempHtml")
    fun ToTempHtml(): String {
        return "Temp.html"
    }

    /**
     * Error
     * */
    @GetMapping("/ToTempRedirect")
    @RequestMapping("/ToTempRedirect")
    fun ToTempRedirect(): String {
        return "redirect:Temp"
    }

    /**
     * Error
     * */
    @GetMapping("/ToTempHtmlRedirect")
    @RequestMapping("/ToTempHtmlRedirect")
    fun ToTempHtmlRedirect(): String {
        return "redirect:Temp.html"
    }


    /**
     * Static.html  Error  500
     *    Error resolving template [Static], template might not exist or
     *      might not be accessible by any of the configured Template Resolvers
     * */
    @GetMapping("/ToStaticHtml")
    @RequestMapping("/ToStaticHtml")
    fun ToStaticHtml(): String {
        return "Static.html"
    }

    /**
     *   Static.html  Error  500
     *   Error resolving template [Static], template might not exist or might not be accessible by any of the configured Template Resolvers
     * */
    @GetMapping("/ToStatic")
    @RequestMapping("/ToStatic")
    fun ToStatic(): String {
        return "Static"
    }

    /**
     *   Static.html  Error  404
     * */
    @GetMapping("/ToStaticHtmlRedirect")
    @RequestMapping("/ToStaticHtmlRedirect")
    fun ToStaticHtmlRedirect(): String {
        return "redirect:Static.html"
    }

    /**
     * Static.html  Error  404
     * */
    @GetMapping("/ToStaticRedirect")
    @RequestMapping("/ToStaticRedirect")
    fun ToStaticRedirect(): String {
        return "redirect:Static"
    }

}