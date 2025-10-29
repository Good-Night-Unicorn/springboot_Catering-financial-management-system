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


import com.dao.MendianyuancailiaoDao;
import com.entity.MendianyuancailiaoEntity;
import com.service.MendianyuancailiaoService;
import com.entity.vo.MendianyuancailiaoVO;
import com.entity.view.MendianyuancailiaoView;

@Service("mendianyuancailiaoService")
public class MendianyuancailiaoServiceImpl extends ServiceImpl<MendianyuancailiaoDao, MendianyuancailiaoEntity> implements MendianyuancailiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MendianyuancailiaoEntity> page = this.selectPage(
                new Query<MendianyuancailiaoEntity>(params).getPage(),
                new EntityWrapper<MendianyuancailiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MendianyuancailiaoEntity> wrapper) {
		  Page<MendianyuancailiaoView> page =new Query<MendianyuancailiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<MendianyuancailiaoVO> selectListVO(Wrapper<MendianyuancailiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MendianyuancailiaoVO selectVO(Wrapper<MendianyuancailiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MendianyuancailiaoView> selectListView(Wrapper<MendianyuancailiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MendianyuancailiaoView selectView(Wrapper<MendianyuancailiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<MendianyuancailiaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<MendianyuancailiaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<MendianyuancailiaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
