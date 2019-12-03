package com.dm.linfen.root.converter;

import com.dm.common.converter.AbstractConverter;
import com.dm.linfen.root.dto.WeChatUserDto;
import com.dm.linfen.root.entity.RecommendLine;
import com.dm.linfen.root.entity.WeChatUser;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WeChatUserConverter extends AbstractConverter<WeChatUser, WeChatUserDto> {
    @Override
    protected WeChatUserDto toDtoActual(WeChatUser model) {
        WeChatUserDto dto=new WeChatUserDto();
        dto.setId(model.getId());
        dto.setWeChatName(model.getWeChatName());
        dto.setOpenId(model.getOpenId());
        dto.setRegisterTime(model.getRegisterTime());
        dto.setLastLoginTime(model.getLastLoginTime());
        dto.setName(model.getName());
        dto.setBirthday(model.getBirthday());
        dto.setSex(model.getSex());
        dto.setResidence(model.getResidence());
        //推荐线路
        if(!Objects.isNull(model.getRecommendLines())&&model.getRecommendLines().size()>0){
            List<Map<String,Object>> recommendLines=new ArrayList<>();
            Map<String,Object> map=new HashMap<>();
            for(RecommendLine recommendLine :model.getRecommendLines()){
                map.put("id",recommendLine.getId());
                map.put("routeName",recommendLine.getName());
                recommendLines.add(map);
            }
            dto.setRecommendLines(recommendLines);
        }
        return dto;
    }

    @Override
    public WeChatUser copyProperties(WeChatUser model, WeChatUserDto dto) {
        model.setId(dto.getId());
        model.setWeChatName(dto.getWeChatName());
        model.setRegisterTime(dto.getRegisterTime());
        model.setLastLoginTime(dto.getLastLoginTime());
        model.setName(dto.getName());
        model.setBirthday(dto.getBirthday());
        model.setSex(dto.getSex());
        model.setResidence(dto.getResidence());
        model.setOpenId(dto.getOpenId());
        return model;
    }
}
