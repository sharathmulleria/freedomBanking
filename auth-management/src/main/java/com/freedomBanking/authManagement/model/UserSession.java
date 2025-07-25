package com.freedomBanking.authManagement.model;

import com.freedomBanking.dto.common.CommonUtils;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UserSession extends CommonUtils {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    private String ipAddress;

    private String userAgent;

    private String deviceFingerPrint;

    private LocalDateTime loginTime;

    private LocalDateTime lastActivity;

    private LocalDateTime expiresAt;

    private Boolean isActive;

    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
