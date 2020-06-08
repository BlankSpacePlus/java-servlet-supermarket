package com.smbs.dao;

import com.smbs.entity.SuperProviders;
import com.smbs.entity.SuperUsers;

import java.util.List;

public interface ProviderDao {

    boolean addProvider(SuperProviders superProviders);

    boolean deleteProviderById(String id);

    boolean updateProvider(SuperProviders superProviders);

    SuperProviders  getProviderById(String id);

    List<SuperProviders> getAllProviders();

}

