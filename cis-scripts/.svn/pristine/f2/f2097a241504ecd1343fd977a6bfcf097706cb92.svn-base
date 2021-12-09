package uk.ac.reigate.scripts.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.springframework.stereotype.Component

import uk.ac.reigate.model.Parent

@Component
class ParentUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParentUtils.class);

	/**
	 * <p>
	 * This method is used to take a parent addressee string and convert it into a List of Parent objects. This will attempt to split out the Mr and Mrs portions 
	 * of an addressee into separate object for each instance. 
	 * </p>
	 * <p>
	 * The routine current deals with addressees in the following formats:
	 * <ul>
	 * <li>Mr A Smith</li>
	 * <li>Mr Smith Jones</li>
	 * <li>Mr A B Smith</li>
	 * <li>Mr A Smith Jones</li>
	 * <li>Mr and Mrs Smith</li>
	 * <li>Mr and Mrs A Smith</li>
	 * <li>Mr Smith and Mrs Jones</li>
	 * <li>Mr A Smith and Mrs Jones</li>
	 * <li>Mr and Mrs A Smith Jones</li>
	 * <li>Mr and Mrs A B Smith</li>
	 * <li>Mr A and Mrs B Smith</li>
	 * <li>Mr A Smith and Mrs B Jones</li>
	 * <li>Mr A C Smith and Mrs B Jones</li>
	 * <li>Mr A Smith and Mrs B C Jones</li>
	 * <li>Mr A Smith and Mrs B Jones Smith</li>
	 * <li>Mr A Smith Bloggs and Mrs B Jones</li>
	 * </ul>
	 * 
	 * @param addressee an addressee string in one of the formats described
	 * @return a List of Parent objects
	 */
	static List<Parent> parentAddresseeToParentList(String addressee) {
		List<Parent> parents = new ArrayList<Parent>()
		List<String> a = addressee.split(' ')

		Parent parent1
		Parent parent2

		def posArr = a.findIndexValues { it -> (it.equals('and') || it.equals('&'))  }
		int pos = posArr.size() != 0 ? posArr[0].toInteger() : 0

		if (pos == 0) {
			//System.out.println("Single Parent     ($addressee)")
			switch (a.size()) {
				case 1:
					LOGGER.warn("WW Parent Addressee could not be converted into a Parent List. Problem Addressee: '" + addressee + "'")
					break;
				case 2:
					parent1 = new Parent(a[0], null, a[1])
					parents.add(parent1)
					break;
				case 3:
				// Mr A Smith
				// Mr Smith Jones
					if (a[1].size() == 1) {
						parent1 = new Parent(a[0], null, a[1] + ' ' + a[2])
					} else {
						parent1 = new Parent(a[0], a[1], a[2])
					}
					parents.add(parent1)
					break;
				case 4:
				// Mr A B Smith
				// Mr A Smith Jones
					if (a[2].size() == 1) {
						parent1 = new Parent(a[0], a[1] + a[2], a[3])
					} else {
						parent1 = new Parent(a[0], a[1], a[2] + ' ' + a[3])
					}
					parents.add(parent1)
					break;
				default:
					LOGGER.error("EE ParentUtils.parentAddresseeToParentList() - A problem occurred converting the Address into a Parent List. Probelm Addressee: '" + addressee + "'")
					break;
			}
		} else {
			//System.out.println("Multiple Parent   ($addressee)")
			switch (a.size()) {
				case 4:
				// Mr and Mrs Smith
					parent1 = new Parent(a[0], null, a[3])
					parent2 = new Parent(a[2], null, a[3])
					parents.add(parent1)
					parents.add(parent2)
					break;
				case 5:
				// Mr and Mrs A Smith
				// Mr Smith and Mrs Jones
					if (pos == 1) {
						parent1 = new Parent(a[0], a[3], a[4])
						parent2 = new Parent(a[2], null, a[4])
					} else if (pos == 2) {
						parent1 = new Parent(a[0], null, a[1])
						parent2 = new Parent(a[3], null, a[4])
					}
					parents.add(parent1)
					parents.add(parent2)
					break;
				case 6:
				// Mr A Smith and Mrs Jones
				// Mr Smith and Mrs A Jones
					if (pos == 1) {
						if (a[4].size() == 1) {
							parent1 = new Parent(a[0], a[3] +  a[4], a[5])
							parent2 = new Parent(a[2], null, a[5])
						} else {
							parent1 = new Parent(a[0], a[3], a[4] + ' ' + a[5])
							parent2 = new Parent(a[2], null, a[5])
						}
					}
				// Mr and Mrs A Smith Jones
				// Mr and Mrs A B Smith
				// Mr A and Mrs B Smith
					if (pos == 2) {
						if (a[1].size() == 1) {
							parent1 = new Parent(a[0], a[1], a[5])
							parent2 = new Parent(a[3], a[4], a[5])
						} else {
							parent1 = new Parent(a[0], null, a[2])
							parent2 = new Parent(a[3], a[4], a[5])
						}
					}
					if (pos == 3) {
						parent1 = new Parent(a[0], a[1], a[2])
						parent2 = new Parent(a[4], null, a[5])
					}
					parents.add(parent1)
					parents.add(parent2)
					break;
				case 7:
				// Mr A Smith and Mrs B Jones
				//TODO one or other parent may have double initial or double surname
					if (pos == 3) {
						parent1 = new Parent(a[0], a[1], a[2])
						parent2 = new Parent(a[4], a[5], a[6])
					}
					parents.add(parent1)
					parents.add(parent2)
					break;
				case 8:
				// Mr A C Smith and Mrs B Jones
				// Mr A Smith and Mrs B C Jones
				// Mr A Smith and Mrs B Jones Smith
				// Mr A Smith Bloggs and Mrs B Jones
					if (pos == 3) {
						if (a[6].size() == 0) {
							parent1 = new Parent(a[0], a[1], a[2])
							parent2 = new Parent(a[4], a[5] + a[6], a[7])
						} else {
							parent1 = new Parent(a[0], a[1], a[2])
							parent2 = new Parent(a[4], a[5], a[6] + ' ' + a[7])
						}
					} else if (pos == 4) {
						if (a[2].size() == 1) {
							parent1 = new Parent(a[0], a[1] + a[2] , a[3])
							parent2 = new Parent(a[5], a[6], a[7])
						} else {
							parent1 = new Parent(a[0], a[1], a[2] + ' ' + a[3])
							parent2 = new Parent(a[5], a[6], a[7])
						}
					}
					parents.add(parent1)
					parents.add(parent2)
					break;
				case 9:
				//TODO one or other parent may have double initial or double surname making the 9 words long
				default:
					LOGGER.error("EE ParentUtils.parentAddresseeToParentList() - A problem occurred converting the Address into a Parent List. Probelm Addressee: '" + addressee + "'")
					break;
			}
		}
		return parents
	}

}
