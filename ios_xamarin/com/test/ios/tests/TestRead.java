package com.test.ios.tests;

import java.io.File;

import com.test.mobile.excel.App_Excel_Read;
import com.test.mobile.hooks.App_Config;

public class TestRead {

	public static void main(String[] args) throws Exception
	{
		for(int i=App_Config.Start_Row_Number; i<=App_Config.End_Row_Number;i++)
		{
			
				App_Excel_Read.read(i);
				System.out.println("working fine");
		}

}
}
