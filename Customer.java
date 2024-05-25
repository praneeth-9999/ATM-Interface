import java.util.*;
import java.io.*;
class Bank
{
	double sum;//instance variable...
	Bank()//default constructor...
	{
		sum=0.0;
	}
	void atm()
	{
		Scanner sc=new Scanner(System.in);
		String name,phno;
		double f1,a2,bal;
		double amount=0.0;
		double sum2=0.0;
		double sum1=0;
		f1=a2=bal=0.0;
		System.out.println("Enter your good name:");
		name=sc.nextLine();
		Phone.Phoneno w=new Phone.Phoneno();
		phno=w.phone();
		Details.Personal p=new Details.Personal();//fully qualified name
		String a=p.details();
		Details.Cvv c=new Details.Cvv();
		int b=c.cvvno();	
		System.out.println("*** Hello "+name+" Welcome to SBI ***");
		System.out.println("~select 1--> Deposit");
		System.out.println("~select 2--> Withdraw");
		System.out.println("~select 3--> View Balance");
		System.out.println("~select 4--> Transfer Money");
		System.out.println("~select 5--> View Details");
		int choice;
		System.out.println("enter the choice:");
		choice=sc.nextInt();
		while(choice!=6)
		{
			switch(choice)
			{
				case 1:
				{
					Deposit.Deposition d=new Deposit.Deposition();
					a2=d.deposit();
					sum=sum+a2;
					amount=sum;
					break;
				}
				case 2:
				{
					Withdraw.WithdrawMoney m=new Withdraw.WithdrawMoney();
					f1=m.withdraw();
					if(sum==0.0)
					{
						System.out.println("No balance in the Account");
					}
					else if(f1>sum)
					{
						System.out.println("No sufficient balance..");
					}
					else if(f1==amount)
					{
						System.out.println("Please maintain minimum balance");
					}
					else
					{
						sum1=sum1+f1;
						sum=sum-f1;
					}
					break;
				}
				case 3:
				{
					if(sum<=0)
					{
						System.out.println("No Balance");
					}
					else
					{
						System.out.println("Your Balance is Rs"+sum+"/-");
					}
					break;
				}
				case 4:
				{
					if(sum>0.0)
					{
						int number;
						Bank []c1=new Bank[10];
						System.out.println("Enter number:");
						Scanner st=new Scanner(System.in);
						number=st.nextInt();
						Details.Personal v=new Details.Personal();
						String x=v.details();
						System.out.println("enter the amount you want to transfer:");
						bal=st.nextDouble();
						if(bal<sum)
						{
							for(int j=0;j<10;j++)
							{
								if(j==number)
								{
									c1[j]=new Bank();
									c1[j].sum=bal;
								}
							}
							sum=sum-bal;
						}
						else
						{
							System.out.println("You dont have enough Amount...!!");
						}
					}
					else
					{
						System.out.println("You dont have money to transfer");
					}
					break;
				}
				case 5:
				{
					System.out.println(" **Your Details**");
					System.out.println("NAME:         "+name);
					System.out.println("PHONE:        "+phno);
					System.out.println("ATMNO:        "+a);
					break;
				}
				default:
				{
					System.out.println("Please enter choices b/w 1-5 only..!!");
				}
			}
			System.out.println("enter the choice:");
			choice=sc.nextInt();
		}
		System.out.println(" ***********BILL************");
		System.out.println("Deposited Money:           Rs"+amount+"/-");
		System.out.println("Withdrawed Money:          Rs"+sum1+"/-");
		if(bal<amount)
		{
			System.out.println("Transfered Money:          Rs"+bal+"/-");
		}
		else
		{
			System.out.println("Transfered Money:          Rs 0.0/-");

		}	
		System.out.println("Your Balance is:           Rs"+sum+"/-");
		System.out.println("\t  	VISIT AGAIN");
		System.out.println("\t  	THANKYOU");
		try
		{
			//byte streams
			FileOutputStream f=new FileOutputStream("Accountinfo.txt",true);
			byte []b1=new byte[50];
			b1=name.getBytes();
			f.write(b1);
			String s1=" ";
			byte []b11=new byte[10];
			b11=s1.getBytes();
			f.write(b11);
			byte []b2=new byte[50];
			b2=a.getBytes();
			f.write(b2);
			String s2=" ";
			byte []b21=new byte[10];
			b21=s2.getBytes();
			f.write(b21);
			byte []b3=new byte[50];
			String bs=Integer.toString(b);
			b3=bs.getBytes();
			f.write(b3);
			String s4=" ";
			byte []b22=new byte[10];
			b22=s4.getBytes();
			f.write(b21);
			String s3=Double.toString(sum);
			byte []b4=new byte[40];
			b4=s3.getBytes();
			f.write(b4);
			String t="\n";
			byte []t1=new byte[10];
			t1=t.getBytes();
			f.write(t1);
			f.close();
		}
		catch(Exception e)
		{
			System.out.println("Database Error...");
		}
	}
}
class Customerdummy extends Bank
{
	void method()
	{
		new Bank();
		atm();
	}
}
class Customer
{
	public static void main(String args[])
	{
		Customerdummy g=new Customerdummy();
		g.method();
	}
}
