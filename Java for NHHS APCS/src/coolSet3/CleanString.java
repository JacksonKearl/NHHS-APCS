package coolSet3;

public class CleanString
{
	public static void main( String args[] )
	{
		//String name = "6--&*^== SPa(())^^!!rtaNs --%%$#w ...iN";
		String name = "&&&*^5$Th__e KapTA..in$@!";
		System.out.println("\n" + "original string ==> " +
				"\"" + name + "\".");
		System.out.print( "\n" + "new string ==> " + "\"" +
				clean( name.toLowerCase() ) + "\"." );
	}
	public static String clean( String n )
	{ 
		String val = "";
		if ('a' <= n.charAt(0) && n.charAt(0) <= 'z' )
			val += n.charAt(0);
		if (n.length()>1)
			val += clean(n.substring(1));
		return val;


	}
}
