package com.yys.szcp.controller;

import com.yys.szcp.config.jwt.JwtIgnore;
import com.yys.szcp.entity.MachineEquipment;
import com.yys.szcp.service.EquipmentService;
import com.yys.szcp.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "设备模块")
@RestController
@RequestMapping("quipment")
public class EquipMentController {

    @Resource
    private EquipmentService equipmentService;

    @JwtIgnore
    @ApiOperation("设备激活绑定接口")
    @PostMapping("active")
    @ResponseBody
    public ResultUtil active(@RequestBody  MachineEquipment equipment){
        try {
            equipmentService.active(equipment);
            return ResultUtil.success("设备激活成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getMessage());
        }

    }
}
