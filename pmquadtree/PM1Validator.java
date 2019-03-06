package cmsc420.pmquadtree;

import java.util.LinkedList;

import cmsc420.geom.Inclusive2DIntersectionVerifier;
import cmsc420.geometry.Geometry;
import cmsc420.geometry.Road;
import cmsc420.pmquadtree.PMQuadtree.Black;

public class PM1Validator implements Validator {

	@Override
	public boolean valid(Black node) {


		if(node.geometry.size() == 1 && node.numPoints == 0) 
		{

			return true;
		}

		else if(node.numPoints == 1) 
		{

			// geometry.remove(node.getCity());

			for (Geometry geom : node.geometry) 
			{

				if(geom.isRoad())
				{
					Road road1 = (Road) geom;

					if (!road1.contains(node.getCity())) 
					{
						return false;
					}
				}
			}
			return true;
		}

			else
				return  false;
		}
}

