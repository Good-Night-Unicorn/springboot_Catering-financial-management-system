package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CanyincaipinDao;
import com.entity.CanyincaipinEntity;
import com.service.CanyincaipinService;
import com.entity.vo.CanyincaipinVO;
import com.entity.view.CanyincaipinView;

@Service("canyincaipinService")
public class CanyincaipinServiceImpl extends ServiceImpl<CanyincaipinDao, CanyincaipinEntity> implements CanyincaipinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanyincaipinEntity> page = this.selectPage(
                new Query<CanyincaipinEntity>(params).getPage(),
                new EntityWrapper<CanyincaipinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanyincaipinEntity> wrapper) {
		  Page<CanyincaipinView> page =new Query<CanyincaipinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<CanyincaipinVO> selectListVO(Wrapper<CanyincaipinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CanyincaipinVO selectVO(Wrapper<CanyincaipinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CanyincaipinView> selectListView(Wrapper<CanyincaipinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanyincaipinView selectView(Wrapper<CanyincaipinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
