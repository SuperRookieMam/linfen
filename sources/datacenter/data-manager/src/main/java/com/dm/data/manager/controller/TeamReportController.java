package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.TeamReportConverter;
import com.dm.data.manager.dto.TeamReportDto;
import com.dm.data.manager.entity.TeamReport;
import com.dm.data.manager.service.TeamReportService;
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
@RequestMapping("teamReports")
@Api(tags = { "团队填报" })
public class TeamReportController extends AbstractController<TeamReportDto> {

    @Autowired
    private TeamReportService teamReportService;

    @Autowired
    private TeamReportConverter teamReportConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TeamReportDto save(@RequestBody TeamReportDto data) {
        TeamReport model = teamReportService.save(data);
        return teamReportConverter.toDto(model);
    }

    @GetMapping("{id}")
    public TeamReportDto get(@PathVariable("id") Long id) {
        Optional<TeamReport> data = teamReportService.findById(id);
        return teamReportConverter.toDto(data);
    }

    @PutMapping("{id}")
    public TeamReportDto update(@PathVariable("id") Long id, @RequestBody TeamReportDto data) {
        TeamReport model = teamReportService.update(id, data);
        return teamReportConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        teamReportService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<TeamReportDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute TeamReportDto condition, @PageableDefault Pageable pageable) {
        Page<TeamReport> tourBus = teamReportService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, tourBus, data -> teamReportConverter.toDto(data));
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<TeamReport> list = teamReportService.getByPatams(jsonObject, TeamReport.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<TeamReportDto>(teamReportConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : teamReportConverter.toDto(list);
    }
}
