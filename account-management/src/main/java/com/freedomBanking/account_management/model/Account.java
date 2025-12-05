package com.freedomBanking.account_management.model;

import com.freedomBanking.account_management.model.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "account_tbl")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "account_number", unique = true, nullable = false, length = 10)
    @NotBlank(message = "Account number is required")
    private String accountNumber;

    @Column(name = "account_name")
    @NotBlank(message = "Account name is required")
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    @NotNull(message = "Account type is required")
    private AccountType accountType;

    @Column(name = "current_balance")
    @DecimalMin(value = "0.00", message = "Balance cannot be negative")
    private BigDecimal currentBalance = BigDecimal.ZERO;

    @Column(name = "available_balance")
    @DecimalMin(value = "0.00", message = "Available balance cannot be negative")
    private BigDecimal avaialbleBalance = BigDecimal.ZERO;

    @Column(name = "minimum_balance")
    @DecimalMin(value = "0.00", message = "Minimum balance cannot be negative")
    private BigDecimal minimumBalance = BigDecimal.ZERO;

    @Column(name = "daily_transaction_limit", precision = 15, scale = 2)
    private BigDecimal dailyTransactionLimit = BigDecimal.ZERO;

    @Column(name = "monthly_transaction_limit", precision = 15, scale = 2)
    private BigDecimal monthlyTransactionLimit = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false)
    @NotNull(message = "Account status is required")
    private AccountStatus accountStatus;

    @Column(name = "interest_rate", precision = 5, scale = 4)
    @DecimalMin(value = "0.00", message = "Interest rate cannot be negative")
    @DecimalMax(value = "100.0000", message = "Interest rate cannot exceed 100%")
    private BigDecimal interestRate;

    @Column(name = "maintenance_fee", precision = 10, scale = 2)
    private BigDecimal maintenanceFee;

    @Enumerated(EnumType.STRING)
    @Column(name = "interest_calculation_type")
    private InterestCalculationType interestCalculationType;

    @Column(name = "branch_code", length = 10)
    private String branchCode;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "opening_channel")
    private OpeningChannel openingChannel;

    @Column(name = "customer_onboardingDate")
    private LocalDateTime customerOnboardingDate;

    @Column(name = "account_activation_date")
    private LocalDateTime accountActivationDate;

    @Column(name = "last_transaction_date")
    private LocalDateTime lastTransactionDate;

    @Column(name = "closure_date")
    private LocalDateTime closureDate;

    @Column(name = "closure_reason", length = 500)
    private String closureReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_status")
    private KYCStatus kycStatus;

    @Column(name = "kyc_completion_date")
    private LocalDateTime kycCompletionDate;

    @Column(name = "sms_notification_enabled")
    private Boolean smsNotificationEnabled = true;

    @Column(name = "email_notification_enabled")
    private Boolean emailNotificationEnabled = true;

    @Column(name = "push_notification_enabled")
    private Boolean pushNotificationEnabled = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "statement_frequency")
    private StatementFrequency statementFrequency;

    @Column(name = "debit_card_enabled")
    private Boolean debitCardEnabled = false;

    @Column(name = "failed_login_attempt")
    private Integer failedLogginAttempts = 0;

    @Column(name = "account_locked_until")
    private LocalDateTime accountLockedUntil;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "notes", length = 1000)
    private String notes;

    @ElementCollection
    @CollectionTable(name = "account_beneficiaries", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "beneficiaries_account_id")
    private List<String> beneficiariesAccountIds;

    // constructors


    // getters













}
