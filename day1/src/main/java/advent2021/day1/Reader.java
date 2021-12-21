package advent2021.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;

public class Reader {

	private MutableList<Integer> mItems = Lists.mutable.empty();
	
	public ImmutableList<Integer> getItems (){
		return mItems.toImmutable();
	}
	
	public void read(String pFile) throws FileNotFoundException {
		Scanner s = new Scanner(new BufferedReader(new FileReader(pFile)));
		while (s.hasNextInt()) {
			mItems.add(s.nextInt());
		}
		s.close();
	}

}
