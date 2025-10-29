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


import com.dao.YuanliaojinhuoDao;
import com.entity.YuanliaojinhuoEntity;
import com.service.YuanliaojinhuoService;
import com.entity.vo.YuanliaojinhuoVO;
import com.entity.view.YuanliaojinhuoView;

@Service("yuanliaojinhuoService")
public class YuanliaojinhuoServiceImpl extends ServiceImpl<YuanliaojinhuoDao, YuanliaojinhuoEntity> implements YuanliaojinhuoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuanliaojinhuoEntity> page = this.selectPage(
                new Query<YuanliaojinhuoEntity>(params).getPage(),
                new EntityWrapper<YuanliaojinhuoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuanliaojinhuoEntity> wrapper) {
		  Page<YuanliaojinhuoView> page =new Query<YuanliaojinhuoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuanliaojinhuoVO> selectListVO(Wrapper<YuanliaojinhuoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuanliaojinhuoVO selectVO(Wrapper<YuanliaojinhuoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuanliaojinhuoView> selectListView(Wrapper<YuanliaojinhuoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuanliaojinhuoView selectView(Wrapper<YuanliaojinhuoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YuanliaojinhuoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YuanliaojinhuoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YuanliaojinhuoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
