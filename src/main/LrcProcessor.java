package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LrcProcessor {
	public void process(InputStream input,List<Long> timeMils,List<String> messages){
		
		try{
			InputStreamReader inputReader = new InputStreamReader(input);	//字节流到字符流
			BufferedReader bufferedReader = new BufferedReader(inputReader);	//字符流到文本
			String temp = null;
			Pattern p = Pattern.compile("\\[([^\\]]+)\\]");	//正则
			String result = null;
			boolean b = true;
			while((temp = bufferedReader.readLine())!=null){
				Matcher m = p.matcher(temp);
				if(m.find()){
					if(result != null){
						messages.add(result);
					}
					String timestr = m.group();
					Long timeMill = time2Long(timestr.substring(1,timestr.length() - 1));
					if(b){
						timeMils.add(timeMill);
					}
					String msg = temp.substring(10);
					result = ""+msg + "\n";
				}else {
					result = result + temp +"\n";
				}
			}
			messages.add(result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Long time2Long(String timestr){
		String s[]=timestr.split(":");
		int min = Integer.parseInt(s[0]);
		String ss[]=s[1].split("\\.");
		int sec = Integer.parseInt(ss[0]);
		int mill = Integer.parseInt(ss[1]);
		return min * 60 * 1000 + sec * 1000 + mill * 10L;
	}
	
}
