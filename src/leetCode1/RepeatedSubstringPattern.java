package leetCode1;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String str) {
		if(str.length()==0||str.length()==1){
			return false;
		}
		
		int size=str.length();
		
		for(int i=1;i<=size/2;i++){
			if(size%i==0){
				String temp=str.substring(0, i);
				int j=i;
				int m=0;
				while(j<=size){
					if(str.substring(m,j).equals(temp)){
						m=j;
						j+=i;
					}else{
						break;
					}
				}
				
				if(j>size){
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args){
		String a="abab";
		RepeatedSubstringPattern b=new RepeatedSubstringPattern();
		if(b.repeatedSubstringPattern(a)){
			System.out.println(1);
		}
	}
}
