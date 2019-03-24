package ZhiLianSpider;

import java.util.ArrayList;
import java.util.List;

/**
 * 	在未获得作者许可的情况下,请勿反编译文件!
 * 	Please do not decompile files without permission from the author! 
 * @author DellHaven(刘学鹏)
 * @version CN版(DH0.0.1)
 * 	配有DH版
 */
public class Welcome
{
	public static void main(String[] args)
	{
		DBCore dbCore = new DBCore();								//openDBCoreServer
		dbCore.login("scott", "tiger", "spiderInfo");				//loginMyORCLAdataBase
		
		String JsonOrHtmlDate = SpiderCore.openPage("Java",false);	//openSpiderCore
		AnalysisCore analysis = new AnalysisCore();					//AnalysisInfo
		List<Info> infos = new ArrayList<Info>();					//dataStack
		
		if(SpiderCore.isJson(JsonOrHtmlDate))
		{
			infos = analysis.analysisJsonData(JsonOrHtmlDate);
		}else if(SpiderCore.isHtml(JsonOrHtmlDate))
		{
			infos = analysis.analysisHtmlData(JsonOrHtmlDate);			
		}
		
		SpiderCore.PrintData(infos);
		
//		//默认使用orcl
//		dbCore.insert("新华教务部", "新华集团", "1k", "山东", "民营", "www.404.com", "0人在职", "Dumbass", "全职", "山东", "Null", "Null", "Null");
//		//start database operation
//		dbCore.select("jobNa","JOBTY","Dumbass");
	}
}
