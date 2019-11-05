package com.dm.linfen.enums;

/**
 * 资源代码
 *
 * @author Administrator
 *
 */
public enum NoEnums {

	旅游目的地("10101"), 旅游管理部门("10102"), 旅游组织协会("10103"), 旅游活动("10104"), 演出会展("10105"), 旅游景区("10201"), 乡村旅游("10202"),
	旅游城镇("10203"), 特色街道("10204"), 特色旅游场所("10205"), 新兴业态("10206"), 公园步道("10207"), 科技文化馆("10208"), 旅行社("10301"),
	导游服务公司("10302"), 住宿场所("10303"), 餐饮场所("10304"), 购物场所("10305"), 娱乐场所("10306"), 汽车服务公司("10307"), 航空("10401"),
	铁路("10402"), 公路("10403"), 水运("10404"), 旅游大巴("10405"), 公交车("10406"), 轨道交通("10407"), 出租车("10408"), 汽车租赁公司("10409"),
	自行车租赁点("10410"), 金融网点("10501"), 药房药店("10502"), 医院("10503"), 消防队("10504"), 派出所("10505"), 旅游厕所("10506"),
	旅游咨询中心("10507"), 旅游集散中心("10508"), 旅游监控点("10509"), 旅游院校("10510"), 加油站("10511"), 加气站("10512"), 停车场("10513"),
	团队成员("10514"), 团队填报("10515"), 空气质量("10516");
	private String value;

	NoEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static NoEnums getEnum(String value) {
		for (NoEnums v : values())
			if (v.getValue().equals(value))
				return v;
		throw new IllegalArgumentException();
	}
}
