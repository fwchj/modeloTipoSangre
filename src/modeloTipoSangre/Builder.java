package modeloTipoSangre;

import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.RandomCartesianAdder;

public class Builder implements ContextBuilder<Object>{

	@Override
	public Context build(Context<Object> context) {
		// Dar un identificador unico al contexto
		context.setId("modeloTipoSangre");
		
		int dimensionY = 50;
		int dimensionX = 50;
		Parameters params = RunEnvironment.getInstance().getParameters();
		int numeroAgentes = params.getInteger("numeroAgentes");
		
		ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder.createContinuousSpaceFactory(null);
		ContinuousSpace<Object> space = spaceFactory.createContinuousSpace("miEspacio", 
				context,
				new RandomCartesianAdder<Object>(), 
				new repast.simphony.space.continuous.StrictBorders(),dimensionX,dimensionY);
				
		
		// Generar agentes
			//Obtener las proporciones
			double propA = params.getDouble("propA");
			double propAB = params.getDouble("propAB");
			double propB = params.getDouble("propB");
		
		for(int i=0;i<numeroAgentes;i++) {
			double r = RandomHelper.nextDoubleFromTo(0,1);
			if(r<propA) {
				context.add(new Individual("A"));
			}
			else if(r < propA+propB) {
				context.add(new Individual("B"));
			}
			else if(r < propA + propB + propAB) {
				context.add(new Individual("AB"));
			}
			else {
				context.add(new Individual("O"));
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		return context;
	}

}
