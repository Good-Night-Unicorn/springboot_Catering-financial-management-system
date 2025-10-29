package com.entity.view;

import com.entity.MendianyuancailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 门店原材料
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
@TableName("mendianyuancailiao")
public class MendianyuancailiaoView  extends MendianyuancailiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MendianyuancailiaoView(){
	}
 
 	public MendianyuancailiaoView(MendianyuancailiaoEntity mendianyuancailiaoEntity){
 	try {
			BeanUtils.copyProperties(this, mendianyuancailiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
