package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TeamMemberConverter;
import com.dm.data.manager.dto.TeamMemberDto;
import com.dm.data.manager.entity.TeamMember;
import com.dm.data.manager.service.TeamMemberService;
import com.dm.data.manager.utile.PageInfo;
import com.dm.data.manager.utile.ParamUtile;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("teamMembers")
@Api(tags = { "团队人数" })
public class TeamMemberController extends AbstractController<TeamMemberDto> {
    @Autowired
    private TeamMemberService teamMemberService;

    @Autowired
    private TeamMemberConverter teamMemberConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TeamMemberDto save(@RequestBody TeamMemberDto data) {
        TeamMember model = teamMemberService.save(data);
        return teamMemberConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TeamMemberDto get(@PathVariable("id") Long id) {
        Optional<TeamMember> data = teamMemberService.findById(id);
        return teamMemberConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TeamMemberDto update(@PathVariable("id") Long id, @RequestBody TeamMemberDto data) {
        TeamMember model = teamMemberService.update(id, data);
        return teamMemberConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        teamMemberService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TeamMemberDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TeamMemberDto condition, @PageableDefault Pageable pageable) {
        Page<TeamMember> tourBus = teamMemberService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, tourBus, data -> teamMemberConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TeamMember> list = teamMemberService.getByPatams(jsonObject, TeamMember.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TeamMemberDto>(teamMemberConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : teamMemberConverter.toDto(list);
    }
}
