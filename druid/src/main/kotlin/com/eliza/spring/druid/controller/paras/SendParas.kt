package com.eliza.spring.druid.controller.paras

import com.eliza.spring.library.model.Stu
import com.eliza.spring.library.model.User
import com.eliza.spring.library.utils.LogTools
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest

/**
@RestController注解，相当于@Controller+@ResponseBody两个注解的结合，
但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面
使用@RestController返回json数据就不需要在方法前面加@ResponseBody注解了

@ResponseBody后，返回结果直接写入HTTP response body中，不会被解析为跳转路径。
 */
@RestController
@RequestMapping("/sendParas")
class SendParas {

    /**
     * 返回 json Body数据
     *
     * @param model
     * @param req
     */

    @RequestMapping(value = ["/sendReq"])
    fun sendReq(model: Model, request: HttpServletRequest): Map<String, String> {
        val map: Map<String, String> = HashMap<String, String>().apply {
            this.put("name", "法外狂徒")
            this.put("age", "12")
        }
        model.addAttribute("msg", map) //向页面传值，页面通过el表达式取值
        return map
    }


    /**
     *返回 json 数组
     * @return List<String>
     */
    @RequestMapping(value = ["/returnList"])
    @ResponseBody
    fun returnList(): List<String> {
        return ArrayList<String>().apply {
            this.add("法外狂徒")
            this.add("12")
        } //返回json 格式的List集合
    }

    /**
     * ModelAndView
     * @return ModelAndView
     */
    @RequestMapping(value = ["/Mav"])
    @ResponseBody
    fun returnMav(): ModelAndView {
        return ModelAndView().apply {
            this.addObject("name", "法外狂徒")
            this.addObject("age", "张三")

            /* html 中不存在*/
            this.addObject("extra", "you know")
            this.addObject("user", User("As", 12))
            this.viewName = "/returnInfo/returnMav" //页面跳转并传值
        }

    }

    /*Error resolving template [returnInfo/returnBean], template might not exist or might
   not be accessible by any of the configured Template Resolvers",*/
    @RequestMapping(value = ["/returnBean"])
    @ResponseBody
    fun returnBean(): Stu {
        LogTools.LogPrintln(Stu("As", 3, 3), 42)
        LogTools.LogPrintln(User("As", 3), 41)
        return Stu("As", 3, 3)
    }
}