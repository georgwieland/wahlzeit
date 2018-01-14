package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FishTypeTest {

	FishType fishtype1;
	FishType fishtype2;
	
	
	@Before
	public void setupFish() {
		fishtype1 = new FishType("Rotlachs");
		fishtype2 = new FishType("Zander", true);
	}
	
	//*************************************************************************
	//		FishType.constructors
	//*************************************************************************
	@Test
	public void testConstructors() {
		assertNotNull(fishtype1);
		assertNotNull(fishtype1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor1Null() {
		FishType type1 = new FishType(null);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2Null() {
		FishType type2 = new FishType(null, true);
	}
	
	
	//*************************************************************************
	//		FishType.set-/get-methods
	//*************************************************************************
	@Test
	public void testGetter() {
		assertEquals(false, fishtype1.isPredator());
		assertEquals("Rotlachs", fishtype1.getName());
		
		assertEquals(true, fishtype2.isPredator());
		assertEquals("Zander", fishtype2.getName());
	}
	
	@Test
	public void testSetter() {
		fishtype1.setName("otherfish");
		fishtype1.setPredator(true);
		
		assertEquals(true, fishtype1.isPredator());
		assertEquals("otherfish", fishtype1.getName());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetNameNull() {
		fishtype1.setName(null);
	}
	
	//*************************************************************************
	//		FishType.equals
	//*************************************************************************
	@Test
	public void testEquals() {		
		assertNotEquals(fishtype1, fishtype2);
		assertEquals(fishtype1, fishtype1);
	}
	
	@Test
	public void testHashCode() {		
		assertNotEquals(fishtype1.hashCode(), fishtype2.hashCode());
		assertEquals(fishtype1.hashCode(), fishtype1.hashCode());
	}
	
	//*************************************************************************
	//		FishType.createInstance
	//*************************************************************************
	@Test
	public void testCreateInstance() {		
		Fish fish = fishtype1.createInstance(1234, 90.5);
		
		assertNotNull(fish);
		assertEquals(fish.getFishType(), fishtype1);
	}
	
	//*************************************************************************
	//		FishType.subtype/supertype
	//*************************************************************************
	@Test
	public void testSubtype() {		
		fishtype1.addSubType(fishtype2);
		
		assertTrue(fishtype2.isSubtype());
		assertFalse(fishtype1.isSubtype());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubtypeNull() {		
		fishtype1.addSubType(null);		
	}
	
	@Test
	public void testSuperType() {		
		fishtype1.addSubType(fishtype2);
		
		assertEquals(fishtype1, fishtype2.getSuperType());
	}
	
	@Test
	public void testRemoveSubtype() {		
		fishtype1.removeSubType(fishtype2);
		
		assertEquals(null, fishtype2.getSuperType());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveSubtypeNull() {		
		fishtype1.removeSubType(null);
	}
}
