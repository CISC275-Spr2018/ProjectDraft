package ModelTest;


/**
 * Class ModelTest
 * @author Team 11 - 8
 * */

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import model.FloatingObjs;
import model.InvasiveSpecies;
import model.ModelWorld;
import model.ProtectedSpecies;
import model.Trash;
class ModelTest {



	/**
	 *Animaltest : a test function for Animal class
	 *@param void : nothing
	 *@return void : this function tests whether the function in Animal class is malfunctioning
	 */

	@Test
	void Animaltest() {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 4 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5));
		loFloating.add(new InvasiveSpecies("catFish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5));

		ProtectedSpecies t1 = new ProtectedSpecies("bogturtle", 10 , 10);
		InvasiveSpecies t2 = new InvasiveSpecies("catFish", 10 , 10);

		t2.move();
		for(FloatingObjs f : loFloating) {
			assertEquals(4, f.getXloc());
			assertEquals(5, f.getYloc());
		}

		assertEquals("bogturtle", loFloating.get(0).getName());

		t1.move();
	}


	/**
	 *Trashtest : a test function for Trash class
	 *@param void : nothing
	 *@return void : this function tests whether the function in Trash class is malfunctioning
	 */

	@Test
	void Trashtest() {
		Trash trash = new Trash("plastic", 0, 0);
		System.out.println(trash);
	}

	/**
	 *ModelWorldtest : a test function for ModelWorld class
	 *@param void : nothing
	 *@return void : this function tests whether the function in ModelWorld class is malfunctioning
	 */

	@Test
	void ModelWorldtest() {
		ArrayList<FloatingObjs> loFloating = new ArrayList<FloatingObjs>();
		loFloating.add(new ProtectedSpecies("bogturtle", 4 , 5));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5));
		loFloating.add(new InvasiveSpecies("catFish", 4 , 5));
		loFloating.add(new ProtectedSpecies("horseshoeCrab", 4 , 5, 1, 3, 1));
		loFloating.add(new ProtectedSpecies("bogturtle", 4 , 5, 1, 2, 3));
		loFloating.add(new InvasiveSpecies("bass", 4 , 5, 2, 1, 1));
		loFloating.add(new InvasiveSpecies("catFish", 4 , 5, 2, 3, 5));
		loFloating.add(new Trash("plastic", 0, 0));
		loFloating.add(new Trash("plastic", 0, 0, 1, 2, 3));
		System.out.println(loFloating.get(0));
		System.out.println(loFloating.get(1));
		System.out.println(loFloating.get(7));
		ModelWorld m = new ModelWorld(loFloating);

		m.updateWorld();
		m.updateScore(100);
		assertEquals(100, m.getScore());
		m.destory(3);
		assertEquals(10, m.getListOfExistedFloatingObjs().size());
		
		
	}


}
