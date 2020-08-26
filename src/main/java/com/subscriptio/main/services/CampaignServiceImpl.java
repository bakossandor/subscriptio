package com.subscriptio.main.services;

import com.subscriptio.main.models.Campaign;
import com.subscriptio.main.repositories.CampaignRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class CampaignServiceImpl implements CampaignService {

    private CampaignRepository cpr;

    public CampaignServiceImpl(CampaignRepository cpr) {
        this.cpr = cpr;
    }

    @Override
    public Campaign createCampaign(Campaign campaign) {
        return cpr.save(campaign);
    }

    @Override
    public void deleteCampaign(UUID id) {
        cpr.deleteById(id);
    }

    @Override
    public Campaign retriveCampaign(UUID id) {
        Optional<Campaign> campaign = cpr.findById(id);
        if (campaign.isPresent()) {
            return campaign.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find campaign resource");
        }
    }
}
