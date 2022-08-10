package com.example.demo;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service	
@Primary
public class PlaneServiceDB implements PlaneService{
	
	private PlaneRepo repo;

	public PlaneServiceDB(PlaneRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Plane makePlane(Plane plane) {
		return this.repo.save(plane);
	}

	@Override
	public List<Plane> getAllPlanes() {
		return this.repo.findAll();
	}

	@Override
	public Plane getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public Plane updatePlane(int id, String name, Integer size, Double cost) {
		Plane toUpdate = this.getById(id);

		if (name != null && !name.isBlank())
			toUpdate.setName(name);
		if (size != null)
			toUpdate.setSize(size);
		if (cost != null)
			toUpdate.setCost(cost);

		return this.repo.save(toUpdate);
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}
}
