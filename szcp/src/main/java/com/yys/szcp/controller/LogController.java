package com.yys.szcp.controller;


import com.yys.szcp.constant.ExceptionConstant;
import com.yys.szcp.service.DbLogService;
import com.yys.szcp.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "日志模块")
@Controller
@RequestMapping("sys/log")
public class LogController {
	
	@Autowired
	private DbLogService logServiceImpl;
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page",value = "当前页",required = true),
			@ApiImplicitParam(name = "limit",value = "每页条数",required = true)
	})
	@RequestMapping(value = "getLogList",method = RequestMethod.GET)
	@ResponseBody
	public ResultUtil getLogList(Integer page, Integer limit){
		ResultUtil resultUtil=new ResultUtil();
		Map map=new HashMap();
		map.put("limit",limit);
		map.put("page",limit);
		resultUtil.setCode(ExceptionConstant.SUCCESS_HTTPREUQEST);
		resultUtil.setCount(logServiceImpl.findLogListCount(map));
		resultUtil.setData(logServiceImpl.findLogList(map));
		return resultUtil;
	}
}
