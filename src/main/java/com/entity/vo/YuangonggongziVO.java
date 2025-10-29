package com.entity.vo;

import com.entity.YuangonggongziEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 员工工资
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public class YuangonggongziVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 扣除五险一金
	 */
	
	private Double kouchuwuxianyijin;
		
	/**
	 * 扣税
	 */
	
	private Double koushui;
		
	/**
	 * 津贴
	 */
	
	private Double jintie;
		
	/**
	 * 奖金
	 */
	
	private Double jiangjin;
		
	/**
	 * 最终工资
	 */
	
	private Double zuizhonggongzi;
		
	/**
	 * 发放日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fafangriqi;
		
	/**
	 * 员工账号
	 */
	
	private String yuangongzhanghao;
		
	/**
	 * 员工姓名
	 */
	
	private String yuangongxingming;
		
	/**
	 * 员工手机
	 */
	
	private String yuangongshouji;
				
	
	/**
	 * 设置：扣除五险一金
	 */
	 
	public void setKouchuwuxianyijin(Double kouchuwuxianyijin) {
		this.kouchuwuxianyijin = kouchuwuxianyijin;
	}
	
	/**
	 * 获取：扣除五险一金
	 */
	public Double getKouchuwuxianyijin() {
		return kouchuwuxianyijin;
	}
				
	
	/**
	 * 设置：扣税
	 */
	 
	public void setKoushui(Double koushui) {
		this.koushui = koushui;
	}
	
	/**
	 * 获取：扣税
	 */
	public Double getKoushui() {
		return koushui;
	}
				
	
	/**
	 * 设置：津贴
	 */
	 
	public void setJintie(Double jintie) {
		this.jintie = jintie;
	}
	
	/**
	 * 获取：津贴
	 */
	public Double getJintie() {
		return jintie;
	}
				
	
	/**
	 * 设置：奖金
	 */
	 
	public void setJiangjin(Double jiangjin) {
		this.jiangjin = jiangjin;
	}
	
	/**
	 * 获取：奖金
	 */
	public Double getJiangjin() {
		return jiangjin;
	}
				
	
	/**
	 * 设置：最终工资
	 */
	 
	public void setZuizhonggongzi(Double zuizhonggongzi) {
		this.zuizhonggongzi = zuizhonggongzi;
	}
	
	/**
	 * 获取：最终工资
	 */
	public Double getZuizhonggongzi() {
		return zuizhonggongzi;
	}
				
	
	/**
	 * 设置：发放日期
	 */
	 
	public void setFafangriqi(Date fafangriqi) {
		this.fafangriqi = fafangriqi;
	}
	
	/**
	 * 获取：发放日期
	 */
	public Date getFafangriqi() {
		return fafangriqi;
	}
				
	
	/**
	 * 设置：员工账号
	 */
	 
	public void setYuangongzhanghao(String yuangongzhanghao) {
		this.yuangongzhanghao = yuangongzhanghao;
	}
	
	/**
	 * 获取：员工账号
	 */
	public String getYuangongzhanghao() {
		return yuangongzhanghao;
	}
				
	
	/**
	 * 设置：员工姓名
	 */
	 
	public void setYuangongxingming(String yuangongxingming) {
		this.yuangongxingming = yuangongxingming;
	}
	
	/**
	 * 获取：员工姓名
	 */
	public String getYuangongxingming() {
		return yuangongxingming;
	}
				
	
	/**
	 * 设置：员工手机
	 */
	 
	public void setYuangongshouji(String yuangongshouji) {
		this.yuangongshouji = yuangongshouji;
	}
	
	/**
	 * 获取：员工手机
	 */
	public String getYuangongshouji() {
		return yuangongshouji;
	}
			
}
