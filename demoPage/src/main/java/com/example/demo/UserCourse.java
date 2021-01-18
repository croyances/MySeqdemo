
package com.example.demo;

import lombok.Data;

/**
 * UserCourse实体类
 * @author
 */
@Data
public class UserCourse {
	
	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 商户id
	 */
	private String merchantId;
	
	/**
	 * 用户id
	 */
	private String userId;
	
	/**
	 * 课程编码
	 */
	private String courseCode;
	
	/**
	 * 章节编码
	 */
	private String chapterCode;
	
	/**
	 * 完成状态 0:未完成 1:完成
	 */
	private Integer status;
	
	/**
	 * 开始时间
	 */
	private java.util.Date createdAt;
	
}