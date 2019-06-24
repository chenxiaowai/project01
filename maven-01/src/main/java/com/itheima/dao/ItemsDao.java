package com.itheima.dao;

import com.itheima.domain.Items;

/**
 * Items持久层接口
 */

public interface ItemsDao {

    /**
     * 根据id查询items
     * @param id
     * @return
     */
     Items findById(Integer id);
}
