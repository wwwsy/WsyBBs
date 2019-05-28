package WsyBBs.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import WsyBBs.acount.entity.Acount;
import WsyBBs.acount.service.IAcountService;
import WsyBBs.api.vo.acount.AcountCondition;
import WsyBBs.common.domain.ResultValue;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
@RestController
@RequestMapping("/acount/acount")
public class AcountController {
	@Autowired
	private IAcountService acountService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/acount", method = RequestMethod.GET)
	public ResultValue<Object> getAcounts(AcountCondition acountCondition) {
		List<Acount> acounts = acountService.queryByCondition(acountCondition);
		if (acounts.size() == 0) {
			return new ResultValue(-1, "无记录");
		} else {
			return new ResultValue(acounts, 1);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/acount", method = RequestMethod.POST)
	public ResultValue insert(@RequestBody Acount acount) {
		ResultValue resultValue = acountService.insert(acount) ? new ResultValue(1, "更新成功")
				: new ResultValue(-1, "更新失败");
		return resultValue;
	}
}
