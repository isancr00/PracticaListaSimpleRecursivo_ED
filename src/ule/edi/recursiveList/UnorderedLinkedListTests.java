package ule.edi.recursiveList;



import org.junit.*;

import ule.edi.exceptions.EmptyCollectionException;
import ule.edi.exceptions.TypeIsNotComparableException;
import ule.edi.recursiveList.AbstractLinkedListImpl.Node;



public class UnorderedLinkedListTests {



	private UnorderedLinkedListImpl<String> lS;
	private UnorderedLinkedListImpl<String> lSABC;


	@Before
	public void setUp() {
		this.lS = new UnorderedLinkedListImpl<String>();


		this.lSABC = new UnorderedLinkedListImpl<String>("A", "B", "C");
	}

	@Test
	public void constructorElemens(){
		lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
		Assert.assertEquals("(A B C D )", lS.toString());
	}

	// TESTS DE addFirst
	@Test
	public void addFirstTest(){

		lS.addFirst("D");
		Assert.assertEquals("(D )", lS.toString());
		lS.addFirst("C");
		Assert.assertEquals("(C D )", lS.toString());
		lS.addFirst("B");
		Assert.assertEquals("(B C D )", lS.toString());
		lS.addFirst("A");
		Assert.assertEquals("(A B C D )", lS.toString());
	}

	// TESTS DE addBefore

	@Test
	public void addBeforeTest(){

		lS.addFirst("D");
		Assert.assertEquals("(D )", lS.toString());
		lS.addBefore("C", "D");
		Assert.assertEquals("(C D )", lS.toString());
		lS.addBefore("A","C");
		Assert.assertEquals("(A C D )", lS.toString());
		lS.addBefore("B", "C");
		Assert.assertEquals("(A B C D )", lS.toString());
	}

	//Tests toStringReverse 

	@Test
	public void toStringReverse(){
		lS=new UnorderedLinkedListImpl<String>("A", "B", "C", "D");
		Assert.assertEquals("(A B C D )", lS.toString());
		Assert.assertEquals("(D C B A )", lS.toStringReverse());

	}
	// Tests eliminar duplicados

	@Test
	public void testRemoveDuplicates() throws EmptyCollectionException {
		UnorderedLinkedListImpl<String> lista=new UnorderedLinkedListImpl<String>("A", "A", "B", "C", "B", "A", "C"); 
		Assert.assertEquals(lista.removeDuplicates(),4); 
		Assert.assertEquals(lista.toString(), "(A B C )");
		Assert.assertEquals(lSABC.removeDuplicates(),0); // 0 repetids
		Assert.assertEquals(lSABC.toString(), "(A B C )");	

	}



	// AÑADIR MAS TESTS para el resto de casos especiales y para el resto de métodos
	// de las clases AbstractLinkedListImpl y UnorderedLinkedListImpl
	@Test

	public void testIsOrdered() {
		UnorderedLinkedListImpl<Integer> lista=new UnorderedLinkedListImpl<Integer>(1,2,3,4,58,6);
		UnorderedLinkedListImpl<Integer> lista2=new UnorderedLinkedListImpl<Integer>(); 
		Assert.assertEquals(lista2.toString(), "()");	

		Assert.assertEquals(lSABC.toString(), "(A B C )");	
		Assert.assertTrue(lSABC.isOrdered());
		Assert.assertTrue(lista2.isOrdered());
		Assert.assertFalse(lista.isOrdered());
	}

	@Test
	public void testRemoveLast() throws EmptyCollectionException {
		lSABC.removeLast("A");
		Assert.assertEquals(lSABC.toString(),"(B C )");

	}

	@Test
	public void testNodeToString() {
		Assert.assertEquals(lSABC.front.toString(),"(A)");
	}

	@Test (expected = NullPointerException.class)
	public void testContainsNull() {
		lSABC.contains(null);
	}

	@Test
	public void testContainsEmpty() {
		Assert.assertFalse(lS.contains("A"));
	}

	@Test (expected = NullPointerException.class)
	public void testCountNull() {
		lS.count(null);		
	}
	
	@Test 	
	public void testCount() {
		Assert.assertEquals(lS.count("B"), 0);
		lSABC.addFirst("B");
		lSABC.addFirst("B");
		lSABC.addFirst("B");
		
		Assert.assertEquals(lSABC.count("B"), 4);

	}
	
	@Test (expected = EmptyCollectionException.class)
	public void testGetLastEmpty() throws EmptyCollectionException {
		lS.getLast();
	}
	
	@Test
	public void testGetLast() throws EmptyCollectionException {
		Assert.assertEquals(lSABC.getLast(), "C");
	}
	
	
	@Test (expected = EmptyCollectionException.class)
	public void testRemoveEmpty() throws EmptyCollectionException {
		lS.remove("S");
	}
	
	@Test (expected = NullPointerException.class)
	public void testRemoveNull() throws EmptyCollectionException {
		lSABC.remove(null);
	}
	
	@Test 
	public void testRemove() throws EmptyCollectionException {
		Assert.assertNull(lSABC.remove("J"));
		Assert.assertEquals(lSABC.remove("A"), "A");
		Assert.assertEquals(lSABC.toString(), "(B C )");
		
		lSABC.addFirst("A");
		Assert.assertEquals(lSABC.toString(), "(A B C )");
		
		Assert.assertEquals(lSABC.remove("C"), "C");
		Assert.assertEquals(lSABC.toString(), "(A B )");
		

		
	}
	
}
