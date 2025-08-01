package com.entity.git.supportEntities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "login",
    "id",
    "avatar_url",
    "gravatar_id",
    "url",
    "html_url",
    "followers_url",
    "following_url",
    "gists_url",
    "starred_url",
    "subscriptions_url",
    "organizations_url",
    "repos_url",
    "events_url",
    "received_events_url",
    "type",
    "site_admin",
    "name",
    "company",
    "blog",
    "location",
    "email",
    "hireable",
    "bio",
    "public_repos",
    "public_gists",
    "followers",
    "following",
    "created_at",
    "updated_at"
})
@Generated("jsonschema2pojo")
public class RawInfo {

    @JsonProperty("login")
    public String login;

    @JsonProperty("id")
    public String id;

    @JsonProperty("avatar_url")
    public String avatarUrl;

    @JsonProperty("gravatar_id")
    public String gravatarId;

    @JsonProperty("url")
    public String url;

    @JsonProperty("html_url")
    public String htmlUrl;

    @JsonProperty("followers_url")
    public String followersUrl;

    @JsonProperty("following_url")
    public String followingUrl;

    @JsonProperty("gists_url")
    public String gistsUrl;

    @JsonProperty("starred_url")
    public String starredUrl;

    @JsonProperty("subscriptions_url")
    public String subscriptionsUrl;

    @JsonProperty("organizations_url")
    public String organizationsUrl;

    @JsonProperty("repos_url")
    public String reposUrl;

    @JsonProperty("events_url")
    public String eventsUrl;

    @JsonProperty("received_events_url")
    public String receivedEventsUrl;

    @JsonProperty("type")
    public String type;

    @JsonProperty("site_admin")
    public Boolean siteAdmin;

    @JsonProperty("name")
    public String name;

    @JsonProperty("company")
    public Object company;

    @JsonProperty("blog")
    public Object blog;

    @JsonProperty("location")
    public String location;

    @JsonProperty("email")
    public String email;

    @JsonProperty("hireable")
    public Object hireable;

    @JsonProperty("bio")
    public Object bio;

    @JsonProperty("public_repos")
    public Integer publicRepos;

    @JsonProperty("public_gists")
    public Integer publicGists;

    @JsonProperty("followers")
    public Integer followers;

    @JsonProperty("following")
    public Integer following;

    @JsonProperty("created_at")
    public String createdAt;

    @JsonProperty("updated_at")
    public String updatedAt;
}
