package com.subscriptio.main.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project extends BaseEntity {

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_url")
    private String projectUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="id", cascade = CascadeType.ALL)
    private List<Campaign> campaigns;

}
