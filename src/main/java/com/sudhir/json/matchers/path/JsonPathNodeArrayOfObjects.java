/**
 * 
 */
package com.sudhir.json.matchers.path;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonPathNodeArrayOfObjects extends AbstractJsonPathNode<JSONArray> {

	public JsonPathNodeArrayOfObjects(String nodeKey) {
		super(nodeKey);
	}

	@Override
	public JsonTypeHolder<?> process(JsonTypeHolder<JSONArray> holder) throws JSONException {
		int index = index();
		return fwdToChain(JsonTypeHolder.of(holder.get().get(index)));
	}

	private int index() {
		String indexInArray = nodeKey.replaceAll("\\[", "").replaceAll("\\]", "");
		return Integer.valueOf(indexInArray);
	}		
}