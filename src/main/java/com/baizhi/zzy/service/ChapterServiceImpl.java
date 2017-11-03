package com.baizhi.zzy.service;

import com.baizhi.zzy.dao.ChapterDAO;
import com.baizhi.zzy.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterDAO chapterDAO;
    public void save(Chapter chapter) {
        chapter.setId(UUID.randomUUID().toString().replace("-",""));
        chapterDAO.save(chapter);
    }

    public void update(Chapter chapter) {
            chapterDAO.update(chapter);
    }
}
