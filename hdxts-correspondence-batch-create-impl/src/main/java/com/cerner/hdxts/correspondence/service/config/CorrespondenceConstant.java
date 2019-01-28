package com.cerner.hdxts.correspondence.service.config;

public interface CorrespondenceConstant 
{
	public static final String PARTNER_QUEUE_ERROR = "PARTNER_QUEUE_ERROR";
	public static final String VALIDATED = "VALIDATED";
	public static final String QUEUED = "QUEUED";
	public static final String NONE = "NONE";
	public static final String STATEMENTS_REQUEST_BO = "STATEMENTS_REQUEST_BO";
	public static final String CORRESPONDENCE_STATEMENTS = "CORRESPONDENCE_STATEMENTS";
	public static final String CORRESPONDENCE_REQUEST_BO = "CORRESPONDENCE_REQUEST_BO";
	public static final String CORRESPONDENCE_LETTERS = "CORRESPONDENCE_LETTERS";
	public static final String FIND_SUBMITTER_LIST = "SELECT sub.submitter_id FROM submitter sub, submitter_service_reltn ssr WHERE sub.submitter_id = ssr.submitter_id AND ssr.service_id = ? AND ssr.Active_ind = 1 AND ssr.SUBMITTER_SERVICE_PASSWORD is not null";
	public static final String GET_TRANSACTION_COUNT = "SELECT COUNT (tg.GROUP_ID) AS group_cnt FROM 	trk_group tg WHERE 	tg.updt_dt_tm between TRUNC (SYSDATE - 10) AND (SYSDATE - 10/(24*60)) AND tg.partner_id IS NOT NULL AND tg.submitter_id = ? AND tg.service_method_id	= ? AND   tg.trxn_status_cd		= ? GROUP BY tg.partner_id, tg.submitter_id, tg.service_method_id, tg.trxn_status_cd";
	
	public static final String SERVICE = "SERVICE";
	public static final String SERVICE_CATEGORY = "SERVICE_CATEGORY";
	public static final String TRXN_STATUS_CODES = "TRXN_STATUS_CODES";
	public static final String REALTIME ="REALTIME";
	public static final String CORRESPONDENCE_REQUEST = "CORRESPONDENCE_REQUEST";
	
	public static final String PERF_SUBMIT = "BatchCreate.SubmitBatch";
	public static final String PERF_FIND_SUBMITTERS = "BatchCreate.FindSubmitters";
	public static final String PERF_PUT_SUB_IN_QUEUE = "BatchCreate.PutSubmitterIdInQueue";
	public static final String PERF_PROCESS_GROUPS = "BatchCreate.ProcessSubmitterPartnerGroups";
	public static final String PERF_HANDLE_ERROR = "BatchCreate.HandleError";
	public static final String PERF_COPY_FILE = "BatchCreate.CopyFile";
	public static final String PERF_INVOKE_MAP = "BatchCreate.InvokeMap";
	public static final String PERF_PROCESS_BATCH_REQ = "BatchProcessGroupsBPEL";
	public static final String PERF_TRANSFORMATION_RESP = "BatchCreate.TranformationServiceCall";
	public static final String PERF_PUT_OUTBUND_MESSAGE = "BatchCreate.PutMessageInOutboundQueue";
	public static final String PERF_FIND_SUB_PARTNER_GROUP = "BatchCreate.findSubmitterPartnerGroups";
	public static final String PERF_PUT_BATCH_REQ_MSG = "BatchCreate.PutBatchRequestMessage";
	public static final String PERF_TRK_CREATE_GROUP = "BatchCreate.TrackingCreateGroup";
	public static final String PERF_TRK_JOIN_GROUP = "BatchCreate.TrackingJoinGroup";
	public static final String PERF_TRK_ADD_CHILD_TO_PARENT = "BatchCreate.TrackingAddChildToParent";
	public static final String PERF_ADD_HISTORY = "BatchCreate.TrackingAddHistory";
	public static final String PERF_UPDATE_FILE_LOCATION = "BatchCreate.TrackingUpdateFileLocation";
	public static final String PERF_UPDATE_BATCH_STATISTICS = "BatchCreate.TrackingUpdateBatchStatistics";
	public static final String PERF_FIND_GROUPS = "BatchCreate.TrackingFindChildGroups";
	public static final String PERF_UPDATE_GROUP_STATUS_AND_FUNCTIONAL_STATUS = "BatchCreate.TrackingUpdateGroupAndFunctionalStatus";
	public static final String PERF_UPDATE_GROUP_STATUS = "BatchCreate.TrackingUpdateGroupStatus";
	public static final String PERF_BATCH_UPDATE_GROUP_EVENTS = "BatchCreate.TrackingBatchUpdateGroupEvent";
	public static final String PERF_ADD_EVENT_TO_GROUP = "BatchCreate.TrackingAddEventToGroup";
}
