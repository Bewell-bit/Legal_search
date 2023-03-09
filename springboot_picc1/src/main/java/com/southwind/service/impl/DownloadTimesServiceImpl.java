package com.southwind.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.entity.DownloadTimes;
import com.southwind.mapper.DownloadTimesMapper;
import com.southwind.service.DownloadTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadTimesServiceImpl extends ServiceImpl<DownloadTimesMapper, DownloadTimes> implements DownloadTimesService {
    @Autowired
    private DownloadTimesMapper downloadTimesMapper;
}
