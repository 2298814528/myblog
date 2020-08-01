package com.zjj.myblog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjj.myblog.entity.User;
import com.zjj.myblog.entity.Userlog;
import com.zjj.myblog.entity.Usersign;
import com.zjj.myblog.service.UserService;
import com.zjj.myblog.service.UserlogService;
import com.zjj.myblog.service.UsersignService;
import com.zjj.myblog.utils.CheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 登录表 前端控制器
 * </p>
 *
 * @author author
 * @since 2020-07-14
 */
@Controller
public class UserlogController {
    @Autowired
    UserService userService;
    @Autowired
    UserlogService userlogService;
    @Autowired
    UsersignService usersignService;
    @Autowired
    CheckCode checkCode;

    /**
     * 登录跳转
     *
     * @return
     */
    @RequestMapping("/login")
    public String loginHtml() {
        return "user/login";
    }

    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/loginUser")
    public String login(String username, String password, HttpSession session) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>().eq("username", username).eq("password", password);
        User user = userService.getOne(userQueryWrapper);
        if (user == null) {
            session.setAttribute("error","账号、密码错误");
            return "user/login";
        } else {
            session.removeAttribute("error");
//            插入登录表
            Userlog userlog = new Userlog();
            userlog.setLogTime(Timestamp.valueOf(LocalDateTime.now()));
            userlog.setUser(username);
            userlogService.save(userlog);
//            修改用户表最后一次登录、状态
            LocalDateTime now = LocalDateTime.now();
            Timestamp lasted = Timestamp.valueOf(now);
            User userUpdate = new User();
            userUpdate.setLasted(lasted);
            userUpdate.setStatus(1);
            QueryWrapper<User> userLast = new QueryWrapper<User>().eq("username", username);
            userService.update(userUpdate,userLast);
//            判断是否签到
            QueryWrapper<Usersign> userSign = new QueryWrapper<Usersign>().eq("user", username).eq("signTime", LocalDate.now());
            Map<String, Object> map = usersignService.getMap(userSign);
            if (map == null) {
//                未签到
                session.setAttribute("signIn", "0");
            } else {
//                签到了
                session.setAttribute("signIn", "1");
            }
//            累计签到天数
            int dayCount = usersignService.count(new QueryWrapper<Usersign>().eq("user", username));
//            传入前端累计登陆天数
            session.setAttribute("day", dayCount);
//            传入前端用户名
            session.setAttribute("username", username);
            session.setAttribute("user",user);
////            传入前端头像位置
//            session.setAttribute("avatar", user.getAvatar());
////            传入VIP等级
//            session.setAttribute("vipLevel", "VIP" + user.getVipLevel());
////            传入前端性别
//            session.setAttribute("gender",user.getGender());
////            传入前端签名
//            session.setAttribute("sign",user.getSign());
////            传入前端email
//            session.setAttribute("email",user.getEmail());
////            密码
//            session.setAttribute("password",user.getPassword());
////            微信
//            session.setAttribute("wechat",user.getWechat());
////            生日
//            session.setAttribute("birthday",user.getBirthday());
            return "redirect:/blogHome";
        }
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request) {
        Enumeration<String> attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            request.getSession().removeAttribute(attributeNames.nextElement().toString());
        }
        return "redirect:/index";
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/code")
    public void code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        checkCode = new CheckCode(120, 36, 5, 10);
        ImageIO.write(checkCode.getBuffImg(), "jpg", response.getOutputStream());
    }

    /**
     * 发送异步获取验证码
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/codes")
    public Map<String,String> codes(HttpServletRequest request) throws IOException {
        Map<String,String> map=new HashMap<String, String>();
        String code = checkCode.getCode();
        map.put("code",code);
        return map;
    }

}
