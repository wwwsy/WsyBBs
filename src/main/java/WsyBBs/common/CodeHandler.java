package WsyBBs.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码生成器
 */
public class CodeHandler {

	public static void main(String[] args) {
		CodeHandler.generateCode();
	}

	public static void generateCode() {
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir("C://Users/wangsiyuan/git/WsyBBs/src/main/java");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor("wangsiyuan");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert());
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("wsy");
		dsc.setPassword("wsy");
		dsc.setUrl("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setInclude(new String[] { "AcountTemp" }); // 需要生成的表

		// 自定义实体父类
//        strategy.setSuperEntityClass("");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] {"id_delete", "remark"});
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("");
		// 自定义 service 父类
//        strategy.setSuperServiceClass("");
//        // 自定义 service 实现类父类
//        strategy.setSuperServiceImplClass("");
//        // 自定义 controller 父类
//        strategy.setSuperControllerClass("");
		mpg.setStrategy(strategy);
		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("WsyBBs");
		pc.setModuleName("acount");
		// ====
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};

		// 自定义 xxList.jsp 生成
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

		// 调整 xml 生成目录演示
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return "C://Users/wangsiyuan/git/WsyBBs/src/main/resource/mapper" + tableInfo.getEntityName()
						+ "-mapper.xml";
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 关闭默认 xml 生成，调整生成 至 根目录
		TemplateConfig tc = new TemplateConfig();
		tc.setXml(null);
		mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();

		// 打印注入设置【可无】
		System.err.println(mpg.getCfg().getMap().get("abc"));
	}

}
