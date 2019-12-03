package com.dm.data.app.dto;/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 *
 * @author: 尹杰
 * @Date: 2019/9/16 10:11
 * @Description:
 * @History
 */

import com.dm.file.dto.FileInfoDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Copyright (c) 2019 江苏云智网络科技股份有限公司版权所有
 * @author: 尹杰
 * @Date: 2019/9/16 10:11
 * @Description:
 * @History
 */
@Getter
@Setter
public class BannerFileDto implements Serializable {
    private Long id;
    private String  fileId;
    private String name;
    private Integer orderNum;
}
