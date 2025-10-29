package com.entity.vo;

import com.entity.CaipindingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 菜品订单
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public class CaipindingdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 菜品编号
	 */
	
	private String caipinbianhao;
		
	/**
	 * 菜品名称
	 */
	
	private String caipinmingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 价格
	 */
	
	private Integer jiage;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 总计
	 */
	
	private Integer zongji;
		
	/**
	 * 餐桌号
	 */
	
	private String canzhuohao;
		
	/**
	 * 下单备注
	 */
	
	private String xiadanbeizhu;
		
	/**
	 * 下单日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date xiadanriqi;
				
	
	/**
	 * 设置：菜品编号
	 */
	 
	public void setCaipinbianhao(String caipinbianhao) {
		this.caipinbianhao = caipinbianhao;
	}
	
	/**
	 * 获取：菜品编号
	 */
	public String getCaipinbianhao() {
		return caipinbianhao;
	}
				
	
	/**
	 * 设置：菜品名称
	 */
	 
	public void setCaipinmingcheng(String caipinmingcheng) {
		this.caipinmingcheng = caipinmingcheng;
	}
	
	/**
	 * 获取：菜品名称
	 */
	public String getCaipinmingcheng() {
		return caipinmingcheng;
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
	 * 设置：价格
	 */
	 
	public void setJiage(Integer jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Integer getJiage() {
		return jiage;
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
	 * 设置：总计
	 */
	 
	public void setZongji(Integer zongji) {
		this.zongji = zongji;
	}
	
	/**
	 * 获取：总计
	 */
	public Integer getZongji() {
		return zongji;
	}
				
	
	/**
	 * 设置：餐桌号
	 */
	 
	public void setCanzhuohao(String canzhuohao) {
		this.canzhuohao = canzhuohao;
	}
	
	/**
	 * 获取：餐桌号
	 */
	public String getCanzhuohao() {
		return canzhuohao;
	}
				
	
	/**
	 * 设置：下单备注
	 */
	 
	public void setXiadanbeizhu(String xiadanbeizhu) {
		this.xiadanbeizhu = xiadanbeizhu;
	}
	
	/**
	 * 获取：下单备注
	 */
	public String getXiadanbeizhu() {
		return xiadanbeizhu;
	}
				
	
	/**
	 * 设置：下单日期
	 */
	 
	public void setXiadanriqi(Date xiadanriqi) {
		this.xiadanriqi = xiadanriqi;
	}
	
	/**
	 * 获取：下单日期
	 */
	public Date getXiadanriqi() {
		return xiadanriqi;
	}
			
}
