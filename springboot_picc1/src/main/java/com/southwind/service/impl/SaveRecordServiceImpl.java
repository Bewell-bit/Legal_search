package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.southwind.entity.SaveRecord;
import com.southwind.form.DelRecordForm;
import com.southwind.form.SearchForm;
import com.southwind.mapper.SaveRecordMapper;
import com.southwind.service.SaveRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.vo.PageVO;
import com.southwind.vo.ResultVO;
import com.southwind.vo.SaveRecordVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SaveRecordServiceImpl extends ServiceImpl<SaveRecordMapper, SaveRecord> implements SaveRecordService {

    @Autowired
    private SaveRecordMapper saveRecordMapper;

    @Override
    public Boolean deleteRecord(DelRecordForm delRecordForm) {
        QueryWrapper<SaveRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", delRecordForm.getUserId());
        queryWrapper.eq("txt_id", delRecordForm.getTxtId());
        int delete = this.saveRecordMapper.delete(queryWrapper);
        if(delete != 1) return false;
        return true;
    }

    @Override
    public PageVO list(Integer page, Integer size, String user_id) {
        String token = user_id;
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        int user_number = Integer.parseInt(claims.getId());  //得到对应用户的id
        QueryWrapper<SaveRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_number);
        Page<SaveRecord> saveRecordPage = new Page<>(page, size);
        Page<SaveRecord> resultPage = this.saveRecordMapper.selectPage(saveRecordPage, queryWrapper);
        //获取到SaveRecord对应页的所有列的信息
        List<SaveRecord> saveRecordList = resultPage.getRecords();
        //VO转换
        List<SaveRecordVO> saveRecordVOList = new ArrayList<>();
        for (SaveRecord saveRecord : saveRecordList) {
            SaveRecordVO saveRecordVO = new SaveRecordVO();

            BeanUtils.copyProperties(saveRecord, saveRecordVO);
            saveRecordVOList.add(saveRecordVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(saveRecordVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<SaveRecord> saveRecordPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<SaveRecord> resultPage = null;
        QueryWrapper<SaveRecord> queryWrapper1 = new QueryWrapper<>();
        String token = searchForm.getUserId();
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        int user_number = Integer.parseInt(claims.getId());  //得到对应用户的id
        queryWrapper1.eq("user_id", user_number);
        if(searchForm.getKey().equals("全部案件")) {
            queryWrapper1.like("txt_title", searchForm.getValue());
            resultPage = this.saveRecordMapper.selectPage(saveRecordPage, queryWrapper1);
        }else {
            queryWrapper1.eq("txt_type", searchForm.getKey());
            queryWrapper1.like("txt_title", searchForm.getValue());
            resultPage = this.saveRecordMapper.selectPage(saveRecordPage, queryWrapper1);
        }
        List<SaveRecord> saveRecordList = resultPage.getRecords();
        //VO转换
        List<SaveRecordVO> saveRecordVOList = new ArrayList<>();
        for (SaveRecord saveRecord : saveRecordList) {
            SaveRecordVO saveRecordVO = new SaveRecordVO();
            BeanUtils.copyProperties(saveRecord, saveRecordVO);
            saveRecordVOList.add(saveRecordVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(saveRecordVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }
}
