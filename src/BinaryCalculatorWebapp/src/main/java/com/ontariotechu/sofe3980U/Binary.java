package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary
{
	private String number="0";

	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0";
			return;
		}

		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0";
				return;
			}
		}

		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}

	public String getValue()
	{
		return this.number;
	}

	// ================= ADD =================
	public static Binary add(Binary num1,Binary num2)
	{
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		int carry=0;
		String num3="";

		while(ind1>=0 ||  ind2>=0 || carry!=0)
		{
			int sum=carry;
			if(ind1>=0){
				sum += (num1.number.charAt(ind1)=='1')? 1:0;
				ind1--;
			}
			if(ind2>=0){
				sum += (num2.number.charAt(ind2)=='1')? 1:0;
				ind2--;
			}
			carry=sum/2;
			sum=sum%2;
			num3 =( (sum==0)? "0":"1")+num3;
		}
		return new Binary(num3);
	}

	// ================= MULTIPLY =================
	public static Binary multiply(Binary num1, Binary num2)
	{
		Binary result = new Binary("0");
		String n2 = num2.number;

		for(int i = n2.length()-1, shift = 0; i >= 0; i--, shift++)
		{
			if(n2.charAt(i) == '1')
			{
				String temp = num1.number;
				for(int s=0; s<shift; s++)
					temp += "0"; // shift left
				result = add(result, new Binary(temp));
			}
		}
		return result;
	}

	// ================= AND =================
	public static Binary and(Binary num1, Binary num2)
	{
		String n1 = num1.number;
		String n2 = num2.number;

		int max = Math.max(n1.length(), n2.length());

		n1 = String.format("%" + max + "s", n1).replace(' ', '0');
		n2 = String.format("%" + max + "s", n2).replace(' ', '0');

		String result = "";

		for(int i=0; i<max; i++)
		{
			if(n1.charAt(i)=='1' && n2.charAt(i)=='1')
				result += "1";
			else
				result += "0";
		}
		return new Binary(result);
	}

	// ================= OR =================
	public static Binary or(Binary num1, Binary num2)
	{
		String n1 = num1.number;
		String n2 = num2.number;

		int max = Math.max(n1.length(), n2.length());

		n1 = String.format("%" + max + "s", n1).replace(' ', '0');
		n2 = String.format("%" + max + "s", n2).replace(' ', '0');

		String result = "";

		for(int i=0; i<max; i++)
		{
			if(n1.charAt(i)=='1' || n2.charAt(i)=='1')
				result += "1";
			else
				result += "0";
		}
		return new Binary(result);
	}
}