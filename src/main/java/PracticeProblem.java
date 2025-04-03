import java.util.ArrayList;
import java.util.Arrays;


public class PracticeProblem{
	static ArrayList<String> arr;
	static String string;

	static void permutate(String cur, int visited, boolean unique){
		if(cur.length() == string.length()){
			arr.add(cur);
			return;
		}
		boolean[] letters = new boolean[256];
		for(int i = 0; i < string.length(); ++i){
			int ch = string.charAt(i);
			if((visited & 1 << i) == 0){
				if((unique && !letters[ch]) || !unique){
					permutate(cur+string.charAt(i), visited ^ 1 << i, unique);
				}else{
					continue;
				}
				if(unique){
					letters[ch] = true;
				}
			}
		}
	}

	static ArrayList<String> perms(String str){
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		string = new String(charArr);
		arr = new ArrayList<String>();
		permutate("", 0, false);
		return arr;
	}

	static ArrayList<String> permsUnique(String str){
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		string = new String(charArr);
		arr = new ArrayList<String>();
		permutate("", 0, true);
		return arr;
	}
	public static void main(String args[]){}
}
