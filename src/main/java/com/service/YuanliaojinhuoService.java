package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuanliaojinhuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuanliaojinhuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuanliaojinhuoView;


/**
 * 原料进货
 *
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public interface YuanliaojinhuoService extends IService<YuanliaojinhuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuanliaojinhuoVO> selectListVO(Wrapper<YuanliaojinhuoEntity> wrapper);
   	
   	YuanliaojinhuoVO selectVO(@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);
   	
   	List<YuanliaojinhuoView> selectListView(Wrapper<YuanliaojinhuoEntity> wrapper);
   	
   	YuanliaojinhuoView selectView(@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuanliaojinhuoEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YuanliaojinhuoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YuanliaojinhuoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YuanliaojinhuoEntity> wrapper);



}

