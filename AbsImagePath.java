import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author Yogesh
 * 
 * Java Class to Find Absolute path of image files in given directory format
 * Directory Format:
 * dir1
 *  dir11
 *   hello.jpeg
 *  dir12
 * dir2
 *  hi.gif
 *  
 *  Output: for hello.jpg: /dir1/dir11
 *  		for hi.gif: /dir2
 *
 */
public class AbsImagePath {

	public static void main(String[] args) {
		String dir = "dir1\n dir11\n dir12\n  something.jpeg\ndir2\n dir21\n  hi.jpeg\n dir22\n  hello.png\ndir3\n Bablu.gif\n dir31\ndir4\n dir41\n  dir411\n   Yogibo.gif";
		ArrayList<String> parent_List = new ArrayList<String>();
		String[] dir_arr = dir.split("\n");
		HashMap<String, String> parent = new HashMap<String, String>();
		for(String str : dir_arr){		
			int index = str.lastIndexOf(" ");
			parent_List.add((index+1), str.substring(index+1));
			if(index >= 0){
				parent.put(str.trim(), new String(parent_List.get(index)));
			}
		}
		ArrayList<String> dir_list = new ArrayList<String>();
		for(String str:dir_arr){
			str = str.trim();
			Pattern pat = Pattern.compile("[a-zA-Z]+.(jpeg|gif|png)");
			if(pat.matcher(str).matches())
				dir_list.add(str);
		}
		dir_list.forEach(str->{String absPath = "";absPath=getAbsPath(str, parent); System.out.println("Absolute Path of: " + str + " is: " + absPath);});
	}
	
	public static String getAbsPath(String str, HashMap<String, String> parent){
		String absPath = "";
		while(parent.containsKey(str)){
			str = parent.get(str);
			absPath = "/" + str + absPath;
		}	
		return absPath;
	}

}
