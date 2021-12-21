package com.yys.szcp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yys.szcp.entity.MachineCustomer;
import org.apache.ibatis.annotations.Mapper;

/**
* @author gaoliqiang
* @description 针对表【machine_customer(客户信息表)】的数据库操作Mapper
* @createDate 2021-12-21 15:19:03
* @Entity com.yys.szcp.entity.MachineCustomer
*/
@Mapper
public interface MachineCustomerMapper extends BaseMapper<MachineCustomer> {


}
