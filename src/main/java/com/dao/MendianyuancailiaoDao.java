package com.dao;

import com.entity.MendianyuancailiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MendianyuancailiaoVO;
import com.entity.view.MendianyuancailiaoView;


/**
 * 门店原材料
 * 
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public interface MendianyuancailiaoDao extends BaseMapper<MendianyuancailiaoEntity> {
	
	List<MendianyuancailiaoVO> selectListVO(@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);
	
	MendianyuancailiaoVO selectVO(@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);
	
	List<MendianyuancailiaoView> selectListView(@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);

	List<MendianyuancailiaoView> selectListView(Pagination page,@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);

	
	MendianyuancailiaoView selectView(@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<MendianyuancailiaoEntity> wrapper);



}
