package WsyBBs.api.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import WsyBBs.common.domain.ResultValue;
import WsyBBs.common.util.RedisUtil;
import WsyBBs.security.anno.UnAuth;
import WsyBBs.security.model.UserModel;
import WsyBBs.user.entity.Auth;
import WsyBBs.user.entity.Group;
import WsyBBs.user.entity.User;
import WsyBBs.user.service.IAuthService;
import WsyBBs.user.service.IGroupService;
import WsyBBs.user.service.IUserService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-05
 */
@RestController
@RequestMapping("/user/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private IGroupService groupService;
	@Autowired
	private IAuthService authService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	@UnAuth
	public ResultValue<UserModel> login(@RequestBody Map params) {
		String username = MapUtils.getString(params, "username");
		String password = MapUtils.getString(params, "password");
		User user = userService.selectOne(new EntityWrapper<User>().eq("user_name", username));
		if (user != null) {
			if (user.getUserPassword().equals(password)) {
				UserModel userModel = new UserModel();
				Group group = groupService.getGroupByUser(user.getUserId());
				List<Auth> auths = authService.getAuthsByGroup(group.getGroupId());
				String token = UUID.randomUUID().toString().replace("-", "");
				userModel.setAuth(auths);
				userModel.setGroup(group);
				userModel.setToken(token);
				userModel.setUser(user);
				redisUtil.lSet(token, userModel, 600);
				return new ResultValue<UserModel>(userModel, 1);
			} else {
				return new ResultValue(0, "用户名或密码错误");
			}
		} else {
			return new ResultValue(0, "用户名或密码错误");
		}
	}
}
