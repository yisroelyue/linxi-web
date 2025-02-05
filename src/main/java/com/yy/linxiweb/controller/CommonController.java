package com.yy.linxiweb.controller;

import com.yy.linxiweb.bo.Response;
import com.yy.linxiweb.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author platform-auto
 * @since 2024-10-16
 */
@Tag(name = "common")
@RestController
@RequestMapping("api/common")
public class CommonController {

    @Value("${linxi.fileHost}")
    private String fileHost;

    @Value("${linxi.musicDir}")
    private String musicDir;

    @Operation(summary = "test")
    @GetMapping("test")
    public Response<String> test() {
        return new ResponseUtil<String>().success();
    }

    @Operation(summary = "getConfig")
    @GetMapping("getConfig")
    public Response<SystemConfig> getConfig() {
        SystemConfig config = new SystemConfig();
        config.setFileHost(fileHost);
        config.setMusicDir(musicDir);
        return new ResponseUtil<SystemConfig>().success(config);
    }

    @Data
    public static class SystemConfig{
        String fileHost;
        String musicDir;
    }
}
