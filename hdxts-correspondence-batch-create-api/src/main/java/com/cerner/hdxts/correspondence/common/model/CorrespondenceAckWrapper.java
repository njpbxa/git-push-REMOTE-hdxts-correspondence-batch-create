package com.cerner.hdxts.correspondence.common.model;

import com.cerner.hdxts.correspondence.letters.model.CorrespondenceAck;
import com.cerner.hdxts.correspondence.statements.model.Ack;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder(value={"correspondenceAck","ack"})
public class CorrespondenceAckWrapper 
{
	@JsonProperty(value="CORRESPONDENCE_ACK")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private CorrespondenceAck correspondenceAck;
	
	@JsonProperty(value="ack")
	@JsonInclude(JsonInclude.Include.NON_NULL)
    private Ack ack;

    public Ack getAck() {
		return ack;
	}
	public void setAck(Ack ack) {
		this.ack = ack;
	}
	public CorrespondenceAck getCorrespondenceAck() {
		return correspondenceAck;
	}
	public void setCorrespondenceAck(CorrespondenceAck correspondenceAck) {
		this.correspondenceAck = correspondenceAck;
	}
}
