package com.southwind.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.southwind.entity.SaveRecord;
import com.southwind.form.DelRecordForm;
import com.southwind.form.SaveRecordForm;
import com.southwind.form.SearchForm;
import com.southwind.mapper.SaveRecordMapper;
import com.southwind.service.SaveRecordService;
import com.southwind.service.UserService;
import com.southwind.until.ResultVOUtil;
import com.southwind.vo.ResultVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/record")
public class SaveRecordController {
    @Autowired
    private SaveRecordService saveRecordService;

    @PostMapping("/save")
    public ResultVO save_record(@RequestBody SaveRecordForm saveRecordForm) {
        SaveRecord saveRecord = new SaveRecord();
        String token = saveRecordForm.getUserId();
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        Integer user_number = Integer.valueOf(claims.getId());
        QueryWrapper<SaveRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("txt_id", saveRecordForm.getTxtId());
        List<SaveRecord> list = this.saveRecordService.list(queryWrapper);  //此时可能有不同的用户收藏了同一篇文章
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            Integer check_number = list.get(i).getUserId();
            if(user_number == check_number) {
                return ResultVOUtil.fail();
            }
        }
        saveRecord.setTxtId(saveRecordForm.getTxtId());
        saveRecord.setTxtTitle(saveRecordForm.getTxtTitle());
        saveRecord.setUserId(user_number);
        saveRecord.setCreatedTime(saveRecordForm.getCreatedTime());
        saveRecord.setTxtType(saveRecordForm.getTxtType());
        saveRecord.setCurrentPage(saveRecordForm.getCurrentPage());
        boolean save = this.saveRecordService.save(saveRecord);
        if(save) return ResultVOUtil.success("保存成功！");
        return ResultVOUtil.fail();
    }

    @PostMapping("/delete")
    public ResultVO delete_record(@RequestBody DelRecordForm delRecordForm) {
        //获取token
        String token = delRecordForm.getUserId();
        //调用解密方法
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        //解密ID
        Integer user_number=Integer.valueOf(claims.getId());

        QueryWrapper<SaveRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("txt_id", delRecordForm.getTxtId());
        queryWrapper.eq("user_id", user_number);
        Boolean delete = this.saveRecordService.remove(queryWrapper);
        if(!delete) return ResultVOUtil.fail();
        return ResultVOUtil.success("记录删除成功！");
    }

    //展示对应用户的所有收藏记录（无分页版本）
    @PostMapping("/list")
    public ResultVO list(String user_id) {
        String token = user_id;
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        int user_number = Integer.parseInt(claims.getId());
        List<SaveRecord> list = this.saveRecordService.list();
        for (int i=list.size()-1;i>=0;i--) {
            int check_number = list.get(i).getUserId();
            if(user_number!=check_number) {
                list.remove(i);
            }
        }
        int save_total = list.size();
        Map<String, Object> map = new HashMap<>(2);
        Collections.reverse(list);  //把list颠倒
        map.put("save_total", save_total);
        map.put("save_list", list);
        if(list.size()!=0) return ResultVOUtil.success(map);
        return ResultVOUtil.fail();
    }

    @PostMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size,String user_id){
        return ResultVOUtil.success(this.saveRecordService.list(page, size, user_id));
    }

    @PostMapping("/search")
    public ResultVO search(@RequestBody SearchForm searchForm){
        return ResultVOUtil.success(this.saveRecordService.search(searchForm));
    }
}
