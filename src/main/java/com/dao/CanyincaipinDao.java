package com.dao;

import com.entity.CanyincaipinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CanyincaipinVO;
import com.entity.view.CanyincaipinView;


/**
 * 餐饮菜品
 * 
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
public interface CanyincaipinDao extends BaseMapper<CanyincaipinEntity> {
	
	List<CanyincaipinVO> selectListVO(@Param("ew") Wrapper<CanyincaipinEntity> wrapper);
	
	CanyincaipinVO selectVO(@Param("ew") Wrapper<CanyincaipinEntity> wrapper);
	
	List<CanyincaipinView> selectListView(@Param("ew") Wrapper<CanyincaipinEntity> wrapper);

	List<CanyincaipinView> selectListView(Pagination page,@Param("ew") Wrapper<CanyincaipinEntity> wrapper);

	
	CanyincaipinView selectView(@Param("ew") Wrapper<CanyincaipinEntity> wrapper);
	

}
