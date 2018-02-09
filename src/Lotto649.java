import java.util.Random;

public class Lotto649 extends LottoGame implements IBonusNumber {  
	
	// CONSTRUCTOR ++++++++++++++++++++++++++++++++++++++
	public Lotto649() {
		super(6, 49);
	}
	
	// PUBLIC METHODS ++++++++++++++++++++++++++++++++++++++
	public int bonusNumber() {
		Random rnd = new Random();
		int number = 0;
		int rndElement;
		
		int index = 0; // assign sentinel variable for while loop
		while(index < 1) {
			rndElement = rnd.nextInt(49) + 1;
			//check to see if rndElement has been chosen
			if(this._numberArray[rndElement] != -1) {
				number = rndElement;
				//set flag -1 to indicate rndElement has been chosen
				this._numberArray[rndElement] = -1;
				// increment sentinel variable
				index++;
			}
		}
		return number;
	}
	
	// PUBLIC OVERIDDEN METHODS +++++++++++++++++++++++
	@Override
	public String toString() {
		String output = "";
		int  setNum = 5;
		
		output += "5 SETS OF NUMBERS USING ARRAYS \n";
		output += "+++++++++++++++++++++++++++++++++++\n";
		
		for(int count = 0; count < setNum; count = count + 1) {
			this.pickElements();
			
			for (int element = 0; element < this._elementArray.length; element = element + 1) {
				if(element > 0) {
					output += ", ";
				}
				output += this._elementArray[element];
			}
			output += " + Bonus: " + this.bonusNumber() + "\n";	
 		}
		output +=  "++++++++++++++++++++++++++++++++\n";
		return output;
		
	}

}
