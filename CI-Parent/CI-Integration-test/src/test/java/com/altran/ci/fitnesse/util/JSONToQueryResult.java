package com.altran.ci.fitnesse.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.json.JSONObject;

public class JSONToQueryResult {
	public static List<Object> convert(Collection<JSONObject> jsonResult) {
		List<Object> rows = new ArrayList<Object>();
		
		for (JSONObject json : jsonResult) {
			List<Object> row = new ArrayList<Object>();
			Set<String> headers = getSortedHeaders(json);
			for (String header : headers) {
				row.add(createCell(header, json.getString(header)));
			}
			rows.add(row);
		}
		return rows;
	}
	
	@SuppressWarnings("unchecked")
	private static Set<String> getSortedHeaders(JSONObject json) {
		return new TreeSet<String>(json.keySet());
	}

	private static Object createCell(String heading, String value) {
	    List<String> cell = new ArrayList<String>();
	    cell.add(heading);
	    cell.add(value);
	    return cell;
	}
}
