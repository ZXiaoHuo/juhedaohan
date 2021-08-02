package com.zqh.juhedaohan.controller;

import com.zqh.juhedaohan.business.AdminBizService;
import com.zqh.juhedaohan.dto.DataTable;
import com.zqh.juhedaohan.dto.PageResponse;
import com.zqh.juhedaohan.dto.RestResult;
import com.zqh.juhedaohan.entity.LinkEntity;
import com.zqh.juhedaohan.entity.SearchEntity;
import com.zqh.juhedaohan.entity.TypeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @author zhangqh
 * @date 2021/7/26 0026 16:37
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminBizService adminBizService;

    /**
     *###############
     * ###管理首页####
     *##############
     */
    @RequiresRoles("admin")
    @RequestMapping
    public String index() {
        return "manager/index";
    }

    /**
     *###############
     * ###链接类型####
     *##############
     */
    @RequiresRoles("admin")
    @RequestMapping("/type")
    public String typeIndex() {
        return "manager/type/index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/type/dataTable")
    @ResponseBody
    public DataTable<TypeEntity> typeTable(Integer pageNumber, Integer pageSize) {
        PageRequest of = PageRequest.of(pageNumber - 1, pageSize);
        Page<TypeEntity> page = adminBizService.findTypeByPage(of);
        List<TypeEntity> content = page.getContent();
        return new DataTable<>(content,(int)page.getTotalElements());
    }

    /*============================================================================================*/
    @RequestMapping("/type/add")
    public String typeAdd() {
        return "manager/type/add";
    }

    @RequestMapping("/type/doAdd")
    @ResponseBody
    public RestResult doTypeAdd(TypeEntity typeEntity) {
        try {
            if (typeEntity.getEnabled()==null) {
                typeEntity.setEnabled(false);
            }
            adminBizService.addType(typeEntity);
            return RestResult.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return RestResult.buildError();
        }
    }
    /*===========================================================================================*/

    @RequiresRoles("admin")
    @RequestMapping("/type/templet")
    public String typeTemplet(Long id, Model model) {
        if (id != null) {
            try {
                TypeEntity typeById = adminBizService.findTypeById(id);
                model.addAttribute("type",typeById);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "manager/type/templet";
    }

    @RequiresRoles("admin")
    @RequestMapping("/type/addOrUpdate")
    @ResponseBody
    public RestResult typeAddOrUpdate(TypeEntity typeEntity) {
        /*if (typeEntity.getEnabled()==null) {
            typeEntity.setEnabled(false);
        }*/
        try {
            adminBizService.addOrUpdateType(typeEntity);
            return RestResult.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return RestResult.buildError();
        }
    }

    /**
     *###############
     * ###链接   ####
     *##############
     */
    @RequiresRoles("admin")
    @RequestMapping("/link")
    public String linkIndex() {
        return "manager/link/index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/link/dataTable")
    @ResponseBody
    public DataTable<LinkEntity> linkTable(Integer pageNumber, Integer pageSize) {
        PageRequest of = PageRequest.of(pageNumber - 1, pageSize);
        Page<LinkEntity> page = adminBizService.findLinkByPage(of);
        List<LinkEntity> content = page.getContent();
        return new DataTable<>(content,(int)page.getTotalElements());
    }

    @RequiresRoles("admin")
    @RequestMapping("/link/templet")
    public String LinkTemplet(Long id, Model model) {
        if(id != null) {
            try {
                LinkEntity linkById = adminBizService.findLinkById(id);
                model.addAttribute("link",linkById);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<TypeEntity> typeList = adminBizService.findTypeList();
        model.addAttribute("types",typeList);
        return "manager/link/templet";
    }

    @RequiresRoles("admin")
    @RequestMapping("/link/addOrUpdate")
    @ResponseBody
    public RestResult linkAddOrUpdate(LinkEntity linkEntity) {
        /*if (linkEntity.getEnabled()==null) {
            linkEntity.setEnabled(true);
        }*/
        try {
            adminBizService.addOrUpdateLink(linkEntity);
            return RestResult.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return RestResult.buildError();
        }
    }

    /**
     *###############
     * ###搜索源  ####
     *##############
     */
    @RequiresRoles("admin")
    @RequestMapping("/search")
    public String searchIndex() {
        return "manager/search/index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/search/dataTable")
    @ResponseBody
    public DataTable<SearchEntity> searchTable(Integer pageNumber, Integer pageSize) {
        PageRequest of = PageRequest.of(pageNumber - 1, pageSize);
        Page<SearchEntity> page = adminBizService.findSearchByPage(of);
        List<SearchEntity> content = page.getContent();
        return new DataTable<>(content,(int)page.getTotalElements());
    }

    @RequiresRoles("admin")
    @RequestMapping("/search/templet")
    public String searchTemplet(Long id, Model model) {
        if (id != null) {
            try {
                SearchEntity searchById = adminBizService.findSearchById(id);
                model.addAttribute("search",searchById);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "manager/search/templet";
    }

    @RequiresRoles("admin")
    @RequestMapping("/search/addOrUpdate")
    @ResponseBody
    public RestResult searchAddOrUpdate(SearchEntity searchEntity) {
        /*if (searchEntity.getEnabled()==null) {
            searchEntity.setEnabled(true);
        }*/
        try {
            adminBizService.addOrUpdateSearch(searchEntity);
            return RestResult.buildSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            return RestResult.buildError();
        }
    }
}
