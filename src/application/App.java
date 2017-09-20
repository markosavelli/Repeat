package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {

		App appObject = new App();
		// System.out.println(appObject.hasUpperBeg("marko"));
		// System.out.println(appObject.moreUppercase("MARko"));
		// System.out.println(appObject.isSameWordNumber("two", 2));
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("Mario", "Ülari", "Raivo"));
		appObject.isWordInList("", list);
		System.out.println(appObject.isWordInList("Marko", list));
		System.out.println(numberToWord(100000));
		
		Map<String, String> data = new HashMap<String, String>();
		
	      data.put("1", "One");
	      data.put("2", "Two");
	      System.out.println(data);
	}
	// Sisendiks sõne, väljundiks tõeväärtus
	// Teha kindlaks, kas sõna algab suure tähega

	// hasUpperBeg("Marko") - > true
	public boolean hasUpperBeg(String str) {
		char firstChar = str.charAt(0);
		return Character.isUpperCase(firstChar);
	}

	// Teha kindlaks, kas suuri tähti on rohkem kui väikseid
	private boolean moreUppercase(String str) {
		int bLetters = 0;
		for (char c : str.toCharArray()) {
			if (Character.isUpperCase(c)) {
				bLetters++;
			}
		}
		// väikseste_tähted_arv = kõikide_tähtde_arv - suurte_tähted_arv
		int sLetters = str.length() - bLetters;
		// System.out.println("Sõnas " + str + " on suuri tähti: "+ bLetters+ " ja
		// väikeseid tähti on "+ sLetters);
		return bLetters > sLetters;

	}

	private String numberToWord(Integer num) {
		String[] numbers = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		if (num < 10 && num > 0) {
			return numbers[num - 1];
		}
		throw new IllegalArgumentException("Entered number was not in range. Number should be between 1 to 10");
	}

	// isSameWordNumber("one", 1) -> true
	// isSameWordNumber("two", 1) -> false
	private boolean isSameWordNumber(String numString, Integer num) {
		if (num >= 10 || num <= 0) {
			throw new IllegalArgumentException("Entered number was not in range. Number should be between 1 to 10");
		}

		// N-ö tõlgitud number
		String parsedNumber = numberToWord(num);
		System.out.println("parsed valu: " + parsedNumber);
		return numString.equals(parsedNumber);
	}

	// Sisendiks sõne ja list, väljundiks tõeväärtus.
	// Otsustada, kas sõne on listis
	public boolean isWordInList(String searchName, ArrayList<String> list) {
		for (String element : list) {
			if (element.equals(searchName)) {			
				return true;	
			}
		}
		return false;
	}
// TODO

		static HashMap<Integer,String> numberMap = new HashMap<Integer,String>();
        static{
            numberMap.put(0,"Zero");
            numberMap.put(1,"One");
            numberMap.put(2,"Two");
            numberMap.put(3,"Three");
            numberMap.put(4,"Four");
            numberMap.put(5,"Five");
            numberMap.put(6,"Six");
            numberMap.put(7,"Seven");
            numberMap.put(8,"Eight");
            numberMap.put(9,"Nine");
            numberMap.put(10,"Ten");
            numberMap.put(11,"Eleven");
            numberMap.put(12,"Twelve");
            numberMap.put(13,"Thirteen");
            numberMap.put(14,"Fourteen");
            numberMap.put(15,"Fifteen");
            numberMap.put(16,"Sixteen");
            numberMap.put(17,"Seventeen");
            numberMap.put(18,"Eighteen");
            numberMap.put(19,"Nineteen");
            numberMap.put(20,"Twenty");
            numberMap.put(30,"Thirty");
            numberMap.put(40,"Forty");
            numberMap.put(50,"Fifty");
            numberMap.put(60,"Sixty");
            numberMap.put(70,"Seventy");
            numberMap.put(80,"Eighty");
            numberMap.put(90,"Ninety");
            numberMap.put(100,"Hundred");
            numberMap.put(1000,"Thousand");

        }
        public static String numberToWord(int number)
        {
            String wordForm = "";
            int quotient =0;
            int remainder = 0;
            int divisor = 0;
            if(number<1000000000 && number>=1000000)
            {
                divisor = 1000000;
                quotient = number/divisor;
                remainder = number % divisor;
                if(quotient!=0)
                wordForm += numberToWord(quotient) + " " + "Million";
                if(remainder!=0)
                    wordForm+= " " + numberToWord(remainder);
            }
            else if(number<1000000 && number>=10000)
            {
                divisor = 1000;
                quotient = number/divisor;
                remainder = number % divisor;
                if(quotient!=0)
                wordForm += numberToWord(quotient) + " " + "Thousand";
                if(remainder!=0)
                    wordForm+= " " + numberToWord(remainder);
            }
            else if(number<10000 && number>=1000)
            {
                divisor = 1000;
                quotient = number/divisor;
                remainder = number % divisor;
                if(quotient!=0)
                wordForm += numberMap.get(quotient) + "Thousand";
                if(remainder!=0)
                    wordForm+= numberToWord(remainder);

            }else if(number<1000 && number>=100)
            {
                divisor = 100;
                quotient = number/divisor;
                remainder = number % divisor;
                if(quotient!=0)
                wordForm += numberMap.get(quotient) + " " + "Hundred";
                if(remainder!=0)
                    wordForm +=numberToWord(remainder);

            }else if(number<100 && number>=10)
            {
                divisor = 10;
                quotient = number/divisor;
                remainder = number % divisor;
                if(quotient!=0)
                    wordForm+= numberMap.get(quotient*divisor);
                if(remainder!=0)
                    wordForm+= numberMap.get(remainder);


            }else if(number<10 && number>=0)
            {
                wordForm +=  numberMap.get(number);

            }
            return wordForm;
        }
}
