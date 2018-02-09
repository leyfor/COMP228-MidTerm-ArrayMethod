import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public abstract class LottoGame {
	
	//PRIVATE INSTANCE VARIABLES +++++++++
	private int _elementNum;
	private int _setSize;
	
	
	//PROTECTED REFERENCE TYPES +++++++++++
	protected int[] _numberArray;
	protected int[] _elementArray;

	
	// CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++
	public LottoGame(int elementNum, int setSize) {
		super();
		this._elementNum = elementNum;
		this._setSize = setSize;
	}
	
	// Instantiate ArrayList  and Build the numberArrayList
	private void _initialize() {
		
		this._elementArray = new int[this._elementNum]; // final array to hold the element
		this._numberArray = new int[this._setSize + 1]; // Array to manipulate the element(first hold the element)
		
		for (int num = 1; num < this._numberArray.length; num = num + 1) {
			this._numberArray[num] = num;
		}
		
	}
	
	public void pickElements() {
		Random rnd = new Random();
		int rndElement;
		int index = 0; // Sentinel variable
		
		this._initialize(); // reset the array structure
		while(index < this._elementNum) {
			// Check if rndElement has been chosen
			rndElement = rnd.nextInt(this._setSize) + 1; 
			if(this._numberArray[rndElement] != -1) {
				this._elementArray[index] = rndElement; 
				// Flag  that number has been chosen
				this._numberArray[rndElement] = -1;
				index++;
			}
		}
		
		//Sort the Element Array
		Arrays.sort(this._elementArray);
		
	}

}
