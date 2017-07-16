package math;

public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First first = new First();
		first.count();
	}
	
	public int count() {
		int a = 2;
		int seq = 0;
		while(seq != 2333){
			if( a%2 == 0 || a%3 == 0){
				seq++;
				System.out.println("��Ϊ��" + a + "\t���Ϊ��" + seq);
			}
			a++;
		}
		return a;
	}

}
