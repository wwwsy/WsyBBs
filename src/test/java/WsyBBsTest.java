import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import WsyBBs.WsyBBs;
import WsyBBs.acount.entity.AcountTemp;
import WsyBBs.acount.mapper.AcountTempMapper;
import WsyBBs.acount.service.IAcountTempService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WsyBBs.class)
public class WsyBBsTest {
	@Autowired
	private IAcountTempService acountTempMapper;
	@Autowired
	private AcountTempMapper aw;

	@Test
	public void test01() {
		AcountTemp aTemp = new AcountTemp();
		aTemp.setAtDescription("1");
		aTemp.setAtNum(1);
		aTemp.setAtRecord(1);
		aTemp.setAtTime("20190523");
		boolean insert = acountTempMapper.insert(aTemp);
		System.out.println(insert);
	}

	@Test
	public void test02() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		aw.deleteBatchIds(list);
		System.out.println(12);
	}
}
