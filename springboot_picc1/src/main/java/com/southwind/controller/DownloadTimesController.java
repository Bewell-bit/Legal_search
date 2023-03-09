package com.southwind.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.southwind.entity.DownloadTimes;
import com.southwind.entity.SaveRecord;
import com.southwind.form.DownloadForm;
import com.southwind.form.LoginForm;
import com.southwind.service.DownloadTimesService;
import com.southwind.until.ResultVOUtil;
import com.southwind.vo.ResultVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/downloads")
public class DownloadTimesController {

    @Autowired
    private DownloadTimesService downloadTimesService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody DownloadForm downloadForm) {
        DownloadTimes downloadTimes = new DownloadTimes();
        //创建好当前日期
        LocalDate date = LocalDate.now();
        //规定好日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String token = downloadForm.getToken();
        Claims claims= Jwts.parser()
                .setSigningKey("my-123")
                .parseClaimsJws(token)
                .getBody();
        Integer user_number = Integer.valueOf(claims.getId());  //获得用户对应的id

        QueryWrapper<DownloadTimes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_number);
        queryWrapper.eq("current_dates", date.format(formatter));
        List<DownloadTimes> list = this.downloadTimesService.list(queryWrapper);
        if(list.size() == 0) {    //用户当天是首次下载的情况

            downloadTimes.setUserId(user_number);
            downloadTimes.setDownloads(1);
            downloadTimes.setCurrentDates(date.format(formatter));

            boolean save1 = this.downloadTimesService.save(downloadTimes);
            if(save1) return ResultVOUtil.success("保存成功！");
            return ResultVOUtil.fail();
        }else {     //用户当天不是首次下载的情况
            if(list.get(0).getDownloads() >= 30){  //若用户当天的下载次数已经达到了30次则返回错误
                return ResultVOUtil.fail();
            }
            int number = 1 + (list.get(0).getDownloads());
            UpdateWrapper<DownloadTimes> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_id", user_number);
            updateWrapper.eq("current_dates", date.format(formatter));
            downloadTimes.setDownloads(number);
            boolean save2 = this.downloadTimesService.update(downloadTimes,updateWrapper);
            if(save2) return ResultVOUtil.success("保存成功！");
            return ResultVOUtil.fail();
        }
    }
}
