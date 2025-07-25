package com.freedomBanking.authManagement.model;

import com.freedomBanking.enums.RoleName;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long roleId;

    private RoleName roleName;

    private Integer grantedBy;

    private LocalDateTime grantedAt;

    private LocalDateTime expireAt;

    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    // Getters and Setters //


    // Constructors //


    public Roles(RoleName roleName, User user) {
        this.roleName = roleName;
        this.isActive = isActive;
        this.user = user;
    }
}
