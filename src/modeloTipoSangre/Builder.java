package modeloTipoSangre;

import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.parameter.Parameters;
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
				
		
		
		
		for(int i=0;i<numeroAgentes;i++) {
			context.add(new Individual("A","A"));
		}
		
		
		return context;
	}

}
