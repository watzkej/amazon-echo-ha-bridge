package com.armzilla.ha.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by arm on 4/21/15.
 */
public interface HAGatewayRepository extends ElasticsearchRepository<HAGatewayDao, String> {

    HAGatewayDao findById(String id);
    List<HAGatewayDao> findAll();
}
