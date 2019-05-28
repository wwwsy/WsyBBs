package WsyBBs.acount.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import WsyBBs.acount.entity.Acount;
import WsyBBs.acount.mapper.AcountMapper;
import WsyBBs.acount.service.IAcountService;
import WsyBBs.api.vo.acount.AcountCondition;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
@Service
public class AcountServiceImpl extends ServiceImpl<AcountMapper, Acount> implements IAcountService {

	@Override
	public List<Acount> queryByCondition(AcountCondition acountCondition) {
		// TODO Auto-generated method stub
		return baseMapper.queryByCondition(acountCondition);
	}

}
