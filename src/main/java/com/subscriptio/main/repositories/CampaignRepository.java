package com.subscriptio.main.repositories;

import com.subscriptio.main.models.Campaign;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CampaignRepository extends CrudRepository<Campaign, UUID> {

}
