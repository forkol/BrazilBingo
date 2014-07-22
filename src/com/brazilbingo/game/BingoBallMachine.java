package com.brazilbingo.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BingoBallMachine
{
	
	private static final int SIZE = 90;
	public static final int BIN_EMPTY = -1;
	
	private ArrayList<Integer> bingoBallBin= null;
	
	public BingoBallMachine()
	{
		bingoBallBin = new  ArrayList<Integer>();
		
		// fill it full of numbers
		for(int i=1; i < SIZE+1; i++)
		{	
			bingoBallBin.add(i);
		}
		
		Collections.shuffle(bingoBallBin);
	}
	
	public int getBall()
	{
		if (!bingoBallBin.isEmpty())
		{
			return bingoBallBin.remove(0);
		}
		else
		{
			return BIN_EMPTY;
		}
	}
	
	public boolean isEmpty()
	{
		return bingoBallBin.isEmpty();
	}
}
