package com.cpt.payments.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.modelmapper.ModelMapper;

import org.springframework.jdbc.support.KeyHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import com.cpt.payments.dao.interfaces.TransactionDao;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;


@Component
public class TransactionDaoimpl implements TransactionDao{
	
	@Autowired
	
	private ModelMapper mm;
	
	@Autowired
    private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public TransactionDTO createTransaction(TransactionDTO txnDTO) {

		System.out.println("namedParameterJdbcTemplate: "+ namedParameterJdbcTemplate);
		
		
		TransactionEntity txnEntity = mm.map(txnDTO, TransactionEntity.class);	
		System.out.println("Converted Entity: "+txnEntity  );
		
		
		 String sql = "INSERT INTO `Transaction` (userId, paymentMethodId, providerId, paymentTypeId, txnStatusId, amount, currency, merchantTransactionReference, txnReference, providerReference, providerCode, providerMessage, retryCount) " +
                 "VALUES (:userId, :paymentMethodId, :providerId, :paymentTypeId, :txnStatusId, :amount, :currency, :merchantTransactionReference, :txnReference, :providerReference, :providerCode, :providerMessage, :retryCount)";

		 KeyHolder keyholder = new GeneratedKeyHolder();
		 
		 BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(txnEntity);

		  int insertedRowCount = namedParameterJdbcTemplate.update(sql, params,keyholder,new String[] {"id"});
		
		  int transactionId = keyholder.getKey().intValue();
		  
		  txnDTO.setId(transactionId);
		  
		  System.out.println("Inserted Row Count: "+ insertedRowCount+"TransactionId: "+transactionId);
		  
		return txnDTO;
	}
	
	@Override
	public TransactionDTO getTransactionById(int id)
	{
		 String sql = "SELECT * FROM Transaction WHERE id = ?";

		TransactionEntity retrieveTransaction = jdbcTemplate.queryForObject(sql, new Object[]{id}, 
	            BeanPropertyRowMapper.newInstance(TransactionEntity.class));   
		
		System.out.println("Retrieve the Transaction By Id in DAO Layer || "
				+ "retrieveTransaction: "+retrieveTransaction);
		
		return mm.map(retrieveTransaction, TransactionDTO.class);
	       
	}
}
