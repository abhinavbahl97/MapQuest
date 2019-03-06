package cmsc420.geometry;
import java.awt.geom.Point2D;


public class Coordinate {
	
	private Point2D.Float remoteCoordinates;
    private Point2D.Float localCoordinates;

    public Coordinate(int localX, int localY, int remoteX, int remoteY) {
        localCoordinates = new Point2D.Float(localX, localY);
        remoteCoordinates = new Point2D.Float(remoteX, remoteY);
    }

    public int getLocalX () { return (int) localCoordinates.x; }
    public int getLocalY () { return (int) localCoordinates.y; }

    public int getRemoteX () { return (int) remoteCoordinates.x;}
    public int getRemoteY () { return (int) remoteCoordinates.y;}

    public Point2D.Float getLocalCoordinates() {
        return localCoordinates;
    }

    public Point2D.Float getRemoteCoordinates() {
        return remoteCoordinates;
    }

}
