package modeloTipoSangre;

import java.util.ArrayList;

import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.random.RandomHelper;
import repast.simphony.util.ContextUtils;

public class Individual {
	
	String gene1;
	String gene2;
	String tipoSangre;
	
	public Individual(String g1, String g2) {
		this.gene1 = g1;
		this.gene2 = g2;
		
		defineBloodType();
	}

	public Individual(String tipoSangre) {
		this.tipoSangre = tipoSangre;
		
		// Generar una variable aleatoria para los casos no deterministicos
		double r = RandomHelper.nextDoubleFromTo(0, 1);
		if(this.tipoSangre=="A") {
			this.gene1 = "A";
			if(r<=1/3) {
				this.gene2 = "A";
			}
			else {
				this.gene2 = "O";
			}
		}// end if tipoSange==A
		else if(this.tipoSangre=="B") { // usando una forma mas rapida de programar lo equivalente
			this.gene1 = "B";
			this.gene2 = (r<1/3) ? "B" : "O";
		}
		else if(this.tipoSangre=="AB") {
			this.gene1 ="A";
			this.gene2 ="B";
		}
		else if(this.tipoSangre=="O") {
			this.gene1="O";
			this.gene2="O";
		}
		else {
			System.out.printf("Tipo de sangre desconocido: %s",this.tipoSangre);
			System.exit(0); // solucion radical: para la ejecucion de java (incluyendo repast)
		}
	}

	@ScheduledMethod(start=1,interval=1,shuffle=true,priority=50)
	public void stepMatching() {
		
		// Obtener el 'context' de este agente
		Context<Object> miContexto = ContextUtils.getContext(this);
		ArrayList<Individual> candidatos = new ArrayList<Individual>();
		
		for(Object o: miContexto.getObjects(Individual.class)) {
			if(o!=this) {
				candidatos.add((Individual) o);
			}
		}
		
		//Ahora el array list contiene todos los individuos (menos el this)
		Individual pareja = candidatos.get(0);
		
		// Ahora generamos los nuevos individuos
		Individual child1 = new Individual(this.getOneGene(),pareja.getOneGene());
		Individual child2 = new Individual(this.getOneGene(),pareja.getOneGene());
		
		
		
	}
	
	protected String getOneGene(){
		double r = RandomHelper.nextDoubleFromTo(0, 1);
		if(r<0.5) {
			return this.gene1;
		}
		else {
			return this.gene2;
		}
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
	
	public String getTipoSangre() {
		return this.tipoSangre;
	}

	
	
	
	
	
	
	
}
