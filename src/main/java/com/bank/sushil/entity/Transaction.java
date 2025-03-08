package com.bank.sushil.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String txId;
	private Double amount;
	private Double txFee;
	private String sender;
	private String receiver;
	
	private Status status;
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "card_id")
	private Card card;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Userz owner;	

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	


}
