package com.entity.vo;

import com.entity.MendianyuancailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 门店原材料
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public class MendianyuancailiaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 原料类型
	 */
	
	private String yuanliaoleixing;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 供应商
	 */
	
	private String gongyingshang;
		
	/**
	 * 原料详情
	 */
	
	private String yuanliaoxiangqing;
				
	
	/**
	 * 设置：原料类型
	 */
	 
	public void setYuanliaoleixing(String yuanliaoleixing) {
		this.yuanliaoleixing = yuanliaoleixing;
	}
	
	/**
	 * 获取：原料类型
	 */
	public String getYuanliaoleixing() {
		return yuanliaoleixing;
	}
				
	
	/**
	 * 设置：规格
	 */
	 
	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：供应商
	 */
	 
	public void setGongyingshang(String gongyingshang) {
		this.gongyingshang = gongyingshang;
	}
	
	/**
	 * 获取：供应商
	 */
	public String getGongyingshang() {
		return gongyingshang;
	}
				
	
	/**
	 * 设置：原料详情
	 */
	 
	public void setYuanliaoxiangqing(String yuanliaoxiangqing) {
		this.yuanliaoxiangqing = yuanliaoxiangqing;
	}
	
	/**
	 * 获取：原料详情
	 */
	public String getYuanliaoxiangqing() {
		return yuanliaoxiangqing;
	}
			
}
