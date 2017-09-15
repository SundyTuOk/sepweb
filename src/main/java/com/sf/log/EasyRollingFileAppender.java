package com.sf.log;

import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.spi.LoggingEvent;


public class EasyRollingFileAppender extends DailyRollingFileAppender {

	String maxBackUp = "50";

	public String getMaxBackUp() {
		return maxBackUp;
	}

	public void setMaxBackUp(String maxBackUp) {
		this.maxBackUp = maxBackUp;
	}

	@Override
	protected void subAppend(LoggingEvent event) {

		super.subAppend(event);
		File[] allLogFiles = getAllLogFiles();
		deleteRedundantLogs(allLogFiles);
	}

	/**
	 * 获取日志目录下面的所有日志文件
	 * 
	 * @return
	 */
	public File[] getAllLogFiles() {
		// 根据正在操作的日志文件得到该目录下所有日志文件
		File logFile = new File(this.fileName);
		File logFileDir = logFile.getParentFile();
		
		if(!logFileDir.isDirectory()) return null;
			
		// 所有的日志文件
		File[] logFiles = logFileDir.listFiles();
		return logFiles;
	}
	
	/**
	 * 根据配置的maxBackUp，删除多余的日志文件
	 * @param logFiles 所有的日志文件
	 */
	public void deleteRedundantLogs(File[] logFiles)
	{
		int maxBackupSize = Integer.parseInt(maxBackUp);
		if (logFiles.length < maxBackupSize) 
		{
			return;
		}
		
		//用来存放日志文件的map 比如有个日志文件是ConsleLog.2017-08-03-11-42.log
		//那么map里面存下的就是<2017-08-03-11-42 , ConsleLog.2017-08-03-11-42.log>,并且把日志文件排好序
		Map<String,File> logFileDateMap = new TreeMap<String,File>(new Comparator<String>() {

			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		// 正则 取 年月日 时
		String regx = ".*(\\d{4}.\\d{2}.\\d{2}.\\d{2}).*";
		Pattern pattern = Pattern.compile(regx);

		for (File f : logFiles) 
		{
			String logFileName = f.getName();
			Matcher matcher = pattern.matcher(logFileName);
			if (matcher.find()) 
			{
				logFileDateMap.put(matcher.group(1), f);
			}
		}
		
		int logFileDateMapSize = logFileDateMap.size();
		
		if(logFileDateMapSize < maxBackupSize) return;
		
		Set<String> keySet = logFileDateMap.keySet();  
        Iterator<String> iter = keySet.iterator(); 
        
        int needDeleteCount = logFileDateMapSize - maxBackupSize;
        //需要被删除的logFile
        for(int index = 0;index<needDeleteCount && iter.hasNext();index++)
        {
        	File needDeleteFile = logFileDateMap.get(iter.next());
        	needDeleteFile.delete();
        }
        
        logFileDateMap = null;
	}
}
