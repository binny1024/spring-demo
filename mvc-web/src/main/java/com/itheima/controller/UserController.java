package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 类似于在这里面设置指定路由的监听函数
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 多文件上传
     * @param username
     * @param uploadFile
     * @throws IOException
     */
    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("/Users/binny/IdeaProjects/spring-demo/" + originalFilename));
        }
    }

    /**
     * 文件上传
     *
     * @param username
     * @param uploadFile
     * @param uploadFile2
     * @throws IOException
     */
    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile, MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        System.out.println(originalFilename);
        uploadFile.transferTo(new File("/Users/binny/IdeaProjects/spring-demo/" + originalFilename));
        String originalFilename2 = uploadFile2.getOriginalFilename();
        System.out.println(originalFilename2);
        uploadFile2.transferTo(new File("/Users/binny/IdeaProjects/spring-demo/" + originalFilename2));
    }

    /**
     *
     * 获得请求头
     *
     *
     * 使用@CookieValue可以获得指定C ookie的值
     * @CookieValue注解的属性如下：
     * value：指定cookie的名称
     * required：是否必须携带此cookie
     *
     * @param jsessionId
     * @throws IOException
     */
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        System.out.println(jsessionId);
    }

    /**
     * 获得请求头  @RequestHeader
     * 使用@RequestHeader可以获得请求头信息，相当于web阶段学习的request.getHeader(name)
     * @RequestHeader注解的属性如下：
     * value：请求头的名称
     * required：是否必须携带此请求头
     *
     * @param user_agent
     * @throws IOException
     */
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_agent) throws IOException {
        System.out.println(user_agent);
    }


    /**
     * 获得Servlet相关API
     *
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    /**
     * 自定义类型转换器
     *
     * @param date
     * @throws IOException
     */
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }

    /**
     * Restful 风格
     * 在SpringMVC中可以使用占位符进行参数绑定。
     * 地址/user/1可以写成/user/{id}，占位符{id}对应的就是1的值。
     * 在业务方法中我们可以使用 @PathVariable 注解进行占位符的匹配获取工作
     * <p>
     * 比如,下面的 @PathVariable(value = "name") String username 就是将{name}的值给函数的参数 username
     *
     * @param username
     * @throws IOException
     */
    // localhost:8080/user/quick17/zhangsan
    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "name") String username) throws IOException {
        System.out.println(username);
    }

    /**
     * 参数绑定注解
     *
     * @param username
     * @throws IOException
     */
    @RequestMapping(value = "/quick16")
    @ResponseBody //参数绑定注解 ,带有配置参数,参数映射,是否必须,默认值
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "itcast") String username) throws IOException {
        System.out.println(username);
    }

    /**
     * 案例 : ajax.jsp
     *
     * @param userList
     * @throws IOException
     */
    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    /**
     * 将表单{@link ./mvc-data/src/main/webapp/form.jsp}中的数据封装到集合中去
     * http://localhost:8081/form.jsp
     * 封装集合类型的请求参数
     *
     * @param vo
     * @throws IOException
     */
    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {
        System.out.println(vo);
    }


    /**
     * 封装数组
     * <p>
     * 将字符创类型的请求参数封装到数组中,数组组名由该路由函数的参数决定
     * 形如:http://localhost:8081/user/quick13?strs=xubibin&strs=28
     *
     * @param strs 数组的名称
     * @throws IOException
     */
    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    /**
     * 封装请求参数到实体中
     * <p>
     * 自动将求参数封装到实体中,要求:请求携带的请求参数的名字与实体中的名字一样
     *
     * @param user {@link User}
     * @throws IOException
     */
    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    /**
     * 传递请求参数
     * <p>
     * 请求参数 默认 get 请求
     *
     * @param username 用户名
     * @param age      用户密码
     * @throws IOException
     */
    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    /**
     * 自动将User转换成json格式的字符串
     *
     * @return 自动转换为 json
     * @throws IOException
     */
    @RequestMapping(value = "/quick10")
    @ResponseBody //期望SpringMVC自动将User转换成json格式的字符串
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisi2");
        user.setAge(32);

        return user;
    }

    /**
     * @return 返回指定格式的数据, 组装数据
     * @throws IOException
     */
    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json的转换工具将对象转换成json格式字符串在返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    /**
     * @return 返回指结构式的字符串, 比如json字符串
     * @throws IOException
     */
    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() throws IOException {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    /**
     * @return 直接返回数据, 不做视图(页面)跳转
     * @throws IOException
     */
    @RequestMapping(value = "/quick7")
    @ResponseBody  //告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String save7() throws IOException {
        return "hello itheima";
    }

    /**
     * @param response 相应对象
     * @throws IOException
     */
    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcast");
    }

    /**
     * @param request 请求对象
     * @return
     */
    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "酷丁鱼");
        return "success";
    }

    /**
     * @param model 由调用者传递过来
     * @return
     */
    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "博学谷");
        return "success";
    }

    /**
     * @param modelAndView 由调用者传递过来
     * @return
     */
    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }


    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        /*
            Model:模型 作用封装数据
            View：视图 作用展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据,可供JSP使用
        modelAndView.addObject("username", "itcast");
        //设置视图名称
        modelAndView.setViewName("success");

        return modelAndView;
    }

    // 请求地址  http://localhost:8080/user/quick
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running....");
        return "success";
    }

}
