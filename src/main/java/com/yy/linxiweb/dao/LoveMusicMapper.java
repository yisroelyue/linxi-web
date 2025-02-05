package com.yy.linxiweb.dao;

import com.yy.linxiweb.po.LoveMusic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.linxiweb.po.Music;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yueyi
 * @since 2025-01-27
 */
public interface LoveMusicMapper extends BaseMapper<LoveMusic> {

    List<Music> getList();
}
