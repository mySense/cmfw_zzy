package com.baizhi.zzy.service;

import com.baizhi.zzy.advice.LogAnnotation;
import com.baizhi.zzy.entity.Chapter;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface ChapterService {
    @LogAnnotation(description = "插入音频")
    void save(Chapter chapter);
    @LogAnnotation(description = "修改音频")
    void update(Chapter chapter);
}
