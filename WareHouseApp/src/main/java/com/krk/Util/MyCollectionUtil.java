package com.krk.Util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyCollectionUtil {

	public static Map<Integer, String> convertListToMap(List<Object[]> list) {
		Map<Integer,String> map=list.stream()
                .collect(
             		   Collectors.toMap(
             		   ob-> Integer.valueOf(ob[0].toString()),
             		   ob-> ob[1].toString())
             		   );
		return map;
	}
}
