package WsyBBs.acount.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import WsyBBs.acount.entity.Acount;
import WsyBBs.api.vo.acount.AcountCondition;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
public interface AcountMapper extends BaseMapper<Acount> {
	public List<Acount> queryByCondition(AcountCondition acountCondition);
}
