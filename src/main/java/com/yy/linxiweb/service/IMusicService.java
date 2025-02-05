package com.yy.linxiweb.service;

import com.yy.linxiweb.po.Music;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yueyi
 * @since 2025-01-17
 */
public interface IMusicService extends IService<Music> {
    List<Music> getByIds(List<Integer> ids);

    List<Music> getBySongSheetId(int id);

    List<Music>  getLoveMusic();

    void getCoverImgForMusic(Integer id);
}
