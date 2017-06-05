package com.backbase.test.mehdijavan.utils;

import java.util.Comparator;

public class FieldComparator implements Comparator<Object> {

    private String getter;
    private boolean ascending;

    public FieldComparator(String field) {
    	if(field.startsWith("-")) {
    		ascending = false;
    		field = field.substring(1);
    	}
    	else
    		ascending = true;
    		
        this.getter = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    public int compare(Object o1, Object o2) {
        try {
            if (o1 != null && o2 != null) {
                o1 = o1.getClass().getMethod(getter, new Class[0]).invoke(o1, new Object[0]);
                o2 = o2.getClass().getMethod(getter, new Class[0]).invoke(o2, new Object[0]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot compare " + o1 + " with " + o2 + " on " + getter, e);
        }

        int result = (o1 == null) ? -1 : ((o2 == null) ? 1 : ((Comparable<Object>) o1).compareTo(o2));
        
        return ascending ? result : -1 * result;
    }

}