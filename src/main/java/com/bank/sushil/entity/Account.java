package com.bank.sushil.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String accountId;
	
	private String accountName;
	
	@Column(unique = true, nullable = false)
	private long accountNumber;
	private double balance;
	
	private char symbol;
	private String currency;
	private String code;
	private String label;

	private Status status;
	private Type type;
	
	@CreationTimestamp
	private LocalDate createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Transaction> transactions;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Userz owner;


}
