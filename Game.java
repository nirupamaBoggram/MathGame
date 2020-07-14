package com.math_game.quiz;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Game 
{
		
		public static void main(String[] args) throws InterruptedException {
			Driver driverref=new Driver();			
			Scanner sc  =new Scanner(System.in);
			System.out.println("Enter your name");
			String name=sc.next();
			System.out.println("Challange yourself by mentioning time in seconds");
			int sec=(sc.nextInt()*1000);
			Score sr=new Score();
			sr.Score(name);		
			
		
		Runnable r1=()->
		{
				Level1 l=new Level1();
				l.level1();
				
				new Level2().level2();
				
				new Level3().level2();
		};
		
		Thread t=new Thread(sr);
		Thread t2=new Thread(r1);
		t2.start();
		t.sleep(sec);
		t.start();
		t2.stop();	
		
		}
		}


class Divisors
{
	int [] a=new int[9];
	public  Divisors()
	{
	 int num=10;
	 int num2=10;
	 a[0]=10;
		for (int i=1;i<a.length ;i++ ) {
			
			num=num+9*num2;
			a[i]=num;
			num2=num2*10;
		}
	}
	public void divisor(int siz1,int siz2,int val,int val2,int n)
	{
		int res=a[siz1-n];
		int res2=a[siz2-n];
		val=val/res;
		val2=val2/res2;
		Scanner sc=new Scanner(System.in);
		System.out.println(val+"*"+val2+"=");
		int userVal=sc.nextInt();
		if (val*val2==userVal) {
			System.out.println("correct");
			new Score().score(n);
		}
		else{
			System.out.println("wrong");
		}
	}
	public int divisor(int siz1,int n)
	{
		return a[siz1-n];
	}
	
}
class Score extends Thread
{
	private static int scr;
	String name;
	public void Score(String name)
	{
		this.name=name;
	}
	public void score(int n)
	{
		scr=scr+n;
	}
	 public void run()
	{
		System.out.println("---------------------------------------------------------------");
			System.out.println("          "+"Name :"+name);
			System.out.println("          "+"your Total Score :"+scr);
	}
}
class Play
{
	Random rd=new Random();
		public  int plyGame1()
		{		
			return Math.abs(rd.nextInt());
		}
		public int plyGame2()
		{
			return Math.abs(rd.nextInt());
		}
}
class Level1 
{
	Score sr=new Score();
	Scanner sc=new Scanner(System.in);
	
	public  void level1()
	{
		System.out.println("---------------------------------------------------------------");
	System.out.println("Level 1");
	for (int i=0;i<=3; i++) {
	int rand1=0;
	int rand2=0;
	int j=1;
	while(true)
	{
		rand1=(int)(Math.random()*j);
		rand2=(int)(Math.random()*j);
		j++;
		if(rand1!=0&&rand2!=0)
		{
			break;
		}
	}
	System.out.println(rand1+"*"+rand2+"=");
	int ans=sc.nextInt();
	if(rand1*rand2==ans)
	{
		System.out.println("correct");
		sr.score(1);
	}
	else
	{
		System.out.println("wrong");
	}
	}
	}
	
}
class Level2 extends Play
{
	Divisors dv=new Divisors();
	Score sr=new Score();
	Scanner sc=new Scanner(System.in);
	public  void level2()
	{
		System.out.println("---------------------------------------------------------------");
		System.out.println("Level 2");
		for (int i=0;i<=3; i++) {
			int num=plyGame1();
			int num2=plyGame2();
		String str=Integer.toString(num);
		String str2=Integer.toString(num2);
		int val=str.length();
		int val2=str2.length();
		
		if (val>=3&&val2>=3) {
				dv.divisor(val,val2,num,num2,3);
		}
		else if(val>=3)
		{
				int res=dv.divisor(val,3);
				num=num/res;
				System.out.println(num+"*"+num2+"=");
				int userVal=sc.nextInt();
				if (num*num2==userVal) {
					System.out.println("correct");
					sr.score(2);					
				}
				else
				{
					System.out.println("wrong");
				}
		}
		else if(val2>=3)
		{
			int res=dv.divisor(val2,3);
				num2=num2/res;
				System.out.println(num+"*"+num2+"=");
				int userVal=sc.nextInt();
				if (num*num2==userVal) {
					System.out.println("correct");
					sr.score(2);
				}
				else
				{
					System.out.println("wrong");
				}
		}
		else
		{
			System.out.println(num+"*"+num2+"=");
				int userVal=sc.nextInt();
				if (num*num2==userVal) {
					System.out.println("correct");
					sr.score(2);
				}
				else
				{
					System.out.println("wrong");
				}
		}

	}
	}
}
class Level3 extends Play
{
	Divisors dv=new Divisors();
	Score sr=new Score();
	Scanner sc=new Scanner(System.in);
	public  void level2()
	{
		System.out.println("---------------------------------------------------------------");
		System.out.println("Level 3");
		for (int i=0;i<=3; i++) {
			int num=plyGame1();
			int num2=plyGame2();
		String str=Integer.toString(num);
		String str2=Integer.toString(num2);
		int val=str.length();
		int val2=str2.length();
		
		if (val>=4&&val2>=4) {
				dv.divisor(val,val2,num,num2,4);
		}
		else if(val>=4)
		{
				int res=dv.divisor(val,4);
				num=num/res;
				System.out.println(num+"*"+num2+"=");
				int userVal=sc.nextInt();
				if (num*num2==userVal) {
					System.out.println("correct");
					sr.score(3);					
				}
				else
				{
					System.out.println("wrong");
				}
		}
		else if(val2>=4)
		{
			int res=dv.divisor(val2,4);
				num2=num2/res;
				System.out.println(num+"*"+num2+"=");
				int userVal=sc.nextInt();
				if (num*num2==userVal) {
					System.out.println("correct");
					sr.score(3);
				}
				else
				{
					System.out.println("wrong");
				}
		}
		else
		{
			System.out.println(num+"*"+num2+"=");
				int userVal=sc.nextInt();
				if (num*num2==userVal) {
					System.out.println("correct");
					sr.score(3);
				}
				else
				{
					System.out.println("wrong");
				}
		}

	}
	}
}

