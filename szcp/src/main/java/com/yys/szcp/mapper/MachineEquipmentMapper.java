package com.yys.szcp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yys.szcp.entity.MachineEquipment;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gaoliqiang
* @description 针对表【machine_equipment(设备信息)】的数据库操作Mapper
* @createDate 2021-12-21 09:36:19
* @Entity com.yys.szcp.entity.MachineEquipment
*/
@Mapper
public interface MachineEquipmentMapper extends BaseMapper<MachineEquipment> {


}
