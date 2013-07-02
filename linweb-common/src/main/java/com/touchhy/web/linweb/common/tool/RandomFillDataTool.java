package com.touchhy.web.linweb.common.tool;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Random;

public class RandomFillDataTool {
	private static Random random = new Random();

	public static void fill(Object object, boolean positive)
			throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object fieldValue = null;
			field.setAccessible(true);
			if (field.getType().equals(int.class)
					|| field.getType().equals(Integer.class)) {
				if (positive)
					fieldValue = Math.abs(random.nextInt());
				else
					fieldValue = random.nextInt();
			} else if (field.getType().equals(String.class)) {
				fieldValue = "STRING" + random.nextDouble();
			} else if (field.getType().equals(byte.class)
					|| field.getType().equals(Byte.class)) {
				if (positive)
					fieldValue = (byte)Math.abs(random.nextInt(2));
				else
					fieldValue = (byte) random.nextInt(2);
			} else if (field.getType().equals(Date.class)) {
				fieldValue = new Date();
			} else if (field.getType().equals(Long.class)
					|| field.getType().equals(long.class)) {
				if (positive)
					fieldValue = Math.abs(random.nextLong());
				else
					fieldValue = random.nextLong();
			} else if (field.getType().equals(double.class)
					|| field.getType().equals(Double.class)) {
				if (positive)
					fieldValue = Math.abs(random.nextDouble());
				else
					fieldValue = random.nextDouble();
			} else if (field.getType().equals(float.class)
					|| field.getType().equals(Float.class)) {
				if (positive)
					fieldValue = Math.abs(random.nextFloat());
				else
					fieldValue = random.nextFloat();
			}
			if (fieldValue != null) {
				field.set(object, fieldValue);
			}
		}
	}
}
