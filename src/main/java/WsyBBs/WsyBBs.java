package WsyBBs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("WsyBBs.*.mapper")
public class WsyBBs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(WsyBBs.class, args);
	}

}
