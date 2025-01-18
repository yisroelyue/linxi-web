package com.yy.linxiweb.service;

import com.yy.linxiweb.po.MusicSheet;
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
public interface IMusicSheetService extends IService<MusicSheet> {

    List<MusicSheet> getList();
}
