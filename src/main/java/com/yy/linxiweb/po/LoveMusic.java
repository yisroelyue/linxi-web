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
 * @since 2025-01-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("love_music")
@Schema(name = "LoveMusic", description = "")
public class LoveMusic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("musicId")
    private Integer musicId;

    @TableField("createdAt")
    private Date createdAt;

    @TableField("updatedAt")
    private Date updatedAt;
}
