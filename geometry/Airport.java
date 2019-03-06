package cmsc420.geometry;

import java.awt.geom.Point2D;
import java.util.HashMap;

public class Airport extends Geometry{
	private String airportName;
    private HashMap<String, Terminal> terminalMap = new HashMap<>();
    private Coordinate coordinate;
    
    
    public Airport(String name, int localX, int localY, int remoteX , int remoteY, String terminalName, int terminalX, int terminalY, String terminalCity) {
        coordinate = new Coordinate(localX, localY, remoteX ,remoteY);
        this.airportName = name;
        terminalMap.put(terminalName, new Terminal(terminalX, terminalY, remoteX, remoteY, terminalName, terminalCity, airportName));
    }
    
    public void addTerminal(Terminal terminal) {
        terminalMap.put(terminal.getName(), terminal);
   }
    public String getAirportName() {
        return airportName;
    }
    
    public Point2D.Float getLocalCoordinates() {
        return coordinate.getLocalCoordinates();
    }

    public Point2D.Float getRemoteCoordinates() {
        return coordinate.getRemoteCoordinates();
    }
    
    public int getLocalX () 
    { 
    	return (int) coordinate.getLocalX(); 
    }
    public int getLocalY () 
    { 
    	return (int) coordinate.getLocalY(); 
    }

    public int getRemoteX () 
    { 
    	return (int) coordinate.getRemoteX();
    }
    public int getRemoteY () 
    { 
    	return (int) coordinate.getRemoteY();
    }

	@Override
	public int getType() {
		return 4;
	}
	
	@Override
    public boolean isTerminal() {
        return false;
    }

}
