package com.entity.view;

import com.entity.CanyincaipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 餐饮菜品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
@TableName("canyincaipin")
public class CanyincaipinView  extends CanyincaipinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CanyincaipinView(){
	}
 
 	public CanyincaipinView(CanyincaipinEntity canyincaipinEntity){
 	try {
			BeanUtils.copyProperties(this, canyincaipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
