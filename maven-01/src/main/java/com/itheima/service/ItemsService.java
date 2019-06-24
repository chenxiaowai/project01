package com.itheima.service;

import com.itheima.domain.Items;

/**
 * 业务层接口
 */
public interface ItemsService {
    /**
     * 根据id查询items
     * @param id
     * @return
     */
    Items findById(Integer id);
}
