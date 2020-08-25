package com.subscriptio.main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@Entity
@Table(name = "campaigns")
public class Campaign extends BaseEntity{

    @Column(name = "campaign_subject")
    private String campaignSubject;

    @Column(name = "campaign_content")
    private String campaignContent;

    @Lob
    @Column(name = "campaign_attachment")
    private Blob campaignAttachment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
}
