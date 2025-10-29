package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CanyincaipinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CanyincaipinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CanyincaipinView;


/**
 * 餐饮菜品
 *
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public interface CanyincaipinService extends IService<CanyincaipinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanyincaipinVO> selectListVO(Wrapper<CanyincaipinEntity> wrapper);
   	
   	CanyincaipinVO selectVO(@Param("ew") Wrapper<CanyincaipinEntity> wrapper);
   	
   	List<CanyincaipinView> selectListView(Wrapper<CanyincaipinEntity> wrapper);
   	
   	CanyincaipinView selectView(@Param("ew") Wrapper<CanyincaipinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanyincaipinEntity> wrapper);

   	

}

