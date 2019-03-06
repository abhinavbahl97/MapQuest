package cmsc420.prquadtree;

import cmsc420.command.Command;
import cmsc420.geometry.CityAlreadyMappedException;
import cmsc420.geometry.City;
import cmsc420.geometry.CityLocationComparator;
import cmsc420.geometry.Geometry;
import cmsc420.geometry.Terminal;
import cmsc420.pmquadtree.*;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.TreeSet;

public class Metropole extends Geometry {

    /** 2D coordinates of this city */
    protected Point2D.Float point;
    protected PMQuadtree pmQuadtree;
    protected Validator validator;

    protected final TreeSet<City> citiesByLocation = new TreeSet<City>(
            new CityLocationComparator());
    
    public Metropole(final int x, final int y, int type) {
        point = new Point2D.Float(x, y);
        if(type == 1) {
            pmQuadtree = new PM1Quadtree(Command.localWidth, Command.localHeight);
            this.validator = new PM1Validator();
        }else {
            pmQuadtree = new PM3Quadtree(Command.localWidth, Command.localHeight);
            this.validator = new PM3Validator();
        }
    }

    public Metropole(final Metropole metropole) {
        this.point = metropole.point;
    }

    public void addCityToMetroPole(City city) throws CityAlreadyMappedException{
        if(citiesByLocation.contains(city)) {
            throw new CityAlreadyMappedException();
        }
        citiesByLocation.add(city);
    }

    public int getX() {
        return (int) point.x;
    }

    public int getY() {
        return (int) point.y;
    }

    public boolean equals(final Object obj) {
        if (obj == this)
            return true;
        if (obj != null && (obj.getClass().equals(this.getClass()))) {
            Metropole c = (Metropole) obj;
            return (point.equals(c.point));
        }
        return false;
    }

    public String getLocationString() {
        final StringBuilder location = new StringBuilder();
        location.append("(");
        location.append(getX());
        location.append(",");
        location.append(getY());
        location.append(")");
        return location.toString();

    }

    public Point2D.Float toPoint2D() {
        return new Point2D.Float(point.x, point.y);
    }

    public String toString() {
        return getLocationString();
    }

    @Override
    public int getType() {
        return POINT;
    }

    public PMQuadtree getPmQuadtree() {
        return pmQuadtree;
    }

    public Validator getValidator() {
        return validator;
    }

    @Override
    public boolean isTerminal() {
        return false;
    }

  
}
