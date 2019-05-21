package WsyBBs.security.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import WsyBBs.common.domain.ResultValue;
import WsyBBs.common.util.RedisUtil;
import WsyBBs.security.anno.UnAuth;
import WsyBBs.security.model.UserModel;
import WsyBBs.user.entity.Auth;

@Aspect
@Component
public class RightInterceptor {
	@Autowired
	private RedisUtil redisUtil;

	@Around("execution(public * WsyBBs.api.controller.*.*(..))")
	public Object around(ProceedingJoinPoint point) {
		Method method = getMethod(point);
		Object[] args = point.getArgs();
		StringBuilder sb = new StringBuilder();
		if (verify(method)) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			String token = request.getParameter("token");
			if (token == null) {
				return new ResultValue(-1, "非法登录");
			}
			UserModel userModel = (UserModel) redisUtil.lGetIndex(token, 0);
			if (userModel == null) {
				return new ResultValue(0, "未登录");
			}
			boolean flag = false;
			RequestMapping annotation = point.getTarget().getClass().getAnnotation(RequestMapping.class);
			sb.append(annotation.value()[0]);
			RequestMapping mapping = method.getAnnotation(RequestMapping.class);

			sb.append(method.getAnnotation(RequestMapping.class).value()[0]);
			List<Auth> auths = userModel.getAuth();
			for (Iterator<Auth> iterator = auths.iterator(); iterator.hasNext();) {
				Auth auth = iterator.next();
				if (sb.toString().indexOf(auth.getAuthRight()) != -1) {
					flag = true;
				}
			}
			if (flag) {
				return new ResultValue(0, "权限不足");
			}
		}
		try {
			return point.proceed(args);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			return e;
		}
	}

	private Method getMethod(ProceedingJoinPoint point) {
		String methodName = point.getSignature().getName();
		Class<?>[] par = ((MethodSignature) point.getSignature()).getParameterTypes();
		try {
			Method method = point.getTarget().getClass().getMethod(methodName, par);
			return method;
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private boolean verify(Method method) {
		UnAuth annotation = method.getAnnotation(UnAuth.class);
		for (Annotation a : method.getAnnotations()) {
			System.out.println(a.toString());
		}
		return annotation == null;
	}
}
