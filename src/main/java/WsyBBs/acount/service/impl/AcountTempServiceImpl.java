package WsyBBs.acount.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import WsyBBs.acount.entity.Acount;
import WsyBBs.acount.entity.AcountBack;
import WsyBBs.acount.entity.AcountTemp;
import WsyBBs.acount.mapper.AcountTempMapper;
import WsyBBs.acount.service.IAcountBackService;
import WsyBBs.acount.service.IAcountService;
import WsyBBs.acount.service.IAcountTempService;
import WsyBBs.common.util.DateUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangsiyuan
 * @since 2019-05-21
 */
@Service
public class AcountTempServiceImpl extends ServiceImpl<AcountTempMapper, AcountTemp> implements IAcountTempService {
	@Autowired
	private IAcountBackService acountBackService;
	@Autowired
	private IAcountService acountService;

	@Override
	@Transactional
	public boolean tempToBack(List<Integer> ids, Integer userId) {
		List<AcountBack> acountBacks = new ArrayList<>();
		List<AcountTemp> acountTemps = baseMapper.selectBatchIds(ids);
		for (Iterator<AcountTemp> iterator = acountTemps.iterator(); iterator.hasNext();) {
			AcountTemp acountTemp = iterator.next();
			AcountBack acountBack = new AcountBack();
			acountBack.setAbBacktime(DateUtils.todayToDefaultString());
			acountBack.setAbBack(userId);
			acountBack.setAbDescription(acountTemp.getAtDescription());
			acountBack.setAbNum(acountTemp.getAtNum());
			acountBack.setAbTime(acountTemp.getAtTime());
			acountBacks.add(acountBack);
		}
		boolean flag = acountBackService.insertBatch(acountBacks);
		Integer integer = baseMapper.deleteBatchIds(ids);
		return flag && integer == 1;
	}

	@Override
	@Transactional
	public boolean tempToAcount(List<Integer> ids, Integer userId) {
		List<Acount> acounts = new ArrayList<>();
		List<AcountTemp> acountTemps = baseMapper.selectBatchIds(ids);
		for (Iterator<AcountTemp> iterator = acountTemps.iterator(); iterator.hasNext();) {
			AcountTemp acountTemp = iterator.next();
			Acount acount = new Acount();
			acount.setAcountAck(userId);
			acount.setAcountAcktime(DateUtils.todayToDefaultString());
			acount.setAcountDate(acountTemp.getAtTime());
			acount.setAcountDescription(acountTemp.getAtDescription());
			acount.setAcountNum(acountTemp.getAtNum());
			acount.setAcountRecord(acountTemp.getAtRecord());
			acount.setAcountRecordtime(acountTemp.getAtRecordTime());
			acounts.add(acount);
		}
		boolean flag = acountService.insertBatch(acounts);
		Integer integer = baseMapper.deleteBatchIds(ids);
		return flag && integer == 1;
	}

}
