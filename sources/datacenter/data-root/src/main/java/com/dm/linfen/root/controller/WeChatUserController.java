package com.dm.linfen.root.controller;

import com.dm.common.dto.TableResult;
import com.dm.linfen.root.converter.WeChatUserConverter;
import com.dm.linfen.root.dto.WeChatUserDto;
import com.dm.linfen.root.entity.WeChatUser;
import com.dm.linfen.root.service.WeChatUserService;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("weChatUsers")
public class WeChatUserController {
    @Autowired
    private WeChatUserService weChatUserService;
    @Autowired
    private WeChatUserConverter weChatUserConverter;

    @GetMapping("{id}")
    public WeChatUserDto findById(@PathVariable("id") Long id){
        return weChatUserConverter.toDto(weChatUserService.findById(id));
    }
    @GetMapping("findByOpenId/{openId}")
    public WeChatUserDto findByOpenId(@PathVariable("openId") String openId){
        return weChatUserConverter.toDto(weChatUserService.findByOpenId(openId));
    }
    @PostMapping
    @ResponseStatus(CREATED)
    public WeChatUserDto save(@RequestBody WeChatUserDto dto){
        return weChatUserConverter.toDto(weChatUserService.save(dto));
    }

    @DeleteMapping("{id}")
    public void save(@PathVariable("id") Long id){
        weChatUserService.deleteById(id);
    }

    @PutMapping
    public WeChatUserDto update(@PathVariable("id") Long id,@RequestBody WeChatUserDto dto){
        return weChatUserConverter.toDto(weChatUserService.update(id,dto));
    }

    @GetMapping(params = { "draw" })
    public TableResult<WeChatUserDto> search(@RequestParam("draw") Long draw, @RequestParam(value = "search",required =false )String search,@CurrentUser UserDetailsDto user,
                                                @PageableDefault Pageable pageable) {
        Page<WeChatUser> weChatUsers = weChatUserService.find(search,pageable);
        return TableResult.success(draw, weChatUsers, weChatUserConverter::toDto);
    }

    /**asdsda
     * 用户登录使用
     * @param openId
     * @return
     */
    @PutMapping("lastLogin/{openId}")
    public WeChatUserDto lastLogin(@PathVariable("openId") String  openId){
        return weChatUserConverter.toDto(weChatUserService.lastLogin(openId));
    }
}
