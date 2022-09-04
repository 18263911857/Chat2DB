package com.alibaba.dataops.server.tools.base.wrapper.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.dataops.server.tools.base.constant.EasyToolsConstant;
import com.alibaba.dataops.server.tools.base.enums.OrderByDirectionEnum;

import lombok.Data;

/**
 * 查询的参数
 *
 * @author zhuangjiaju
 * @date 2021/06/26
 */
@Data
public class QueryParam implements Serializable {
    private static final long serialVersionUID = EasyToolsConstant.SERIAL_VERSION_UID;

    /**
     * 排序
     */
    private List<OrderBy> orderByList;

    /**
     * 新增一个排序 并替换原有排序
     *
     * @param orderBy 排序
     * @return 排序参数
     */
    public QueryParam orderBy(OrderBy orderBy) {
        orderByList = new ArrayList<>();
        orderByList.add(orderBy);
        return this;
    }

    /**
     * 新增一个排序 并替换原有排序
     *
     * @param orderConditionName 排序字段
     * @param direction          排序方向
     * @return 排序参数
     */
    public QueryParam orderBy(String orderConditionName, OrderByDirectionEnum direction) {
        return orderBy(new OrderBy(orderConditionName, direction));
    }

    /**
     * 新增一个排序 并替换原有排序
     *
     * @param orderCondition 排序条件
     * @return 排序参数
     */
    public QueryParam orderBy(OrderCondition orderCondition) {
        return orderBy(orderCondition.getOrderBy());
    }

    /**
     * 新增一个排序
     *
     * @param orderBy 排序
     * @return 排序参数
     */
    public QueryParam andOrderBy(OrderBy orderBy) {
        orderByList.add(orderBy);
        return this;
    }

    /**
     * 新增一个排序
     *
     * @param orderConditionName 排序字段
     * @param direction          排序方向
     * @return 排序参数
     */
    public QueryParam andOrderBy(String orderConditionName, OrderByDirectionEnum direction) {
        return andOrderBy(new OrderBy(orderConditionName, direction));
    }

    /**
     * 新增一个排序
     *
     * @param orderCondition 排序条件
     * @return 排序参数
     */
    public QueryParam andOrderBy(OrderCondition orderCondition) {
        return andOrderBy(orderCondition.getOrderBy());
    }

}
