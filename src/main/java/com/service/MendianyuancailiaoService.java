package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MendianyuancailiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MendianyuancailiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MendianyuancailiaoView;


/**
 * 门店原材料
 *
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public interface MendianyuancailiaoService extends IService<MendianyuancailiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MendianyuancailiaoVO> selectListVO(Wrapper<MendianyuancailiaoEntity> wrapper);
   	
   	MendianyuancailiaoVO selectVO(@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);
   	
   	List<MendianyuancailiaoView> selectListView(Wrapper<MendianyuancailiaoEntity> wrapper);
   	
   	MendianyuancailiaoView selectView(@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MendianyuancailiaoEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<MendianyuancailiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<MendianyuancailiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<MendianyuancailiaoEntity> wrapper);



}

