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

import com.entity.CanyincaipinEntity;
import com.entity.view.CanyincaipinView;

import com.service.CanyincaipinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 餐饮菜品
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-02 20:42:36
 */
@RestController
@RequestMapping("/canyincaipin")
public class CanyincaipinController {
    @Autowired
    private CanyincaipinService canyincaipinService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CanyincaipinEntity canyincaipin,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CanyincaipinEntity> ew = new EntityWrapper<CanyincaipinEntity>();


        //查询结果
		PageUtils page = canyincaipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canyincaipin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CanyincaipinEntity canyincaipin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CanyincaipinEntity> ew = new EntityWrapper<CanyincaipinEntity>();

        //查询结果
		PageUtils page = canyincaipinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canyincaipin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CanyincaipinEntity canyincaipin){
       	EntityWrapper<CanyincaipinEntity> ew = new EntityWrapper<CanyincaipinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( canyincaipin, "canyincaipin")); 
        return R.ok().put("data", canyincaipinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CanyincaipinEntity canyincaipin){
        EntityWrapper< CanyincaipinEntity> ew = new EntityWrapper< CanyincaipinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( canyincaipin, "canyincaipin")); 
		CanyincaipinView canyincaipinView =  canyincaipinService.selectView(ew);
		return R.ok("查询餐饮菜品成功").put("data", canyincaipinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CanyincaipinEntity canyincaipin = canyincaipinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(canyincaipin,deSens);
        return R.ok().put("data", canyincaipin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CanyincaipinEntity canyincaipin = canyincaipinService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(canyincaipin,deSens);
        return R.ok().put("data", canyincaipin);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CanyincaipinEntity canyincaipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canyincaipin);
        canyincaipinService.insert(canyincaipin);
        return R.ok().put("data",canyincaipin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CanyincaipinEntity canyincaipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canyincaipin);
        canyincaipinService.insert(canyincaipin);
        return R.ok().put("data",canyincaipin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CanyincaipinEntity canyincaipin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(canyincaipin);
        //全部更新
        canyincaipinService.updateById(canyincaipin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        canyincaipinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    







    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,CanyincaipinEntity canyincaipin, HttpServletRequest request){
        EntityWrapper<CanyincaipinEntity> ew = new EntityWrapper<CanyincaipinEntity>();
        int count = canyincaipinService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, canyincaipin), params), params));
        return R.ok().put("data", count);
    }

}
