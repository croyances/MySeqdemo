
package com.example.demo;

import com.example.demo.dao.UserExamDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * UserExam服务对象实现类
 *
 * @author
 */
@Service
public class UserExamServiceImpl implements UserExamService {

	@Autowired
	private UserExamDAO userExamDAO;



	@Override
	public void insert(UserExam userExam) {
		userExam.setId(UUID.randomUUID().toString());
		userExamDAO.insert(userExam);
	}

	@Override
	public void insert(List<UserExam> userExamList) {
		userExamDAO.insertByBatch(userExamList);
	}
	
	@Override
	public int update(UserExam userExam) {
		return userExamDAO.update(userExam);
	}
	
	@Override
	public int delete(Map condition) {
		return userExamDAO.delete(condition);
	}
	
	@Override
	public int delete(String id) {
		if (id == null) {
			return 0;
		}
		Map condition = new HashMap();
		condition.put("id", id);
		return delete(condition);
	}
	
	@Override
	public int delete(String[] ids) {
		int result = 0;
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				result += delete(ids[i]);
			}
		}
		return result;
	}
	
	@Override
	public int count(Map condition) {
		return userExamDAO.count(condition);
	}
	
	@Override
	public List<UserExam> query(Map condition, int offset, int limit) {
		condition.put("offset", offset);
		condition.put("limit", limit);
		return userExamDAO.query(condition);
	}

	@Override
	public List<UserExam> query(Map condition) {
		return userExamDAO.query(condition);

	}


	@Override
	public UserExam query(String id) {
		if (id == null) {
			return null;
		}
		Map condition = new HashMap();
		condition.put("id", id);
		List list = query(condition);
		if (list != null && !list.isEmpty()) {
			return (UserExam) list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public PageResult findPage(PagePram pageRequest) {
		return getPageResult(pageRequest, getPageInfo(pageRequest));
	}



	public String probability(double a, double b) {
		BigDecimal bigDecimal = new BigDecimal(a / b);
		bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		DecimalFormat df = new DecimalFormat();
		String style = "0%";
		df.applyPattern(style);
		return df.format(bigDecimal);
	}
	public static PageResult getPageResult(PagePram pageRequest, PageInfo<?> pageInfo) {
		PageResult pageResult = new PageResult();
		pageResult.setPageNum(pageInfo.getPageNum());
		pageResult.setPageSize(pageInfo.getPageSize());
		pageResult.setTotalSize(pageInfo.getTotal());
		pageResult.setTotalPages(pageInfo.getPages());
		pageResult.setContent(pageInfo.getList());
		return pageResult;
	}




	private PageInfo<UserExam> getPageInfo(PagePram pageRequest) {
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		//PageHelper.startPage(pageNum, pageSize);
		//PageHelper.offsetPage(pageNum, pageSize,true);
		HashMap hashMap = new HashMap();
		hashMap.put("pageNum", pageRequest.getPageNum());
		hashMap.put("pageSize", pageRequest.getPageSize());
		List<UserExam> sysMenus = userExamDAO.query(hashMap);
		PageInfo<UserExam> objectPageInfo = PageHelper.startPage(2, 11).doSelectPageInfo(() -> userExamDAO.query(new HashMap()));
		return objectPageInfo;
	}

}
