package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YuanliaochukuEntity;
import com.entity.view.YuanliaochukuView;

import com.service.YuanliaochukuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 原料出库
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
@RestController
@RequestMapping("/yuanliaochuku")
public class YuanliaochukuController {
    @Autowired
    private YuanliaochukuService yuanliaochukuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuanliaochukuEntity yuanliaochuku,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YuanliaochukuEntity> ew = new EntityWrapper<YuanliaochukuEntity>();


        //查询结果
		PageUtils page = yuanliaochukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanliaochuku), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuanliaochukuEntity yuanliaochuku, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YuanliaochukuEntity> ew = new EntityWrapper<YuanliaochukuEntity>();

        //查询结果
		PageUtils page = yuanliaochukuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuanliaochuku), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuanliaochukuEntity yuanliaochuku){
       	EntityWrapper<YuanliaochukuEntity> ew = new EntityWrapper<YuanliaochukuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuanliaochuku, "yuanliaochuku")); 
        return R.ok().put("data", yuanliaochukuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuanliaochukuEntity yuanliaochuku){
        EntityWrapper< YuanliaochukuEntity> ew = new EntityWrapper< YuanliaochukuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuanliaochuku, "yuanliaochuku")); 
		YuanliaochukuView yuanliaochukuView =  yuanliaochukuService.selectView(ew);
		return R.ok("查询原料出库成功").put("data", yuanliaochukuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuanliaochukuEntity yuanliaochuku = yuanliaochukuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yuanliaochuku,deSens);
        return R.ok().put("data", yuanliaochuku);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuanliaochukuEntity yuanliaochuku = yuanliaochukuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yuanliaochuku,deSens);
        return R.ok().put("data", yuanliaochuku);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuanliaochukuEntity yuanliaochuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuanliaochuku);
        yuanliaochukuService.insert(yuanliaochuku);
        return R.ok().put("data",yuanliaochuku.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuanliaochukuEntity yuanliaochuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuanliaochuku);
        yuanliaochukuService.insert(yuanliaochuku);
        return R.ok().put("data",yuanliaochuku.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuanliaochukuEntity yuanliaochuku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuanliaochuku);
        //全部更新
        yuanliaochukuService.updateById(yuanliaochuku);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuanliaochukuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
