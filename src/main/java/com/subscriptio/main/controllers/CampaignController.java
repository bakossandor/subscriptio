package com.subscriptio.main.controllers;

import com.subscriptio.main.models.Campaign;
import com.subscriptio.main.models.Project;
import com.subscriptio.main.services.CampaignService;
import com.subscriptio.main.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class CampaignController {

    private CampaignService campaignService;
    private ProjectService projectService;

    public CampaignController(CampaignService campaignService, ProjectService projectService) {
        this.campaignService = campaignService;
        this.projectService = projectService;
    }

    @PostMapping("/projects/{id}/campaigns")
    String createCampaign(@PathVariable("id")UUID id, @ModelAttribute Campaign campaign) {
        Project project = projectService.retriveProject(id);
        campaign.setProject(project);
        Campaign savedCampaign = campaignService.createCampaign(campaign);

        return "redirect:/projects/" + id;
    }

/*    @GetMapping("/projects/{id}/campaigns/{cid}")
    String createCampaign(@PathVariable("id")UUID id, @PathVariable("cid")UUID cid) {

    }*/
}
