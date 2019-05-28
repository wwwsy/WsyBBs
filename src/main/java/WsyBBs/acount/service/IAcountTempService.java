package WsyBBs.acount.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import WsyBBs.acount.entity.AcountTemp;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
public interface IAcountTempService extends IService<AcountTemp> {
	public boolean tempToBack(List<Integer> ids, Integer userId);

	public boolean tempToAcount(List<Integer> ids, Integer userId);
}
