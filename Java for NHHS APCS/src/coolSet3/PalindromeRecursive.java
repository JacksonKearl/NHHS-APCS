package coolSet3;

public class PalindromeRecursive
{
	public static void main( String args[] )
	{
		//String ping = "^ &@C..at,))T* ac! ";
		String pong = "10!A...m,,AN(()))&*^$, a p l a--n, a canal:++45 Panama";
		String m = pong;
		System.out.println("\n" + "The original string is \"" + m + "\".");
		m = clean( m.toLowerCase() );
		System.out.println("\n" + "...the new cleaned-up string is ..." +
				"\"" + m + "\".");
		if( aPalindrome(m) ) System.out.print( "\n" + "\"" + m + "\"" +
				" is a palindrome." );
		else System.out.print( "\n" + "\"" + m + "\"" + " is not a palindrome." );
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

	public static boolean aPalindrome( String n )
	{ 
		if (n.length() == 0 || n.length() == 1)
			return true;
		if (n.charAt(0) != n.charAt(n.length()-1))
			return false;
		else 
			return aPalindrome(n.substring(1, n.length()-1));
	}
}
