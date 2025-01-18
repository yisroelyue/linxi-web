package com.yy.linxiweb.service.impl;

import com.yy.linxiweb.po.MusicSheet;
import com.yy.linxiweb.dao.MusicSheetMapper;
import com.yy.linxiweb.service.IMusicSheetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yueyi
 * @since 2025-01-17
 */
@Service
public class MusicSheetServiceImpl extends ServiceImpl<MusicSheetMapper, MusicSheet> implements IMusicSheetService {


    @Override
    public List<MusicSheet> getList() {
        return this.list();
    }
}
