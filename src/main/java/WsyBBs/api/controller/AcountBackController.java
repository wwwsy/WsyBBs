package WsyBBs.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import WsyBBs.acount.service.IAcountBackService;
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
@RequestMapping("/acount/acountBack")
public class AcountBackController {
	@Autowired
	private IAcountBackService acountBackService;

	@RequestMapping(value = "acountBack", method = RequestMethod.POST)
	public ResultValue<Object> saveAcountBack() {
		return null;
	}
}
