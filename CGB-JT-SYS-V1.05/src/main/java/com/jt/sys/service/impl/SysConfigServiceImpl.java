package com.jt.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.exception.ServiceException;
import com.jt.common.vo.PageObject;
import com.jt.sys.dao.SysConfigDao;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Autowired
	private SysConfigDao sysConfigDao;
	@Override
	
	public int updateObject(SysConfig entity) {
		if(entity==null)
		throw new ServiceException("瀵硅薄涓嶈兘涓虹┖");
		if(entity.getName()==null)
		throw new ServiceException("瀵硅薄鍚嶄笉鑳戒负绌�");
		if(entity.getValue()==null)
		throw new ServiceException("瀵硅薄鍊间笉鑳戒负绌�");
		int sysRows=sysConfigDao.updateObject(entity);
		return sysRows;
	}
	@Override
	public int saveObject(SysConfig entity) {
		if(entity==null)
		throw new ServiceException("瀵硅薄涓嶈兘涓虹┖");
		if(entity.getName()==null)
		throw new ServiceException("瀵硅薄鍚嶄笉鑳戒负绌�");
		if(entity.getValue()==null)
		throw new ServiceException("瀵硅薄鍊间笉鑳戒负绌�");
		int sysRows=sysConfigDao.insertObject(entity);
		return sysRows;
	}
	@Override
	public int deleteObjedcts(String ids) {
		if(StringUtils.isEmpty(ids))
		throw new ServiceException("璇峰厛閫夋嫨");
		int rows=sysConfigDao.deleteObjects(ids.split(","));
		if(rows==0)
		throw new ServiceException("鏁版嵁鍙兘宸茬粡涓嶅瓨鍦�");
		return rows;
	}
	@Override
	public PageObject<SysConfig> findPageObjects(
			Integer pageCurrent,String name) {
		//1.鏌ヨ鎬昏褰曟暟
		int rowCount=sysConfigDao.getRowCount(name);
		if(rowCount==0)
		throw new ServiceException("娌℃湁璁板綍");
	    //2.鏌ヨ褰撳墠椤佃褰�
		//2.1瀹氫箟椤甸潰澶у皬(姣忛〉鏈�澶氱幇瀹炲灏戞潯璁板綍)
		int pageSize=3;
		//2.2璁＄畻褰撳墠椤典綅缃�
		if(pageCurrent==null||pageCurrent<=0)
		throw new ServiceException("褰撳墠椤电爜涓嶅悎娉�");
		int startIndex=(pageCurrent-1)*pageSize;
		//2.3鏌ヨ褰撳墠鏁版嵁
		List<SysConfig> list=
		sysConfigDao.findPageObjects(startIndex,pageSize,name);
		//3.灏佽鏁版嵁
		PageObject<SysConfig> pageObject=new PageObject<>();
		pageObject.setRecords(list);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);

		return pageObject;
	}
}
