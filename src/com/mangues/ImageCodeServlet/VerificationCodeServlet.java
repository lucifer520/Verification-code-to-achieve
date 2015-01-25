package com.mangues.ImageCodeServlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerificationCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //创建图片的不buff内存缓存区
		BufferedImage bi=new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB); 
		//获取图像的处理接口
		Graphics GImage=bi.getGraphics();
		//创建图片背景色
		Color color=new Color(200,150,255);
		//设置图片颜色
		GImage.setColor(color);
		//与canvas 差不多  用来 用当前颜色填充 矩形
		GImage.fillRect(0, 0, 68, 22);	
		
		char[] ca="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random r=new Random();  //随机默认当前系统时间对应的相对时间有关的数字作为种子数:
		int len=ca.length;
		int index;
		StringBuilder sb=new StringBuilder();
		Font f = new Font("宋体",Font.BOLD ,24); 
		GImage.setFont(f);
		
		for(int i=0;i<4;i++){    //随机生成四个数字
			index=r.nextInt(len);
			GImage.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			if(i==2){
				Graphics2D g2d = (Graphics2D) GImage;
				g2d.rotate( 0.02*Math.PI);//旋转
				
			}
			GImage.drawString(ca[index]+"", i*10+10, 18);   //设置每个字符的位置
			sb.append(ca[index]);		
		}
		
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          doGet(request,response);
	}

}
