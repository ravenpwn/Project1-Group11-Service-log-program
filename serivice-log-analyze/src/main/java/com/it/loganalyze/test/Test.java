package com.it.loganalyze.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.it.loganalyze.App;
import com.it.loganalyze.log.Log;
import com.it.loganalyze.log.LogData;

public class Test {
	public static void main(String[] args) {
		ArrayList<Log> data = App.getIptablesLogData().getData();
		ArrayList<Log> filteredLog = new ArrayList<>();
		for (Log l: data) {
//			if(l.getDate().toLocalDate().equals()) {
//				filteredLog.add(l);
//			}
			System.out.println(l.getDate().toLocalDate().equals(LocalDate.of(2023, 7, 5)));
		}
		System.out.println(filteredLog);
	}
}
