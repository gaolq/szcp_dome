package com.yys.szcp.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.yys.szcp.entity.DbAdminUser;
import com.yys.szcp.entity.DbMenu;
import com.yys.szcp.entity.DbRoleMenu;
import com.yys.szcp.entityVo.MenuManageTree;
import com.yys.szcp.entityVo.MenuManageTreeUtil;
import com.yys.szcp.entityVo.MenuToRoleTree;
import com.yys.szcp.entityVo.MenuToRoleTreeUtil;
import com.yys.szcp.service.DbMenuService;
import com.yys.szcp.utils.IViewIcon;
import com.yys.szcp.utils.ResultUtil;
import com.yys.szcp.utils.StringISNULLUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Describe:
 * -------------------
 * User: yangyongsheng
 * Date: 2019/06/25 19:37:54
 * Email: 1095737364@qq.com
 */
@Api(tags = "菜单模块")
@Controller
@RequestMapping("sys/menu/")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private DbMenuService menuService;

    /**
     *  添加菜单
     * @param request
     * @param menu
     * @return
     */
    @ApiOperation("添加菜单")
    @ApiImplicitParam(name = "menu",value = "菜单json字符串",required = true)
    @RequestMapping(value = "addMenu",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil addMenu(HttpServletRequest request, String menu) {
        try {
            //封装数据
            Map menu1 =(Map) JSONUtils.parse(menu);
            DbMenu menuMy=new DbMenu();
            DbAdminUser adminUser = (DbAdminUser) request.getAttribute("adminUser");
            menuMy.setParentId(StringISNULLUtil.mapToInteger(menu1.get("parentId")));
            menuMy.setTitle(StringISNULLUtil.mapToString(menu1.get("title")));
            menuMy.setHref(StringISNULLUtil.mapToString(menu1.get("href")));
            menuMy.setIcon(StringISNULLUtil.mapToString(menu1.get("icon")));
            menuMy.setPerms(StringISNULLUtil.mapToString(menu1.get("perms")));
            menuMy.setSorting(StringISNULLUtil.mapToInteger(menu1.get("sorting")));

            //判断名称是否重复
            List<DbMenu> list=menuService.findMenuByName(null,menuMy.getParentId(),menuMy.getTitle());
            if(list!=null&& list.size()>0){
                return ResultUtil.error("添加失败,名称重复!");
            }
            //添加到数据库
            menuService.addMenu(menuMy);

            list=menuService.findMenuByName(null,menuMy.getParentId(),menuMy.getTitle());
            DbRoleMenu roleMenu=new DbRoleMenu();
            roleMenu.setRoleId(adminUser.getRoleId());
            roleMenu.setMenuId(list.get(0).getId());
            menuService.addRoleMenu(roleMenu);
            return ResultUtil.success("添加成功!");
        } catch (Exception e) {
            logger.error("添加菜单错误: " + e.getMessage());
            return ResultUtil.error("添加失败!");
        }
    }



    /**
     * 通过当前用户角色id 得到所有的菜单
     * @param request
     * @return
     */
    @ApiOperation("通过当前用户角色id 得到所有的菜单")
    @RequestMapping(value = "findMenuByMyRoleId",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil findMenuByMyRoleId(HttpServletRequest request) {
        try {
            DbAdminUser adminUser = (DbAdminUser) request.getAttribute("adminUser");

            List<DbMenu> menuList=menuService.findMenuByRoleId(adminUser.getRoleId());

            //封装数据
            List<MenuManageTree> menuManageTreeList= MenuManageTreeUtil.getMenuManageTree(menuList);
            return ResultUtil.success(menuManageTreeList);
        } catch (Exception e) {
            logger.error("查询菜单树错误: " + e.getMessage());
            return ResultUtil.error("查询失败!");
        }
    }




    /**
     * 更新菜单
     * @param request
     * @param menu
     * @return
     */
    @ApiOperation("更新菜单")
    @RequestMapping(value = "updateMenu",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil updateMenu(HttpServletRequest request, String  menu) {
        try {
            //封装数据
            Map menu1 =(Map) JSONUtils.parse(menu);
            DbMenu menuMy=new DbMenu();
            DbAdminUser adminUser = (DbAdminUser) request.getAttribute("adminUser");
            menuMy.setId(StringISNULLUtil.mapToInteger(menu1.get("id")));
            menuMy.setParentId(StringISNULLUtil.mapToInteger(menu1.get("parentId")));
            menuMy.setTitle(StringISNULLUtil.mapToString(menu1.get("title")));
            menuMy.setHref(StringISNULLUtil.mapToString(menu1.get("href")));
            menuMy.setIcon(StringISNULLUtil.mapToString(menu1.get("icon")));
            menuMy.setPerms(StringISNULLUtil.mapToString(menu1.get("perms")));
            menuMy.setSorting(StringISNULLUtil.mapToInteger(menu1.get("sorting")));

            //判断名称是否重复
            List<DbMenu> list=menuService.findMenuByName(menuMy.getId(),menuMy.getParentId(),menuMy.getTitle());
            if(list!=null&& list.size()>0){
                return ResultUtil.error("更新失败,名称重复!");
            }
            menuService.updateMenu(menuMy);
            return ResultUtil.success("更新成功!");
        } catch (Exception e) {
            logger.error("更新菜单错误: " + e.getMessage());
            return ResultUtil.error("更新失败!");
        }
    }

    /**
     * 删除菜单
     * @param request
     * @param menuId
     * @return
     */
    @ApiOperation("删除菜单")
    @RequestMapping(value = "deleteMenu",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil deleteMenu(HttpServletRequest request, Integer menuId) {
        try {

            DbMenu menuMy=new DbMenu();
            DbAdminUser adminUser = (DbAdminUser) request.getAttribute("adminUser");
            menuMy.setId(menuId);
            menuMy.setDeleteStatus(1);
            menuService.deleteMenu(menuMy);
            return ResultUtil.success("删除成功!");
        } catch (Exception e) {
            logger.error("删除菜单错误: " + e.getMessage());
            return ResultUtil.error("删除失败!");
        }
    }





    /**
     * 读取全部图标
     * @param request
     * @return
     */
    @ApiOperation("读取全部图标")
    @RequestMapping(value = "findAllIcon",method = RequestMethod.GET)
    @ResponseBody
    public ResultUtil findAllIcon(HttpServletRequest request) {
        try {
            return ResultUtil.success(IViewIcon.getAllIviewIcon());
        } catch (Exception e) {
            logger.error("查询图标错误: " + e.getMessage());
            return ResultUtil.error("查询失败!");
        }
    }

    /**
     * 通过角色id 得到所有的菜单
     * @param request
     * @param roleId
     * @return
     */
    @ApiOperation("通过角色id 得到所有的菜单")
    @RequestMapping(value = "findMenuByRoleId",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil findRoleMenuByRoleId(HttpServletRequest request, Integer roleId) {
        try {
            DbAdminUser adminUser = (DbAdminUser) request.getAttribute("adminUser");
            List<DbMenu> menuList=menuService.findMenuByRoleId(adminUser.getRoleId());
            List<DbMenu> menuListToChecked=menuService.findMenuByRoleId(roleId);

            //封装数据
            List<MenuToRoleTree> menuToRoleTrees= MenuToRoleTreeUtil.getMenuToRoleTree(menuList,menuListToChecked);
            return ResultUtil.success(menuToRoleTrees);
        } catch (Exception e) {
            logger.error("查询角色菜单树错误: " + e.getMessage());
            return ResultUtil.error("查询失败!");
        }
    }

    /**
     * 修改或者添加角色菜单
     * @param request
     * @return
     */
    @ApiOperation("修改或者添加角色菜单")
    @RequestMapping(value = "addOrEditRoleMenuByIdArray",method = RequestMethod.POST)
    @ResponseBody
    public ResultUtil addOrEditRoleMenuByIdArray(HttpServletRequest request, String  idArray, Integer myRoleId) {
        try {
            DbAdminUser adminUser = (DbAdminUser) request.getAttribute("adminUser");
            if(myRoleId.equals(adminUser.getRoleId())){
                return  ResultUtil.error("修改错误, 不能修改自己!!");
            }

            //删除菜单角色
             menuService.deleteRoleMenuByRoleId(myRoleId);
            //添加菜单角色
            String[] idList=idArray.split(",");

            for(Object object:idList){
                DbRoleMenu roleMenu=new DbRoleMenu();
                roleMenu.setMenuId(Integer.valueOf(object.toString()));
                roleMenu.setRoleId(myRoleId);
                menuService.addRoleMenu(roleMenu);
            }

            return ResultUtil.success("添加或修改成功!");
        } catch (Exception e) {
            logger.error("添加错误: " + e.getMessage());
            return ResultUtil.error("添加成功!");
        }
    }

}
