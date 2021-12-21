package com.yys.szcp.mapper;

import com.yys.szcp.entity.MachineProduct;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gaoliqiang
* @description 针对表【machine_product(产品信息表)】的数据库操作Mapper
* @createDate 2021-12-21 09:36:19
* @Entity com.yys.szcp.entity.MachineProduct
*/
@Mapper
public interface MachineProductMapper extends BaseMapper<MachineProduct> {


}