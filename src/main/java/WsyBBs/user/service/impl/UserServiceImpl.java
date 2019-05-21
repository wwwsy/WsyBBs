package WsyBBs.user.service.impl;

import WsyBBs.user.entity.User;
import WsyBBs.user.mapper.UserMapper;
import WsyBBs.user.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
