import java.util.Scanner;
import java.util.HashMap;

public class longestSubstring
{
    public static void main(String[] args)
    {
        System.out.println("Enter a string: ");
        Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		System.out.println("The longest substring with unique characters: " + findLongestSubstring(line));
    }
    
    public static String findLongestSubstring(String str)
    {
        HashMap<Character, Integer> charAndIndex = new HashMap<>();
        String longestSubstr = "";
        int maxLength = 0;
        int maxStart = 0;
        int start = 0;
        char currentChar;
        
        for (int i = 0; i < str.length(); i++)
        {
            currentChar = str.charAt(i);
            // check if 
            if (charAndIndex.containsKey(currentChar) && charAndIndex.get(currentChar) >= start) 
            {
                start = charAndIndex.get(currentChar) + 1;
            }
            
            charAndIndex.put(currentChar, i); // put current character in the map
            
            if (i - start + 1 > maxLength) // check if the new substring is longer
            {
                maxLength = i - start + 1;
                maxStart = start; // new starting character
            }
        }
        System.out.println("Line length: " + str.length());
        System.out.println("Last entrance of symbol in the line: \n" + charAndIndex.toString());
        longestSubstr = str.substring (maxStart, maxStart + maxLength);
        return longestSubstr;
    }
}