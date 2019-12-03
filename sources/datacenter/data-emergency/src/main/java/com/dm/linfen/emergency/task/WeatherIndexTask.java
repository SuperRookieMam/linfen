package com.dm.linfen.emergency.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dm.linfen.emergency.entity.District;
import com.dm.linfen.emergency.entity.EnvironmentHour;
import com.dm.linfen.emergency.entity.EnvironmentHourBean;
import com.dm.linfen.emergency.entity.HealthIndex;
import com.dm.linfen.emergency.repository.DistinctRepository;
import com.dm.linfen.emergency.repository.EnvironmentHourRepository;
import com.dm.linfen.emergency.repository.HealthIndexRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
* @Description:    天气指数详细列表,按照每小时统计一次
* @Author:         温东山
* @CreateDate:     2019/7/30 0030 11:14
* @UpdateUser:     温东山
* @UpdateDate:     2019/7/30 0030 11:14
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Slf4j
@Component
public class WeatherIndexTask {

    @Autowired
    private DistinctRepository dr;

    @Autowired
    private EnvironmentHourRepository ehr;

    @Autowired
    HealthIndexRepository healthIndexRepository;

    @Scheduled(cron = "0 15 0/1 * * ?") // 每1个小时执行一次
    /**
     * 抓取各项指数 0 2 1 * * ?
     */
    public void reptilePollutantIndex() {
        log.info("数据抓取开始");
        try {
            List<District> districts = dr.findAll();
            for (District dis : districts) {
                Document document = null;
                try {
                    document = Jsoup.connect("http://d1.weather.com.cn/aqi_all/" + dis.getDistrictId() + ".html")
                            .ignoreContentType(true)
                            .timeout(30000)
                            .header("Referer", "http://www.weather.com.cn/air/?city=" + dis.getDistrictId())
                            .header("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36")
                            .get();
                } catch (Exception e) {
                    log.error("抓取数据失败{}", e);
                    continue;
                }
                String var = null;
                try {
                    var = document.body().text().split("\\(")[1].split("\\)")[0];
                } catch (ArrayIndexOutOfBoundsException e) {
                    log.error("解析js数据失败={}", e);
                    continue;
                }
                JSONArray data = JSONObject.parseObject(var).getJSONArray("data");
                LocalDate now = LocalDate.now().minusDays(1);
                /**
                 * 由于数据升序
                 */
                for (int i =0;i< data.size();i++) {
                    /**
                     * 查询当前时间是否有数据
                     */

                    EnvironmentHourBean bean = data.getObject(i, EnvironmentHourBean.class);
                    if(i>0&&bean.getTime().equals("00")){
                        now= LocalDate.now();
                    }
                    String date =now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))+bean.getTime();
                    EnvironmentHour eh = ehr.findByDateAndDistrictId(date, dis.getDistrictId());
                    if (eh == null) {
                        eh = new EnvironmentHour();
                        eh.setDate(date);
                        eh.setDistrictId(dis.getDistrictId());
                        eh.setDistrictName(dis.getDistrictName());
                    }
                    setBean(eh, bean);
                    ehr.save(eh);
                }
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            log.error("操作数据失败={}", e);
        } catch (Exception e) {
            log.error("操作数据失败={}", e);
        }
    }

    /**
     * 设置数据
     * @param eh
     * @param bean
     */
    private void setBean(EnvironmentHour eh, EnvironmentHourBean bean) {
        eh.setAirQuality(bean.getT1());
        eh.setPm10(bean.getT4());
        eh.setCo(bean.getT5());
        eh.setNo2(bean.getT6());
        eh.setOzone(bean.getT7());
        eh.setSo2(bean.getT9());
        eh.setPm25(bean.getT10());
        eh.setWindPower(bean.getT11());
        eh.setHumidity(bean.getT12());
        eh.setRainfall(bean.getT13());
        eh.setWindDirection(bean.getT14());
        eh.setTemperature(bean.getT15());
    }

    /**
     * 抓取指数信息
     */
    @Scheduled(cron = "0 0 1,4,8,10,15 * * ?")
    public void reptileHealthIndex() {
        log.info("数据抓取开始");
        try {
            List<District> districts = dr.findAll();
            for (District dis : districts) {
                Document document = null;
                try {
                    document = Jsoup.connect("http://d1.weather.com.cn/weather_index/" + dis.getDistrictId() + ".html")
                            .ignoreContentType(true)
                            .timeout(30000)
                            .header("Referer", "http://www.weather.com.cn/air/?city=" + dis.getDistrictId())
                            .header("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.80 Safari/537.36")
                            .get();
                } catch (Exception e) {
                    log.error("抓取数据失败{}", e);
                    continue;
                }
                String data = null;
                try {
                    data = document.body().text().split("\\(")[1].split("\\)")[1].split("=")[1].split(";")[0];
                } catch (ArrayIndexOutOfBoundsException e) {
                    log.error("解析js数据失败={}", e);
                    continue;
                }
                LocalDate now=LocalDate.now();
                HealthIndex healthIndex=healthIndexRepository.findByCollectTimeAndDistrictId(now,dis.getDistrictId());
                if(healthIndex==null){
                    healthIndex=new HealthIndex();
                    healthIndex.setCollectTime(now);
                    healthIndex.setDistrictId(dis.getDistrictId());
                    healthIndex.setDistrictName(dis.getDistrictName());
                }
                healthIndex.setInfo(data);
                healthIndexRepository.save(healthIndex);
            }
        }catch (Exception e){
            log.error("解析数据失败{}", e);
        }
    }
}
