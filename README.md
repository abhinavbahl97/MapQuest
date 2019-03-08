# MapQuest-Project

The idea of the MapQuest project is to emulate some of the functionality of map sites like MapQuest or Google Maps. 
We will need a database of cities, which are just named points in the plane. 
From this, we want to be able to draw pictures of a given region showing the cities contained in that region. 
We will get cities from the database and insert them into a spatial data structure that can be used to draw a picture. 
The basic spatial data structure we will use is a quadtree -- a sort of 2-dimensional binary search tree.

There are three main concepts for this project: 
Data Dictionary (TreeMaps and TreeSets for part 1, B-tree for parts 2 and 3) 
Spatial Map (PR Quadtree for part 1, PM3 Quadtree for part 2) 
Road Adjacency List 
An important concept to remember is that the data dictionary is not the same as the spatial map. 
If you create a city, it is not automatically mapped in the spatial map.
