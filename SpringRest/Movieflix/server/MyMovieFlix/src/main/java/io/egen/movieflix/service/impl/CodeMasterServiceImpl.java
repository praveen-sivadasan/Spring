package io.egen.movieflix.service.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.movieflix.entity.CodeMaster;
import io.egen.movieflix.generic.respository.GenericRepositoryImpl;
import io.egen.movieflix.utils.ApplicationLogger;

@Service
public class CodeMasterServiceImpl extends GenericRepositoryImpl<CodeMaster> {

	@Autowired
	ApplicationLogger log;
	
	public CodeMasterServiceImpl() throws Exception {
		super();
	}

	//@Cacheable(value = "codeMasterCache", key = "#name")
	public List<CodeMaster> fetchCodeMaster() {
		try {
			Query query = em.createQuery("Select cm from CodeMaster cm");
			@SuppressWarnings("unchecked")
			List<CodeMaster> codeMasters = query.getResultList();
			return codeMasters;
		} catch (Exception e) {
			log.error("ApplicationServiceImpl - fetchCodeMaster -" + e.getMessage());
		}
		return null;
	}
	
	public CodeMaster findCodeMasterByValue(String value) throws Exception{
		Query query = em.createQuery("Select cm from CodeMaster cm where cm.value = :value");
		query.setParameter("value",value);
		return (CodeMaster) query.getSingleResult();
	}
	
	public CodeMaster findCodeMasterById(Integer Id) throws Exception{
		Query query = em.createQuery("Select cm from CodeMaster cm where cm.codeMasterIdPk = :Id");
		query.setParameter("Id",Id);
		return (CodeMaster) query.getSingleResult();
	}

}
