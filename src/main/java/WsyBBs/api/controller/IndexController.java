package WsyBBs.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import WsyBBs.common.domain.ResultValue;

@RequestMapping("/index/index")
@RestController
public class IndexController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ResultValue index() {
		return new ResultValue(1, "hello");
	}
}
