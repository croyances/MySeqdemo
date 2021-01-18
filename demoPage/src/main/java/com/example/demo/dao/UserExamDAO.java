
package com.example.demo.dao;


import com.example.demo.UserExam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * UserExam数据访问对象接口
 * @author
 */
@Mapper
public interface UserExamDAO {

	/**
	 * 新增实体信息
	 * @param userExam 实体对象
	 */
	void insert(UserExam userExam);

	/**
	 * 批量新增实体信息
	 * @param list 实体对象列表
	 */
	void insertByBatch(List<UserExam> list);

	/**
	 * 更新实体信息
	 * @param userExam 实体对象
	 */
	int update(UserExam userExam);

	/**
	 * 更新实体信息-只更新非空字段
	 * @param userExam 实体对象
	 */
	int updateSelective(UserExam userExam);

	/**
	 * 删除实体信息
	 * @param condition 查询条件
	 * @return 被删除的记录条数
	 */
	int delete(Map condition);

	/**
	 * 查询符合条件的实体个数
	 * @param condition 查询条件
	 * @return 符合条件的实体个数
	 */
	int count(Map condition);

	/**
	 * 查询符合条件的实体
	 *
	 * @param condition 查询条件
	 * @return 符合条件的实体
	 */
	List<UserExam> query(Map condition);



}
