package com.example.demo;

import java.util.List;

public interface PlaneService {

	Plane makePlane(Plane plane);

	List<Plane> getAllPlanes();

	Plane getById(int id);

	Plane updatePlane(int id, String name, Integer size, Double cost);

	void delete(int id);
}

