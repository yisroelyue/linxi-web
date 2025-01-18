package com.yy.linxiweb.controller;

import com.yy.linxiweb.bo.Response;
import com.yy.linxiweb.po.MusicSheet;
import com.yy.linxiweb.service.IMusicSheetService;
import com.yy.linxiweb.service.impl.MusicSheetServiceImpl;
import com.yy.linxiweb.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yueyi
 * @since 2025-01-17
 */
@RestController
@RequestMapping("api/musicSheet")
public class MusicSheetController {

    @Autowired
    private IMusicSheetService musicSheetService;

    @Operation(summary = "list")
    @GetMapping("list")
    public Response<List<MusicSheet>> test() {
        return new ResponseUtil<List<MusicSheet>>().success(
                musicSheetService.getList()
        );
    }
}
