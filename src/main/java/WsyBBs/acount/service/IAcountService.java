package WsyBBs.acount.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import WsyBBs.acount.entity.Acount;
import WsyBBs.api.vo.acount.AcountCondition;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
public interface IAcountService extends IService<Acount> {
	public List<Acount> queryByCondition(AcountCondition acountCondition);
}
