package com.qdch.xd.controller;

import com.qdch.core.BaseController;
import com.qdch.xd.model.RiskEventHistoryModel;
import com.qdch.xd.model.RiskEventModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
* @author doushuihai  
* @date 2018年3月30日下午1:07:26  
* @TODO 风险管理-风险事件查看
 */
public class EventViewController extends BaseController {

	private RiskEventModel riskEventModel =  RiskEventModel.dao;
	private RiskEventHistoryModel riskEventHistoryModel = RiskEventHistoryModel.dao;

	/**
	 * 
	* @author doushuihai  
	* @date 2018年3月30日下午1:08:45  
	* @TODO 风险事件查看
	 */
	public void index() {
		 render("xd/pages/05_02fengxianshijianchakan.html");
	}

	/**
	 * 查看--弹出框--处理历史
	 */
	public void  getPopUp(){
		Map<String,Object> result = new HashMap<String,Object>();
		RiskEventModel event = riskEventModel.findById(getPara("id"));
		List<RiskEventHistoryModel> historyModels  = riskEventHistoryModel.getByRiskEvent(getPara("id"));
		result.put("risk",event);
		result.put("history",historyModels);
		mRenderError(result);

	}
	

}
