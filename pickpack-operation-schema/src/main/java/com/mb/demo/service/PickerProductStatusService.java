package com.mb.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.picker.PickerProductStatusEntity;
import com.mb.demo.repository.picker.PickerProductStratusRepository;

@Service
public class PickerProductStatusService implements BasePickerServcie<PickerProductStatusEntity> {

	@Autowired
	PickerProductStratusRepository ppsRepository;

	@Override
	public PickerProductStatusEntity add(PickerProductStatusEntity entity) {
		return ppsRepository.save(entity);
	}

	@Override
	public PickerProductStatusEntity getById(long id) {
		// TODO Auto-generated method stub
		return ppsRepository.findById(id).orElse(null);
	}

	@Override
	public List<PickerProductStatusEntity> getAll() {
		return ppsRepository.findAll();
	}

	@Override
	public void deleteById(long id) {
		ppsRepository.deleteById(id);

	}

	@Override
	public PickerProductStatusEntity update(PickerProductStatusEntity entity) {
		return ppsRepository.save(entity);

	}

	public List<PickerProductStatusEntity> findPickerProductStatus(long productId, long hubId, long teamId,
			String sheet) {
		return ppsRepository.findByProductIdAndHubIdAndTeamIdAndSheet(productId, hubId, teamId, sheet);
	}

	public PickerProductStatusEntity findPickerProductStatus(long productId, long hubId, long teamId, String sheet,
			OperationType pickerType, String createdOn) {
		return ppsRepository.findByProductIdAndHubIdAndTeamIdAndSheetAndPickerTypeAndCreatedOn(productId, hubId, teamId,
				sheet, pickerType, createdOn);
	}

	public List<PickerProductStatusEntity> findPickerProductStatus(long hubId, long teamId, String sheet,
			OperationType pickerType, String createdOn) {
		return ppsRepository.findByHubIdAndTeamIdAndSheetAndPickerTypeAndCreatedOn(hubId, teamId, sheet, pickerType,
				createdOn);
	}

	public PickerProductStatusEntity findPickerProductStatus(long productId, long hubId, long teamId, String sheet,
			String createdOn) {
		return ppsRepository.findByProductIdAndHubIdAndTeamIdAndSheetAndCreatedOn(productId, hubId, teamId, sheet,
				createdOn);
	}

	public List<PickerProductStatusEntity> findPickerProductStatus(long productId, long hubId, long teamId) {
		return ppsRepository.findByProductIdAndHubIdAndTeamId(productId, hubId, teamId);
	}

	public List<PickerProductStatusEntity> findPickerCurrentProductStatus(long productId, long hubId, long teamId,
			String createdOn) {
		return ppsRepository.findByProductIdAndHubIdAndTeamIdAndCreatedOn(productId, hubId, teamId, createdOn);
	}

	/*
	 * public List<PickerProductStatusEntity> findPickerProductStatus(long
	 * productId, long hubId, String createdOn) { return
	 * ppsRepository.findByProductIdAndHubIdAndCreatedOn(productId, hubId,
	 * createdOn); }
	 */
	public List<PickerProductStatusEntity> findPickerProductStatus(long hubId, long teamId, String createdOn) {
		return ppsRepository.findByHubIdAndTeamIdAndCreatedOn(hubId, teamId, createdOn);
	}

	public List<PickerProductStatusEntity> findPickerProductStatus(long hubId, long teamId, String sheet,
			String createdOn) {
		return ppsRepository.findByHubIdAndTeamIdAndSheetAndCreatedOn(hubId, teamId, sheet, createdOn);
	}

}
