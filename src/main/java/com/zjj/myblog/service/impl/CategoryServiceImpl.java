package com.zjj.myblog.service.impl;

import com.zjj.myblog.entity.Category;
import com.zjj.myblog.mapper.CategoryMapper;
import com.zjj.myblog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2020-07-12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
