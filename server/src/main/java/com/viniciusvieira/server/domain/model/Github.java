package com.viniciusvieira.server.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class Github {
    @Column(name = "github_id")
    @JsonProperty("github_id")
    private int id;

    private String login;

    private String name;

    @Column(name = "avatar_url")
    @JsonProperty("avatar_url")
    private String avatarUrl;
}
