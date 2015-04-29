package com.armzilla.ha.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by arm on 4/21/15.
 */
public interface HADeviceRepository extends ElasticsearchRepository<HADeviceDao, String> {
}
