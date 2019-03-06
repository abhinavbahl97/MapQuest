package cmsc420.prquadtree;

import java.awt.geom.Point2D;

import cmsc420.geometry.CityAlreadyMappedException;
import cmsc420.geometry.City;

/**
 * Represents a leaf node of a PR Quadtree.
 */
public class LeafNode extends Node {
    /** city contained within this leaf node */
    protected Metropole metropole;

    /**
     * Constructs and initializes a leaf node.
     */
    public LeafNode() {
        super(Node.LEAF);
    }

    /**
     * Gets the city contained by this node.
     *
     * @return city contained by this node
     */
    public Metropole getCity() {
        return metropole;
    }

    public Node add(Metropole newMetropole, City city, Point2D.Float origin, int width,
                    int height) throws CityAlreadyMappedException {
        if (metropole == null) {
			/* node is empty, add city */
            metropole = newMetropole;
            if(city != null) {
                metropole.addCityToMetroPole(city);
            }
            return this;
        } else if (metropole.equals(newMetropole)) {
            metropole.addCityToMetroPole(city);
            return this;
        }   else {
			/* node is full, partition node and then add city */
            InternalNode internalNode = new InternalNode(origin, width, height);
            internalNode.add(metropole, null, origin, width, height);
            internalNode.add(newMetropole, city, origin, width, height);
            return internalNode;
        }
    }

    public Node remove(Metropole metropole, Point2D.Float origin, int width,
                       int height) {
        if (this.metropole != metropole) {
			/* city not here */
            throw new IllegalArgumentException();
        } else {
			/* remove city, node becomes empty */
            this.metropole = null;
            return EmptyNode.instance;
        }
    }

    @Override
    public Metropole findMetroPole(Point2D.Float location) {
        if(metropole != null && metropole.toPoint2D().equals(location)) {
            return metropole;
        }
        return null;
    }

    public Metropole getMetropole() {
        return metropole;
    }
}