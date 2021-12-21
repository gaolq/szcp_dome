package com.yys.szcp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yys.szcp.entity.MachineVersion;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gaoliqiang
* @description 针对表【machine_version(设备版本信息)】的数据库操作Mapper
* @createDate 2021-12-21 15:19:03
* @Entity com.yys.szcp.entity.MachineVersion
*/
@Mapper
public interface MachineVersionMapper extends BaseMapper<MachineVersion> {


}
