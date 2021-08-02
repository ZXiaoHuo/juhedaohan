package com.zqh.juhedaohan.controller;

import com.zqh.juhedaohan.dto.RestResult;
import com.zqh.juhedaohan.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangqh
 * @date 2021/8/2 0002 11:37
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {


    @RequestMapping("/login.html")
    public String toLogin() {
        return "manager/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public RestResult login(UserEntity user, Model model) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return RestResult.buildError("用户名密码不能为空");
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
//            subject.checkRole("admin");
//            subject.checkPermissions("query", "add");
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e);
            //model.addAttribute("msg","用户不存在");
            return RestResult.buildError("用户不存在");
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e);
            //model.addAttribute("msg","账号或密码错误");
            return RestResult.buildError("账号或密码错误");
        } catch (AuthorizationException e) {
            log.error("没有权限！", e);
           // model.addAttribute("msg","无权限，请联系管理员");
            return RestResult.buildError("无权限，请联系管理员");
        }
        return RestResult.buildSuccess();
    }

    @RequestMapping("/logout")
    public String logout(){
        return "/";
    }


}
