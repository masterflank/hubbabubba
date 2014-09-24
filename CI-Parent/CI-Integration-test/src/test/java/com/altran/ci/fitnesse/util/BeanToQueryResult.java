package com.altran.ci.fitnesse.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.altran.ci.query.QueryResultRow;

public class BeanToQueryResult {
	public static List<Object> convert(List<? extends QueryResultRow> beans) {
		List<Object> rows = new ArrayList<Object>();

		for (QueryResultRow bean : beans) {
			List<Object> row = new ArrayList<Object>();

			Collection<String> fieldNames = getSortedFieldNames(beans);
			for (String fieldName : fieldNames) {
				String value = getFieldValue(fieldName, bean);
				row.add(createCell(fieldName, value));
			}
			rows.add(row);
		}
		return rows;
	}

	private static String getFieldValue(String fieldName, QueryResultRow bean) {
		try {
			Field field = bean.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(bean).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	private static Collection<String> getSortedFieldNames(
			List<? extends QueryResultRow> beans) {
		Set<String> fieldNames = new TreeSet<String>();
		if (!beans.isEmpty()) {
			QueryResultRow bean = beans.get(0);
			for (Field field : bean.getClass().getDeclaredFields()) {
				fieldNames.add(field.getName());
			}
		}
		return fieldNames;
	}

	private static Object createCell(String heading, String value) {
		List<String> cell = new ArrayList<String>();
		cell.add(heading);
		cell.add(value);
		return cell;
	}
}
