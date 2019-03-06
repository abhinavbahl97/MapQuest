package cmsc420.prquadtree;

import java.awt.geom.Point2D;

import cmsc420.geometry.CityAlreadyMappedException;
import cmsc420.geometry.City;

/**
 * Node abstract class for a PR Quadtree. A node can either be an empty
 * node, a leaf node, or an internal node.
 */
public abstract class Node {
    public static final int EMPTY = 0;

    public static final int LEAF = 1;

    public static final int INTERNAL = 2;

    protected final int type;

    protected Node(final int type) {
        this.type = type;
    }

    /**
     * Adds a city to the node. If an empty node, the node becomes a leaf
     * node. If a leaf node already, the leaf node becomes an internal node
     * and both cities are added to it. If an internal node, the city is
     * added to the child whose quadrant the city is located within.
     *
     * @param metropole
     *            city to be added to the PR Quadtree
     * @param origin
     *            origin of the rectangular bounds of this node
     * @param width
     *            width of the rectangular bounds of this node
     * @param height
     *            height of the rectangular bounds of this node
     * @return this node after the city has been added
     */
    public abstract Node add(Metropole metropole, City city, Point2D.Float origin, int width,
                             int height) throws CityAlreadyMappedException;

    /**
     * Removes a city from the node. If this is a leaf node and the city is
     * contained in it, the city is removed and the node becomes a leaf
     * node. If this is an internal node, then the removal command is passed
     * down to the child node whose quadrant the city falls in.
     *
     * @param metropole
     *            city to be removed
     * @param origin
     *            origin of the rectangular bounds of this node
     * @param width
     *            width of the rectangular bounds of this node
     * @param height
     *            height of the rectangular bounds of this node
     * @return this node after the city has been removed
     */
    public abstract Node remove(Metropole metropole, Point2D.Float origin, int width,
                                int height);

    public abstract Metropole findMetroPole(Point2D.Float location);
    /**
     * Gets the type of the node (either empty, leaf, or internal).
     *
     * @return type of the node
     */
    public int getType() {
        return type;
    }
}
