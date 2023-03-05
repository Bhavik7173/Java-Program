//Initialization Block(IB)
/*
	data member => IB
	if 1 data member then 1 IB
	if 2 data member then 2 IB
	when run => before constructor
	works => allocate the data members.
	
*/
class Demo{
	int a;
	float b;
	String c;
	
	void disp()
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
class Demo1{
	
	{
		System.out.println("IB-1");
	}
	Demo1()
	{
		System.out.println("Default");
	}
	{
		System.out.println("IB-2");
	}
	Demo1(int x)
	{
		this();
		System.out.println("Para");
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

/*Output:
IB-1
IB-2
Default
IB-1
IB-2
Default

With Parameter Constructor
IB-1
IB-2
Para
IB-1
IB-2
Default

with this function
IB-1
IB-2
Default
Para
IB-1
IB-2
Default
*/