package cmsc420.prquadtree;

import java.awt.geom.Point2D;

import cmsc420.geometry.City;
import cmsc420.geometry.CityAlreadyMappedException;

public class EmptyNode extends Node {

    /** empty PR Quadtree node */
    public static EmptyNode instance = new EmptyNode();

    /**
     * Constructs and initializes an empty node.
     */
    public EmptyNode() {
        super(Node.EMPTY);
    }

    @Override
    public Node add(Metropole metropole, City city, Point2D.Float origin, int width, int height) throws CityAlreadyMappedException {
        Node leafNode = new LeafNode();
        return leafNode.add(metropole,city, origin, width,height);
    }

    @Override
    public Node remove(Metropole metropole, Point2D.Float origin, int width, int height) {
        throw new IllegalArgumentException();
    }

    @Override
    public Metropole findMetroPole(Point2D.Float location) {
        return null;
    }
}
