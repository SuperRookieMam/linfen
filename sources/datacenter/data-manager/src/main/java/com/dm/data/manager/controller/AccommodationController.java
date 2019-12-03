
package com.dm.data.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.dm.common.dto.TableResult;
import com.dm.data.manager.converter.AccommodationConverter;
import com.dm.data.manager.dto.AccommodationDto;
import com.dm.data.manager.entity.Accommodation;
import com.dm.data.manager.service.AccommodationService;
import com.dm.data.manager.utile.PageInfo;
import com.dm.data.manager.utile.ParamUtile;
import com.dm.security.annotation.CurrentUser;
import com.dm.security.core.userdetails.UserDetailsDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

/**
 * 住宿场所控制器
 *
 */
@RestController
@RequestMapping("accommodations")
@Api(tags = { "酒店住宿场所" })
public class AccommodationController extends AbstractController<AccommodationDto> {

    @Autowired
    private AccommodationService accommodationService;

    @Autowired
    private AccommodationConverter accommodationConverter;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public AccommodationDto save(@RequestBody AccommodationDto data) {
        Accommodation model = accommodationService.save(data);
        return accommodationConverter.toDto(model);
    }

    @GetMapping("{id}")
    public AccommodationDto get(@PathVariable("id") Long id) {
        Optional<Accommodation> data = accommodationService.findById(id);
        return accommodationConverter.toDto(data);
    }

    @PutMapping("{id}")
    public AccommodationDto update(@PathVariable("id") Long id, @RequestBody AccommodationDto data) {
        Accommodation model = accommodationService.update(id, data);
        return accommodationConverter.toDto(model);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        accommodationService.delete(id);
    }

    @Override
    @GetMapping(params = { "draw" })
    public TableResult<AccommodationDto> search(@RequestParam("draw") Long draw, @CurrentUser UserDetailsDto user,
            @ModelAttribute AccommodationDto condition, @PageableDefault Pageable pageable) {
        Page<Accommodation> accommodation = accommodationService.find(condition, user == null ? null : user.getRegionCode(), pageable);
        return TableResult.success(draw, accommodation, accommodationConverter::toDto);
    }

    @GetMapping(params = { "compare" })
    public Object getCompare(@CurrentUser UserDetailsDto user) {
        Long aDouble = accommodationService.getCompare(Accommodation.class);
        return aDouble;
    }

    @Override
    @GetMapping(params = { "api" })
    @ApiOperation(value = "可视化根据参数查询", notes = "getApiList")
    @ApiImplicitParams({ @ApiImplicitParam(name = "api", value = "一个标识随便传", dataType = "Integer"),
            @ApiImplicitParam(name = "params", value = "params时一个Jsonobject 的json字符串,\n" + "格式如下：{\n"
                    + "          condition:{\n"
                    + " 					// chineseFullName,为对应的基础字段名字_后面的一标识需要查询的类型1为eq 既等于 \n"
                    + "          			chineseFullName_1: \"张三\",\n"
                    + "						// parkingLots为被引用的实体,address为被引用实体的字段名,_后面的1 同上，1-14种\n"
                    + "          			parkingLots.address_1: \"北京\"\n" + " 					// 引用自己的or条件\n"
                    + "          			disjunction: [{disjunction：....}],\n"
                    + "						// 引用自己的and条件\n"
                    + "          			conjunction: [{disjunction：....}] \n"
                    + "						} // 如果没有条件不用设置这个属性\n" + " // 如果需要数据分组，请传这这个格式传,如果不用分组不用设置这个属性\n"
                    + "groupby: [\"chineseFullName\",'parkingLots.address'],\n"
                    + " // 如果需要数据排序，请传这这个格式传,如果不用分组不用设置这个属性\n" + "sort:['chineseFullName:desc','parkingLots:asc']\n"
                    + "}\n" + "    EQ(1,\"eq\"),\n" + "    NOT_EQ(2,\"notEq\"),\n" + "    LIKE(3,\"like\"),\n"
                    + "    NOT_LIKE(4,\"notLike\"),\n" + "    LT(5,\"lt\"),\n" + "    LE(6,\"le\"),\n"
                    + "    GT(7,\"gt\"),\n" + "    GE(8,\"ge\"),\n" + "    IN(9,\"in\"),\n"
                    + "    NOT_IN(10,\"notIn\"),\n" + "    IS_NULL(11,\"isNull\"),\n" + "    NOTNULL(12,\"notNull\"),\n"
                    + "    IS_MEMBER(13,\"isMember\"),\n"
                    + "    IS_NOT_MEMBER(14,\"isNotMember\")", dataType = "String", example = "{}") })
    public Object getApiList(@CurrentUser UserDetailsDto user, @RequestParam("params") String jsonStr) {
        JSONObject jsonObject = ParamUtile.paresjson(jsonStr);
        List<Accommodation> list = accommodationService.getByPatams(jsonObject, Accommodation.class);
        return jsonObject.containsKey("pageNum")
                ? new PageInfo<AccommodationDto>(accommodationConverter.toDto(list), jsonObject.getIntValue("pageNum"),
                        jsonObject.getIntValue("pageSize"))
                : accommodationConverter.toDto(list);
    }
}
