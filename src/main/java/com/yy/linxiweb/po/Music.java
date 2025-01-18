package com.yy.linxiweb.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yueyi
 * @since 2025-01-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("music")
@Schema(name = "Music", description = "")
public class Music implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("fileName")
    private String fileName;

    @TableField("filePath")
    private String filePath;

    @TableField("artist")
    private String artist;

    @TableField("album")
    private String album;

    @TableField("genre")
    private String genre;

    @TableField("duration")
    private Integer duration;

    @TableField("releaseDate")
    private Date releaseDate;

    @TableField("fileSize")
    private Long fileSize;

    @TableField("createdAt")
    private Date createdAt;

    @TableField("updatedAt")
    private Date updatedAt;
}
