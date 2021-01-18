
package com.example.demo;


import java.util.List;
import java.util.Map;

/**
 * UserExam服务对象接口
 * @author
 */
public interface UserExamService {



	/**
	 * 更新实体信息
	 * @param userExam 实体对象
	 * @return 更新影响的记录条数
	 */
	int update(UserExam userExam);

	/**
	 * 新增实体信息
	 * @param userExam 实体对象
	 */
	void insert(UserExam userExam);

	/**
	 * 批量新增实体信息
	 * @param userExamList 实体对象列表
	 */
	void insert(List<UserExam> userExamList);

	/**
	 * 删除实体信息
	 * @param condition 查询条件
	 * @return 被删除的记录条数
	 */
	int delete(Map condition);
	
	/**
	 * 删除实体信息
	 * @param id 主键
	 * @return 被删除的记录条数
	 */
	int delete(String id);
	
	/**
	 * 删除实体信息
	 * @param id 主键数组
	 * @return 删除影响的记录条数
	 */
	int delete(String[] ids);

	/**
	 * 查询符合条件的实体个数
	 * @param condition 查询条件
	 * @return 符合条件的实体个数
	 */
	int count(Map condition);

	/**
	 * 查询符合条件的实体
	 * @param condition 查询条件
	 * @param offset 跳过实体数
	 * @param limit 返回最大实体数
	 * @return 符合条件的实体
	 */
	List<UserExam> query(Map condition, int offset, int limit);
	
	/**
	 * 查询符合条件的实体
	 * @param condition 查询条件
	 * @return 符合条件的实体
	 */
	List<UserExam> query(Map condition);

	/**
	 * 根据主键查询实体
	 *
	 * @param id 主键
	 * @return 实体
	 */
	UserExam query(String id);


	PageResult findPage(PagePram pageRequest);




}
