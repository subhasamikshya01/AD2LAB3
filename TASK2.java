import java.util.*;
public class TASK2 {
static ArrayList<Integer>RobinKarp(String T,String P){
	int prime=101;
	int m=P.length();
	int n=T.length();
	int Pat[]=new int[m];
	int Text[]=new int[n];
	for(int i=0;i<n;i++) {
		if(i<m) {
			Pat[i]=(int)P.charAt(i)-'a'+1;
		}
		Text[i]=(int)T.charAt(i)-'a'+1;
	}
	int h=1;
	int pnum=0;int tnum=0;
	for(int k=0;k<m;k++) {
		pnum=(pnum*10+Pat[k])%prime;
		tnum=(tnum*10+Text[k])%prime;
		if(k<m-1) {
			h=(h*10)%prime;
		}
	}
	ArrayList<Integer>res=new ArrayList<Integer>();
	int i=0,k=0,j=0;
	while(i<n-m) {
		if(pnum==tnum) {
			k=0;j=i;
			while(k<m &&P.charAt(i)==T.charAt(j)) {
				k++;j++;
			}
			if(k==m) {
				res.add(i);
			}
		}
		if(i<n-m) {
			tnum=((tnum-Text[i]*h)*10+Text[i+m])%prime;
			if(tnum<0) {
				tnum=tnum+prime;
			}
		}
		i++;
	}
	return res;
}
	public static void main(String[] args) {
		System.out.println("Hello World");
		String Text="abcbacbabczcbabaabcabbbcacbb";
		String Pat="yuvi";
		ArrayList<Integer>pos=new ArrayList<Integer>();
		pos=RobinKarp(Text,Pat);
		System.out.println(Text);
		System.out.println(Pat);
		for(Integer x:pos) {
			System.out.print(pos+" ");
		}
	}

}
