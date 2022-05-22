package com.eliza.spring.druid.controller.paras

import com.eliza.spring.library.model.User
import com.eliza.spring.library.utils.LogTools
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest


@Controller
@RequestMapping("/parasUrl")
class GetParasUrl {
    //    /parasUrl/getFromWeb.html
    /**
     * /parasUrl/getModelAttribute
     * 使用 ModelAttribute 接受指定 同名参数
     * @param message String
     * @return String
     */
    //响应表单上的POST请求。//表单name 属性值 要对应
    @RequestMapping(value = ["/getModelAttribute"], method = [RequestMethod.POST, RequestMethod.GET])
    @GetMapping(value = ["/getModelAttribute"])
    fun getModelAttribute(
        @ModelAttribute(value = "message") message: String,
        @ModelAttribute(value = "name") name: String
    ) {
        LogTools.LogPrintln("message:$message", 4)
        LogTools.LogPrintln("name：$name", 4)

    }

    /**
     * parasUrl/getReqAttribute ?name=asdasd
     * 请求参数 name 不存在时会有异常发生,==>解决方案： required = false
     * @param name String
     * @return String
     */
    @RequestMapping(value = ["/getReqAttribute"], method = [RequestMethod.POST])
    @GetMapping(value = ["/getReqAttribute"])
    fun getReqAttribute(@RequestAttribute(value = "name", required = false) name: String) {
//        mercury
        LogTools.LogPrintln(name, 89)
    }


    /**
     * 必须同名参数接收
     * /parasUrl/getBean ?  name=wefsf  &  age=12
     * getBean 通过一个Bean 对象接受 数据
     * 且 接受的数据不能为 null （不可没有对应数据）==》404
     * @param User User
     * @return String
     */
    @RequestMapping("/getBean")
    fun getBean(user: User) {// 属性名要对应
        LogTools.LogPrintln("username is:" + user.name, 5)
        LogTools.LogPrintln("password is:" + user.age, 5)
    }

    /**
     * @PathVariable获取路径中的参数
     * @param name String
     * @param age String
     * @return String?
     */
    @RequestMapping(value = ["/getPathVariable/{name}/{age}"], method = [RequestMethod.GET])
    fun getPathVariable(@PathVariable name: String, @PathVariable age: String) {
        LogTools.LogPrintln("name is:$name", 87)
        LogTools.LogPrintln("age is:$age", 87)
    }

    /**
     * 使用 req 接受网页参数
     * @param req HttpServletRequest
     * @return String
     */
    @RequestMapping(value = ["/getReq"], method = [RequestMethod.POST])
    @GetMapping(value = ["/getReq"])

    fun getReq(req: HttpServletRequest) {
//        mercury
        LogTools.LogPrintln(req.parameterNames, 7)
        req.parameterMap.forEach { k, v ->
            LogTools.LogPrintln("$k ::${req.getParameter(k)}:: ${v.toString()}", 3)
        }
    }


    /**
     * 使用 RequestParam 指定需要 接受的网页参数
     * @param req HttpServletRequest
     * @return String
     */
    @RequestMapping(value = ["/getRequestParam"], method = [RequestMethod.POST])
    @GetMapping(value = ["/getRequestParam"])
    fun getRequestParam(@RequestParam(name = "cat") cat: String) {
        LogTools.LogPrintln(cat, 5)
    }


}