package com.yys.szcp.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.yys.szcp.entity.MachineEquipment;
import com.yys.szcp.mapper.MachineEquipmentMapper;
import com.yys.szcp.service.EquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private MachineEquipmentMapper machineEquipmentMapper;

    @Override
    public void active(MachineEquipment equipment) throws Exception {
        equipment.setActiveTime(new Date());
        equipment.setBindTime(new Date());
        String equipId= DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN)+RandomUtil.randomNumbers(5);
        equipment.setEquipId(equipId);
        Integer result = machineEquipmentMapper.insert(equipment);
        if(result<1){
            throw new Exception("激活失败");
        }
    }
}
