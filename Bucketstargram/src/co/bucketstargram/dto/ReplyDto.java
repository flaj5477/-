package co.bucketstargram.dto;

public class ReplyDto {
	private String reMemberId;
	private String reBucketId;
	private String reReplyContents;
	
	public String getReMemberId() {
		return reMemberId;
	}
	public void setReMemberId(String reMemberId) {
		this.reMemberId = reMemberId;
	}
	public String getReBucketId() {
		return reBucketId;
	}
	public void setReBucketId(String reBucketId) {
		this.reBucketId = reBucketId;
	}
	public String getReReplyContents() {
		return reReplyContents;
	}
	public void setReReplyContents(String reReplyContents) {
		this.reReplyContents = reReplyContents;
	}
}
