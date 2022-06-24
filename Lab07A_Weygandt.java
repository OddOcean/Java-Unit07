// Aidan Weygandt 10.26.21
// Purpose of Program: 
// Use the Sieve of Eratosthenes to compute primes  
// to an upper bound set by user input
// The indexes of a boolean array will be used to represent prime numbers 
// at end of algorithm anything still true is prime  

import java.util.Scanner;


class Lab07A_Weygandt{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("\n");
    final int MAX = enterData(input, "Enter the primes upper bound  ===>>  ");
    boolean primes[] = new boolean[MAX + 1];
 	 computePrimes(primes);
    displayPrimes(primes);
  }
  
  //method that uses Sieve of Eratosthenes and a 
  //Boolean array to calculate primes up to MAX
  public static void computePrimes(boolean primes[]){//makes an array of all prime numbers from 1 - max
	 System.out.println("\n\nCOMPUTING PRIME NUMBERS");
    for (int num = 2; num < primes.length; num++){//sets all values to true
      primes[num] = true;
    }
    for (int num = 2; num < primes.length; num++){//for ever number that is a multiple of num, set it as not prime
      if (primes[num]){//if number is prime set all multiples as not prime, else skips multiples and goes on to next num
        for (int x = num * 2; x < primes.length; x += num){
          primes[x] = false;
        }
      }else{
        continue;
      }
    }
  }

  //method that outputs the boolen array contents
  //output is set to 10 numbers per line
  //format is used so each number is buffered to be 5 spaces wide
	public static void displayPrimes(boolean primes[]){
		System.out.println("\n\nPRIMES BETWEEN 1 AND "+ (primes.length - 1));
		System.out.println();
      String line = "";
      int counter = 0;//counter for keeping track of how many primes there are per line
      for (int i = 0; i < primes.length; i++){//loops though primes and formats them to all be 5 wide with spaces, adds them all to the same line
        if (primes[i]){
          line += String.format("%-5s", i);
          counter ++;
        }
        if (counter % 10 == 0 && counter != 0){//if line reaches ten primes then prints line and start new line
          System.out.println(line);
          line = "";
          counter = 0;
        }
      }
      System.out.println(line);//prints last line incase it didnt make it to ten primes
  }

  //method that checks for correct input from user
  //if incorrect input avoid error, send output to user and ask for correct input
  public static int enterData(Scanner console, String prompt){
    System.out.print(prompt);
    while (!console.hasNextInt()){ //make sure an int was entered
      console.nextLine(); //clear the invalid input before prompting again
      System.out.print("Please enter a valid integer: ");
    }
    return console.nextInt();
  }

}