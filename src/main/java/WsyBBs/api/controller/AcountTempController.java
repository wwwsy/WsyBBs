package WsyBBs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import WsyBBs.acount.entity.AcountTemp;
import WsyBBs.acount.service.IAcountTempService;
import WsyBBs.api.vo.acountTemp.AcountTempCondition;
import WsyBBs.common.domain.ResultValue;
import WsyBBs.common.util.DateUtils;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
@RestController
@RequestMapping("/acount/acountTemp")
public class AcountTempController {
	@Autowired
	private IAcountTempService acountTempService;

	@RequestMapping(value = "/acountTemp", method = RequestMethod.POST)
	public ResultValue<Object> insertAcountTemp(@RequestBody AcountTempCondition acountTempCondition) {
		AcountTemp acountTemp = new AcountTemp();
		acountTemp.setAtDescription(acountTempCondition.getAcountDes());
		acountTemp.setAtNum(acountTempCondition.getAcountCost());
		acountTemp.setAtTime(DateUtils.frontStringToDefaultString(acountTempCondition.getDate()));
		acountTemp.setAtRecord(acountTempCondition.getUserId());
		acountTemp.setAtRecordTime(DateUtils.todayToDefaultString());
		boolean flag = acountTempService.insert(acountTemp);
		return flag ? new ResultValue<Object>(1, "保存成功") : new ResultValue<Object>(-1, "fail");
	}

	@RequestMapping(value = "/acountTemp", method = RequestMethod.GET)
	public ResultValue<Object> queryByCondition(Integer userId) {
		List<AcountTemp> list = acountTempService.selectList(new EntityWrapper<AcountTemp>().ne("at_record", userId));
		return new ResultValue<Object>(list, 1);
	}

	@RequestMapping(value = "/tempBack", method = RequestMethod.POST)
	public ResultValue<Object> tempToBack(@RequestBody AcountTempCondition acountTempCondition) {
		boolean flag = acountTempService.tempToBack(acountTempCondition.getIds(), acountTempCondition.getUserId());
		return flag ? new ResultValue<Object>(1, "操作成功") : new ResultValue<Object>(-1, "操作失败");
	}

	@RequestMapping(value = "/tempAcount", method = RequestMethod.POST)
	public ResultValue<Object> tempToAcount(@RequestBody AcountTempCondition acountTempCondition) {
		boolean flag = acountTempService.tempToAcount(acountTempCondition.getIds(), acountTempCondition.getUserId());
		return flag ? new ResultValue<Object>(1, "操作成功") : new ResultValue<Object>(-1, "操作失败");
	}

}
