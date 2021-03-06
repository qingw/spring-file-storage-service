package in.clouthink.daas.fss.mongodb.model;

import in.clouthink.daas.fss.core.FileStorageRequest;
import in.clouthink.daas.fss.core.MutableFileObject;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dz
 */
@Document(collection = "FileObjects")
public class FileObject implements MutableFileObject {

	public static FileObject from(in.clouthink.daas.fss.core.FileObject fromObject) {
		FileObject result = new FileObject();
		BeanUtils.copyProperties(fromObject, result);
		if (result.getAttributes() == null) {
			result.setAttributes(new HashMap<String,String>());
		}
		return result;
	}

	public static FileObject from(FileStorageRequest request) {
		FileObject result = new FileObject();
		BeanUtils.copyProperties(request, result);
		if (result.getAttributes() == null) {
			result.setAttributes(new HashMap<String,String>());
		}
		return result;
	}

	@Id
	private String id;

	private String category;

	private String code;

	@Indexed
	private String name;

	private String description;

	@Indexed
	private String bizId;

	@Indexed
	private String finalFilename;

	private String originalFilename;

	private String prettyFilename;

	private String contentType;

	@Indexed
	private String uploadedBy;

	@Indexed
	private Date uploadedAt;

	private long size;

	private int version;

	private Map<String,String> attributes = new HashMap<String,String>();

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	@Override
	public String getFinalFilename() {
		return finalFilename;
	}

	public void setFinalFilename(String finalFilename) {
		this.finalFilename = finalFilename;
	}

	@Override
	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	@Override
	public String getPrettyFilename() {
		return prettyFilename;
	}

	public void setPrettyFilename(String prettyFilename) {
		this.prettyFilename = prettyFilename;
	}

	@Override
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@Override
	public Date getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(Date uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	@Override
	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public Map<String,String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String,String> attributes) {
		this.attributes = attributes;
	}
}
