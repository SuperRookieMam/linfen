package com.dm.linfen.emergency.service.impl;

import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.QSentiment;
import com.dm.linfen.emergency.entity.Sentiment;
import com.dm.linfen.emergency.repository.SentimentRepository;
import com.dm.linfen.emergency.service.SentimentService;
import com.dm.linfen.emergency.util.DateUtil;
import com.dm.linfen.emergency.vo.VolumeVO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 温东山
 * @create 2019-07-22 15:58
 **/
@Service
public class SentimentServiceImpl implements SentimentService {

    @Autowired
    private SentimentRepository sentimentRepository;

    private final static QSentiment QSENTIMENT = QSentiment.sentiment;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<Sentiment> findById(Long id) {
        return sentimentRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Sentiment save(Sentiment sentiment) {
        return sentimentRepository.save(sentiment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Sentiment update(Sentiment sentiment) {
        if (sentiment == null || sentiment.getId() == null) {
            throw new DataValidateException("数据不存在!");
        }
        if (!sentimentRepository.findById(sentiment.getId()).isPresent()) {
            throw new DataValidateException("数据不存在!");
        }
        return sentimentRepository.saveAndFlush(sentiment);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        sentimentRepository.deleteById(id);
    }

    @Override
    public Page<Sentiment> findSentiments(Sentiment sentiment, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.isNotBlank(sentiment.getTitle())) {
            builder.and(QSENTIMENT.title.containsIgnoreCase(sentiment.getTitle()));
        }
        if (StringUtils.isNotBlank(sentiment.getMediaType())) {
            builder.and(QSENTIMENT.mediaType.eq(sentiment.getMediaType()));
        }
        if (StringUtils.isNotBlank(sentiment.getSentimentType())) {
            builder.and(QSENTIMENT.sentimentType.eq(sentiment.getSentimentType()));
        }
        return sentimentRepository.findAll(builder, pageable);
    }

    @Override
    public Map<String, Object> findVolumeStatistics(Integer num) {
        Map<String, Object> map = new HashMap<>(16);
        List<String> topNum = DateUtil.getTopNum(num);
        List<VolumeVO> initOne = new ArrayList<>(16);
        List<VolumeVO> initTwo = new ArrayList<>(16);
        for (String s : topNum) {
            initOne.add(new VolumeVO(s, 0, "1"));
            initTwo.add(new VolumeVO(s, 0, "0"));
        }
        List<VolumeVO> volumeStatistics = findVolumeStatistics(topNum.get(0), topNum.get(num - 1));
        setInitList(initOne, volumeStatistics);
        setInitList(initTwo, volumeStatistics);
        map.put("敏感", initOne);
        map.put("非敏感", initTwo);
        return map;
    }

    @Override
    public List<Map<String, String>> findMediaStatistics() {
        JPAQuery<Sentiment> query = new JPAQuery<>(entityManager);
        List<Tuple> fetch = query.select(QSENTIMENT.mediaType, QSENTIMENT.count()).from(QSENTIMENT)
                .where(QSENTIMENT.createTime.between(ZonedDateTime.now().withDayOfYear(1), ZonedDateTime.now()))
                .groupBy(QSENTIMENT.mediaType).orderBy(QSENTIMENT.count().desc()).fetch();
        return fetch.stream().map(tuple -> {
            Map<String, String> m = new HashMap<>(16);
            m.put("mediaType", tuple.get(QSENTIMENT.mediaType));
            m.put("count", tuple.get(QSENTIMENT.count()) + "");
            return m;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> findRegionStatistics() {
        JPAQuery<Sentiment> query = new JPAQuery<>(entityManager);
        List<Tuple> fetch = query.select(QSENTIMENT.province, QSENTIMENT.count()).from(QSENTIMENT)
                .where(QSENTIMENT.createTime.between(ZonedDateTime.now().withDayOfYear(1), ZonedDateTime.now()))
                .groupBy(QSENTIMENT.province).orderBy(QSENTIMENT.count().desc()).fetch();
        return fetch.stream().map(tuple -> {
            Map<String, String> m = new HashMap<>(16);
            m.put("province", tuple.get(QSENTIMENT.province));
            m.put("count", tuple.get(QSENTIMENT.count()) + "");
            return m;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> findSentimentMax() {
        JPAQuery<Sentiment> query = new JPAQuery<>(entityManager);
        List<Tuple> fetch = query.select(QSENTIMENT.sentimentType, QSENTIMENT.count()).from(QSENTIMENT)
                .where(QSENTIMENT.createTime.between(ZonedDateTime.now().withDayOfYear(1), ZonedDateTime.now()))
                .groupBy(QSENTIMENT.sentimentType).orderBy(QSENTIMENT.count().desc()).fetch();
        return fetch.stream().map(tuple -> {
            Map<String, String> m = new HashMap<>(16);
            m.put("sentimentType", tuple.get(QSENTIMENT.sentimentType));
            m.put("count", tuple.get(QSENTIMENT.count()) + "");
            return m;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> findSentimentList(Pageable pageable) {
        JPAQuery<Sentiment> query = new JPAQuery<>(entityManager);
        List<Tuple> fetch = query.select(QSENTIMENT.id, QSENTIMENT.source, QSENTIMENT.viewCount, QSENTIMENT.title)
                .from(QSENTIMENT).orderBy(QSENTIMENT.createTime.desc()).offset(pageable.getPageNumber())
                .limit(pageable.getPageSize()).fetch();
        return fetch.stream().map(tuple -> {
            Map<String, String> m = new HashMap<>(16);
            m.put("id", tuple.get(QSENTIMENT.id) + "");
            m.put("source", tuple.get(QSENTIMENT.source));
            m.put("viewCount", tuple.get(QSENTIMENT.viewCount) + "");
            m.put("title", tuple.get(QSENTIMENT.title));
            return m;
        }).collect(Collectors.toList());
    }

    public List<VolumeVO> findVolumeStatistics(String startDate, String endDate) {
        Query nativeQuery = entityManager.createNativeQuery(
                "SELECT DATE_FORMAT(create_time_,'%Y%m') dataTime,count(*) as count ,volume_ as volumeName from t_sentiment where DATE_FORMAT(create_time_,'%Y%m')>=? and DATE_FORMAT(create_time_,'%Y%m')<=? GROUP BY DATE_FORMAT(create_time_,'%Y%m'),volume_");
        nativeQuery.setParameter(1, startDate);
        nativeQuery.setParameter(2, endDate);
        List<Object[]> resultList = nativeQuery.getResultList();
        List<VolumeVO> datas = new ArrayList<>();
        VolumeVO volumeVO = null;
        for (Object[] data : resultList) {
            volumeVO = new VolumeVO(data[0].toString(), Integer.parseInt(data[1].toString()), data[2].toString());
            datas.add(volumeVO);
        }
        return datas;

    }

    private void setInitList(List<VolumeVO> inits, List<VolumeVO> volumeStatistics) {
        for (VolumeVO volumeVO : inits) {
            for (VolumeVO volumeStatistic : volumeStatistics) {
                if (volumeVO.getDataTime().equals(volumeStatistic.getDataTime())
                        && volumeVO.getVolumeName().equals(volumeStatistic.getVolumeName())) {
                    volumeVO.setCount(volumeStatistic.getCount());
                }
            }
        }
    }
}
