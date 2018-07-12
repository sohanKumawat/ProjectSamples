package com.mb.demo.repository.picker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.demo.constants.PickPackConstants.OperationType;
import com.mb.demo.entity.common.picker.PickerProductStatusEntity;

@Repository
public interface PickerProductStratusRepository extends JpaRepository<PickerProductStatusEntity, Long> {

	public PickerProductStatusEntity findByProductIdAndHubIdAndTeamIdAndSheetAndCreatedOn(long productId, long hubId,
			long teamId, String sheet, String createdOn);

	public PickerProductStatusEntity findByProductIdAndHubIdAndTeamIdAndSheetAndPickerTypeAndCreatedOn(long productId,
			long hubId, long teamId, String sheet, OperationType pickerType, String createdOn);

	public List<PickerProductStatusEntity> findByProductIdAndHubIdAndTeamIdAndSheet(long productId, long hubId,
			long teamId, String sheet);

	public List<PickerProductStatusEntity> findByProductIdAndHubIdAndTeamIdAndSheetAndPickerType(long productId,
			long hubId, long teamId, String sheet, OperationType pickerType);

	public List<PickerProductStatusEntity> findByHubIdAndTeamIdAndSheetAndPickerTypeAndCreatedOn(long hubId,
			long teamId, String sheet, OperationType pickerType, String createdOn);

	public List<PickerProductStatusEntity> findByHubIdAndTeamIdAndSheetAndPickerType(long hubId, long teamId,
			String sheet, OperationType pickerType);

	public List<PickerProductStatusEntity> findByHubIdAndTeamIdAndPickerType(long hubId, long teamId,
			OperationType pickerType);

	public List<PickerProductStatusEntity> findByProductIdAndHubIdAndTeamId(long productId, long hubId, long teamId);

	public List<PickerProductStatusEntity> findByProductIdAndHubIdAndTeamIdAndCreatedOn(long productId, long hubId,
			long teamId, String createdOn);

	public List<PickerProductStatusEntity> findByProductIdAndHubIdAndCreatedOn(long productId, long hubId,
			String createdOn);

	public List<PickerProductStatusEntity> findByHubIdAndTeamIdAndCreatedOn(long hubId, long teamId, String createdOn);

	public List<PickerProductStatusEntity> findByHubIdAndTeamIdAndSheetAndCreatedOn(long hubId, long teamId, String sheet,
			String createdOn);

}
