package leetCode1;

import java.util.*;

public class Generate {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> column = new ArrayList<List<Integer>>(numRows);
		if (numRows <= 0) {
			return column;
		}

		List<Integer> row = new ArrayList<Integer>();
		row.add(1);
		column.add(row);

		for (int i = 1; i < numRows; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			for (int j = 1; j < i; j++) {
				temp.add(row.get(j) + row.get(j - 1));
			}
			temp.add(1);
			row = temp;
			column.add(row);
		}

		return column;
	}
}
