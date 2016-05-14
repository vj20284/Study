package com.practise.geeks4geeks.dynamicprogramming;

import java.util.List;

public class BoxStacking {
	
	public int maxHeight(List<Box> boxes) {
		
		return 1;
	}

	public static class Box {
		public int height;
		public int length;
		public int breadth;
		
		public Box(int l, int b, int h) {
			this.length = l;
			this.breadth = b;
			this.height = h;
		}
		
		public boolean topOf(Box o) {
			if (this.length > o.length &&
				this.breadth > o.breadth)
				return true;
			return false;
		}
	}
}
