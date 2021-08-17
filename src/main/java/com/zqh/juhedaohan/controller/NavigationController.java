package com.zqh.juhedaohan.controller;

import com.zqh.juhedaohan.business.NavigationBizService;
import com.zqh.juhedaohan.dto.LinkGroup;
import com.zqh.juhedaohan.dto.RestResult;
import com.zqh.juhedaohan.entity.LinkEntity;
import com.zqh.juhedaohan.entity.SearchEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author zhangqh
 * @date 2021/7/27 0027 17:32
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class NavigationController {

    private final NavigationBizService navigationBizService;

    @RequestMapping("/ideaKeys")
    public String key() {
        return "portal/ideakeys";
    }

    @RequestMapping(value = {"/","/index"})
    public String index(Model model) {
        List<LinkGroup> linkGroups = navigationBizService.findLinkGroups();
        model.addAttribute("linkGroups",linkGroups);
        return "portal/index";
    }

    @RequestMapping("/searchList")
    @ResponseBody
    public RestResult searchList() {
        List<SearchEntity> searchList = navigationBizService.findSearchList();
        return RestResult.buildSuccess(searchList);
    }


}
