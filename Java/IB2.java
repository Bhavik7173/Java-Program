class Demo{
	{
		System.out.println("IB-1 Super");
	}
	Demo()
	{
		this(5);
		System.out.println("Default");
	}
	{
		System.out.println("IB-2 Super");
	}
	Demo(int x)
	{
		
		System.out.println("Demo-1 Para");
	}
}
class Demo1 extends Demo{
	
	{
		System.out.println("IB-1 sub");
	}
	Demo1()
	{
		super();
		System.out.println("Default sub");
	}
	{
		System.out.println("IB-2 Sub");
	}
	Demo1(int x)
	{
		this();
		System.out.println("Para sub");
	}
	
}
class Test{
	
	public static void main(String arg[])
	{
		Demo1 d,d2 ;
		d = new Demo1(2);
		d2 = new Demo1();
		//d.disp();
	}
}
/*Output:-
IB-1 Super
IB-2 Super
Demo-1 Para
Default
IB-1 sub
IB-2 Sub
Default sub
Para sub
IB-1 Super
IB-2 Super
Demo-1 Para
Default
IB-1 sub
IB-2 Sub
Default sub
*/