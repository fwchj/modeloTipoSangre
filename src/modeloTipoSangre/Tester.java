package modeloTipoSangre;

public class Tester {

	public static void main(String[] args) {
		Individual me = new Individual("A","B");
		int countA = 0;
		int countB = 0;
		for( int i=0;i<10000;i++) {
			if(me.getOneGene()=="A") {
				countA++;
				}
			else {
				countB++;
			}

	}
		
		System.out.printf("%s --- %s\n",countA,countB);

}
}
