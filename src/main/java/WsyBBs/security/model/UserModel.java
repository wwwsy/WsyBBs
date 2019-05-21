package WsyBBs.security.model;

import java.util.List;

import WsyBBs.user.entity.Auth;
import WsyBBs.user.entity.Group;
import WsyBBs.user.entity.User;
import lombok.Data;

@Data
public class UserModel {
	private User user;
	private Group group;
	private List<Auth> auth;
	private String token;
}
