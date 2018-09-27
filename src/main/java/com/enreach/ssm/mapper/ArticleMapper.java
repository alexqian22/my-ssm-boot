package com.enreach.ssm.mapper;

import com.enreach.ssm.entity.Article;
import com.enreach.ssm.infrastructure.IMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.springframework.cache.annotation.CacheConfig;

/**
 * 这里直接使用 mybaits自带的二级缓存，
 * 其他缓存使用 google库 或 自定义redis
 */
@CacheNamespace(flushInterval = 60000)
public interface ArticleMapper extends IMapper<Article> {

}