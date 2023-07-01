package test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.JsonObject;

import log.LogData;
import util.*;

public class Test {
	public static void main(String[] args) {
		String string = CreateLog.createIptablesLog("./log/iptables.log").getData().get(0).getField("Date");
		System.out.println(string);
	}
}
