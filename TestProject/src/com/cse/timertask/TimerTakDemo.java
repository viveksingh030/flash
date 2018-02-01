package com.cse.timertask;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
public class TimerTakDemo {
	public static void main(String args[]) throws IOException
	{
	Timer timer=new Timer();
	timer.schedule(new TimerTask() {
		
		@Override
		public void run() {
			//delete all  junk files 
			File f=new File("C:\\Users\\VIVEKS~1\\AppData\\Local\\Temp");
			File list[]=f.listFiles();
			deleteFile(list);
			cancel();
		}

		private void deleteFile(File[] list) {
			for(File f:list)
			{
				if(f.isFile())
				{
					f.delete();
				}
				else
				{
					deleteFile(f.listFiles());
					f.delete();
				}
			}
		}
	},1000,1000);
	}
}
