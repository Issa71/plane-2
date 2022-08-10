package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Service
@Primary
	public class PlaneServiceList implements PlaneService {

		private List<Plane> planes;

		public PlaneServiceList() {
			super();
			this.planes = new ArrayList<>();
			this.planes.add(new Plane("Airbus", 72, 250.00));
		}

		@Override
		public Plane makePlane(Plane plane) {
			this.planes.add(plane);
			return planes.get(this.planes.size() - 1);
		}

		@Override
		public List<Plane> getAllPlanes() {
			return this.planes;
		}

		@Override
		public Plane getById(int id) {
			return this.planes.get(id);
		}

		@Override
		public Plane updatePlane(int id, String name, Integer size, Double cost) {
			Plane toUpdate = this.planes.get(id);

			if (name != null && !name.isBlank())
				toUpdate.setName(name);
			if (size != null)
				toUpdate.setSize(size);
			if (cost != null)
				toUpdate.setCost(cost);

			return toUpdate;
		}

		@Override
		public void delete(int id) {
			this.planes.remove(id);
		}
}
