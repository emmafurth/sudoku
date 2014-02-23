//import java.lang.Math;
import java.util.*;

public class GrabBag<E> extends ArrayList<E>
{
	public GrabBag()
	{
		super();
	}
	public GrabBag(int initialCapacity)
	{
		super(initialCapacity);
	}
	public GrabBag(Collection<? extends E> c)
	{
		super(c);
	}
	// Gets element at random from the GrabBag
	public E getRandom()
	{
		Random generator = new Random();
		Integer ran = new Integer(generator.nextInt(super.size()));
		return super.get(ran);
	}
}