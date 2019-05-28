package WsyBBs.api.vo.acount;

import WsyBBs.common.supers.CommonVo;
import lombok.Data;

@Data
public class AcountCondition extends CommonVo {
	private String startDate;
	private String endDate;
	private Integer userId;
	private String des;
}
