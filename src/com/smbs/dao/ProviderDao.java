package com.smbs.dao;

import com.smbs.entity.SuperProviders;

import java.util.List;

public interface ProviderDao {

    boolean addProvider(SuperProviders superProviders);

    boolean deleteProviderById(String id);

    boolean updateProvider(SuperProviders superProviders);

    SuperProviders  getProviderById(String id);

    List<SuperProviders> getAllProviders();

    List<SuperProviders> search(String search_name, String search_desc);

}

