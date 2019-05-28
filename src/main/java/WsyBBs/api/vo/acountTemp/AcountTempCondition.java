package WsyBBs.api.vo.acountTemp;

import java.util.List;

import WsyBBs.common.supers.CommonVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AcountTempCondition extends CommonVo {
	private Integer acountCost;
	private String acountDes;
	private String date;
	private Integer userId;
	private List<Integer> ids;
}
