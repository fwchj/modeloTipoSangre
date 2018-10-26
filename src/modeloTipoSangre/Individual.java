package modeloTipoSangre;

public class Individual {
	
	String gene1;
	String gene2;
	String tipoSangre;
	
	public Individual(String g1, String g2) {
		this.gene1 = g1;
		this.gene2 = g2;
		
		defineBloodType();
	}

	private void defineBloodType() {
		if((this.gene1=="A" && this.gene2=="A") ||
				(this.gene1=="A" && this.gene2=="O") ||
				(this.gene1=="O" && this.gene2=="A") ) {
			this.tipoSangre = "A";
		}
		else if((this.gene1=="B" && this.gene2=="B") ||
				(this.gene1=="B" && this.gene2=="O") ||
				(this.gene1=="O" && this.gene2=="B") ) {
			this.tipoSangre = "B";
		}
		else if (this.gene1=="O" && this.gene2=="O") {
			this.tipoSangre = "O";
		}
		else {
			this.tipoSangre="AB";
		}
	}

	
	
	
	
	
	
}
