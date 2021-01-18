
package com.example.demo;

import lombok.Data;

/**
 * UserExam实体类
 * @author
 */
@Data
public class UserExam {

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
	 * 门店id
	 */
	private String shopId;

	/**
	 * 课程编码
	 */
	private String courseCode;
	
	/**
	 * 用户答案
	 */
	private String answers;
	
	/**
	 * 得分
	 */
	private Integer score;
	
	/**
	 * 是否通过
	 */
	private Integer pass;
	
	/**
	 * 考试时间
	 */
	private java.util.Date createdAt;
	
}