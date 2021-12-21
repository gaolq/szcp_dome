package com.yys.szcp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yys.szcp.entity.MachineGoods;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gaoliqiang
* @description 针对表【machine_goods(货物批次信息)】的数据库操作Mapper
* @createDate 2021-12-21 15:19:03
* @Entity com.yys.szcp.entity.MachineGoods
*/
@Mapper
public interface MachineGoodsMapper extends BaseMapper<MachineGoods> {


}
