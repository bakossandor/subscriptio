package com.subscriptio.main.services;

import com.subscriptio.main.models.Campaign;

import java.util.UUID;

public interface CampaignService {
    Campaign createCampaign(Campaign campaign);
    void deleteCampaign(UUID id);
    Campaign retriveCampaign(UUID id);
}
