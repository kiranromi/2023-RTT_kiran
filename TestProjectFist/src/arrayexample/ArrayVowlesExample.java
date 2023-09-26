package arrayexample;

public class ArrayVowlesExample {

	public static void main(String[] args) {
		String letters = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
		String[] strArray = letters.split(",");
		
		int vowelsCount =0;
		int consonantCount = 0;
		
		
		/*for(int i=0;i<strArray.length; i++ ){
			
			String x = strArray[i];
			
			if(x.equals("a") || x.equals("e")|| x.equals("i") || x.equals("o") || x.equals("u")) {
				vowelsCount++;
			}else {
				consonantCount++;
			}
		}*/
		
		for(String x : strArray) {
			if(x.equals("a") || x.equals("e")|| x.equals("i") || x.equals("o") || x.equals("u")) {
				vowelsCount++;
			}else {
				consonantCount++;
			}
		}
		System.out.println("Vowels count = "+vowelsCount);
		System.out.println("Not Vowels count = "+consonantCount);
	}

}
