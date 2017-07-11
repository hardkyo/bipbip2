package com.kitri.util;

public class NumberCheck {
	
	public static int nullToZero(String tmp){
		int num = 0;
		if (isNumber(tmp)) {			
			num = Integer.parseInt(tmp);
		}
		return num;
	}
	
	public static int nullToOne(String tmp){
		int num = 1;
		if (isNumber(tmp)) {			
			num = Integer.parseInt(tmp);
		}
		return num;
	}

	private static boolean isNumber(String tmp) {
		boolean flag = true;
		if (tmp != null && !tmp.isEmpty()) { // ������ ���� !! -> ���� �ƴ϶�� ���� �Ͽ� ���� ("")�� ó������
			int len = tmp.length();
			for (int i = 0; i < len; i++) {
				int c = tmp.charAt(i);
				if((char)c == '.')
					continue;
				if (c < 48 || c > 57) {
					flag = false;
					break;
				}
			}
		} else {
			flag=false;
		}
		return flag;
	}
	
	public static double nullToZeroZero(String tmp){
		double num = 0;
		if (isNumber(tmp)) {			
			num = Double.parseDouble(tmp);
		}
		return num;
	}
	
}
