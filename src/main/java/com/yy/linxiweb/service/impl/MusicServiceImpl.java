package com.yy.linxiweb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yy.linxiweb.po.Music;
import com.yy.linxiweb.dao.MusicMapper;
import com.yy.linxiweb.service.IMusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements IMusicService {

    @Override
    public List<Music> getByIds(List<Integer> ids) {
        return this.getByIds(ids);
    }
}
