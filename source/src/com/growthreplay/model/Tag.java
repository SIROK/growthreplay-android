package com.growthreplay.model;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.growthbeat.model.Model;

public class Tag extends Model {

	private int tagId;

	private String name;

	private String value;

	public Tag() {
	}

	public Tag(String name, String value) {
		setName(name);
		setValue(value);
	}

	public Tag send(String growthbeatClientId, String credentialId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("clientId", growthbeatClientId);
		params.put("credentialId", credentialId);
		params.put("name", getName());
		params.put("value", getValue());

		JSONObject json = post("v3", "tag", params);
		setJson(json);

		return this;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public JSONObject getJsonObject() {
		return null;
	}

	@Override
	public void setJsonObject(JSONObject json) {
		if (json == null)
			return;

		try {
			if (json.has("tagId") && !json.isNull("tagId"))
				setTagId(json.getInt("tagId"));
			if (json.has("name") && !json.isNull("name"))
				setName(json.getString("name"));
			if (json.has("value") && !json.isNull("value"))
				setValue(json.getString("value"));
		} catch (JSONException e) {
		}
	}

}
