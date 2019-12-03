package com.dm.linfen.emergency.service.impl;

import com.dm.common.exception.DataValidateException;
import com.dm.linfen.emergency.entity.HotWord;
import com.dm.linfen.emergency.entity.QHotWord;
import com.dm.linfen.emergency.entity.Sentiment;
import com.dm.linfen.emergency.repository.HotWordRepository;
import com.dm.linfen.emergency.service.HotWordService;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 温东山
 * @create 2019-07-22 17:17
 **/
@Service
public class HotWordServiceImpl implements HotWordService {

    @Autowired
    HotWordRepository repository;

    private final static QHotWord QHOTWORD = QHotWord.hotWord;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<HotWord> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HotWord save(HotWord hotWord) {
        return repository.save(hotWord);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public HotWord update(HotWord hotWord) {
        if (hotWord == null || hotWord.getId() == null) {
            throw new DataValidateException("数据不存在!");
        }
        if (!repository.findById(hotWord.getId()).isPresent()) {
            throw new DataValidateException("数据不存在!");
        }
        return repository.saveAndFlush(hotWord);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<HotWord> findHotWords(HotWord hotWord, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.isNotBlank(hotWord.getKeyword())) {
            builder.and(QHOTWORD.keyword.containsIgnoreCase(hotWord.getKeyword()));
        }
        return repository.findAll(builder, pageable);
    }

    @Override
    public List<Map<String, String>> findKeywordStatistics(String type) {
        JPAQuery<Sentiment> query = new JPAQuery<>(entityManager);
        JPAQuery<Tuple> from = query.select(QHOTWORD.keyword, QHOTWORD.count()).from(QHOTWORD);
        if (StringUtils.isNotEmpty(type)) {
            from.where(QHOTWORD.createTime.between(LocalDate.now().withDayOfYear(1), LocalDate.now())
                    .and(QHOTWORD.type.eq(type)));
        } else {
            from.where(QHOTWORD.createTime.between(LocalDate.now().withDayOfYear(1), LocalDate.now()));
        }
        List<Tuple> fetch = from.groupBy(QHOTWORD.keyword).orderBy(QHOTWORD.count().desc()).fetch();
        return fetch.stream().map(tuple -> {
            Map<String, String> m = new HashMap<>(16);
            m.put("keyword", tuple.get(QHOTWORD.keyword));
            m.put("count", tuple.get(QHOTWORD.count()) + "");
            return m;
        }).collect(Collectors.toList());
    }
}
