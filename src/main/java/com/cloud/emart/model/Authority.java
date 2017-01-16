package com.cloud.emart.model;

import javax.persistence.*;

@Entity
@Table(name="authorities")
public class Authority {
    @Id
    @GeneratedValue
    @Column(name="AUTHORITY_ID")
    private int authorityId;

    private String username;
    private String authority;

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
