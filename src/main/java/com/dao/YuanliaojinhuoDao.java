package com.dao;

import com.entity.YuanliaojinhuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuanliaojinhuoVO;
import com.entity.view.YuanliaojinhuoView;


/**
 * 原料进货
 * 
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public interface YuanliaojinhuoDao extends BaseMapper<YuanliaojinhuoEntity> {
	
	List<YuanliaojinhuoVO> selectListVO(@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);
	
	YuanliaojinhuoVO selectVO(@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);
	
	List<YuanliaojinhuoView> selectListView(@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);

	List<YuanliaojinhuoView> selectListView(Pagination page,@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);

	
	YuanliaojinhuoView selectView(@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuanliaojinhuoEntity> wrapper);



}
