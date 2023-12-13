
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class SortingDriver {
	
	private static void askForInput(SortingAlgorithms sa, int[] arr, Scanner kb) {
		
		System.out.print("Enter the algorithm: ");
		String command = kb.next();
		
		if (command.equalsIgnoreCase("s")) {
			sa.selectionSort(arr);
			sa.print(arr);
			System.out.println("#Selection-sort comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("m")) {
			sa.mergeSort(arr, 0, arr.length-1);
			sa.print(arr);
			System.out.println("#Merge-sort comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("h")) {
			sa.heapSort(arr);
			sa.print(arr);
			System.out.println("#Heap-sort comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("q")) {
			sa.quickSortFp(arr, 0, arr.length-1);
			sa.print(arr);
			System.out.println("#Quick-sort-fp comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("r")) {
			sa.quickSortRp(arr, 0, arr.length-1);
			sa.print(arr);
			System.out.println("#Quick-sort-rp comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("quit")) {
			System.exit(0);
		} else if (command.equalsIgnoreCase("CI")) {
			arr = generateArr(arr.length);
			System.out.println("The content of the array has been changed, the size of the array remain the same");
		} else if (command.equalsIgnoreCase("CS")) {
			System.out.print("Enter the size: ");
			arr = generateArr(kb.nextInt());
		} else {
			System.out.println("Invalid command");
		}
	}
	
	private static void askForInputRV(SortingAlgorithms sa, int[] arr, Scanner kb, int[] original) {
		
		System.out.print("Enter the algorithm: ");
		String command = kb.next();
		
		if (command.equalsIgnoreCase("s")) {
			sa.selectionSort(arr);
			sa.print(arr);
			System.out.println("#Selection-sort comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("m")) {
			sa.mergeSort(arr, 0, arr.length-1);
			sa.print(arr);
			System.out.println("#Merge-sort comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("h")) {
			sa.heapSort(arr);
			sa.print(arr);
			System.out.println("#Heap-sort comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("q")) {
			sa.quickSortFp(arr, 0, arr.length-1);
			sa.print(arr);
			System.out.println("#Quick-sort-fp comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("r")) {
			sa.quickSortRp(arr, 0, arr.length-1);
			sa.print(arr);
			System.out.println("#Quick-sort-rp comparison: " + sa.getComparisons());
		} else if (command.equalsIgnoreCase("quit")) {
			System.exit(0);
		} else if (command.equalsIgnoreCase("CI")) {
			arr = generateArr(arr.length);
			original = copyArr(arr);
			System.out.println("The content of the array has been changed, the size remain the same");
			askForInputRV(sa, arr, kb, original);
		} else if (command.equalsIgnoreCase("CS")) {
			System.out.print("Enter the size: ");
			arr = generateArr(kb.nextInt());
			original = copyArr(arr);
			System.out.println("Both the content and the size of the array have been changed");	
			askForInputRV(sa, arr, kb, original);
		} else {
			System.out.println("Invalid command");
		}
		
		sa.resetComparisons();
		arr = copyArr(original);
	}
	
	private static int[] generateArr(int size) {
		int[] arr = new int[size];
		Random rand= new Random(); 
        for (int i = 0; i < size; ++i) {
        	arr[i] = rand.nextInt(20001)-10000;
        }
        return arr;
	}
	
	private static int[] copyArr(int[] arr) {
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			newArr[i] = arr[i];
		}
		return newArr;
	}
	
	private static void randomInputVersion() {
		Scanner kb = new Scanner(System.in);
		SortingAlgorithms sa = new SortingAlgorithms();
		
		System.out.println("This is the costomized input version, which the user can "
				+ "costomize the input size\n");
		System.out.print("Enter the input size: ");
		int inputSize = kb.nextInt();
		
		int[] arr = generateArr(inputSize);
		int[] original = copyArr(arr);
		
		System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) "
				+ "quick-sort-fp (q) quick-sort-rp (r) with input size " + inputSize 
				+ "\n(Enter \"CI\" to change the contain of the array)"
				+ "\n(Enter \"CS\" to change the contain and the sieze of the array)"
				+ "\n(Enter \"quit\" to exit the program)");
		
		while (true) {
			System.out.print("Enter the algorithm: ");
			String command = kb.next();
			
			if (command.equalsIgnoreCase("s")) {
				sa.selectionSort(arr);
				sa.print(arr);
				System.out.println("#Selection-sort comparison: " + sa.getComparisons());
			} else if (command.equalsIgnoreCase("m")) {
				sa.mergeSort(arr, 0, arr.length-1);
				sa.print(arr);
				System.out.println("#Merge-sort comparison: " + sa.getComparisons());
			} else if (command.equalsIgnoreCase("h")) {
				sa.heapSort(arr);
				sa.print(arr);
				System.out.println("#Heap-sort comparison: " + sa.getComparisons());
			} else if (command.equalsIgnoreCase("q")) {
				sa.quickSortFp(arr, 0, arr.length-1);
				sa.print(arr);
				System.out.println("#Quick-sort-fp comparison: " + sa.getComparisons());
			} else if (command.equalsIgnoreCase("r")) {
				sa.quickSortRp(arr, 0, arr.length-1);
				sa.print(arr);
				System.out.println("#Quick-sort-rp comparison: " + sa.getComparisons());
			} else if (command.equalsIgnoreCase("quit")) {
				kb.close();
				System.exit(0);
			} else if (command.equalsIgnoreCase("CI")) {
				arr = generateArr(arr.length);
				original = copyArr(arr);
				System.out.println("The content of the array has been changed, the size remain the same");
			} else if (command.equalsIgnoreCase("CS")) {
				System.out.print("Enter the size: ");
				arr = generateArr(kb.nextInt());
				original = copyArr(arr);
				System.out.println("Both the content and the size of the array have been changed");
			} else {
				System.out.println("Invalid command");
			}
			
			sa.resetComparisons();
			arr = copyArr(original);
		}
	}

	private static void insertFromFileInt(int[] arr, String input) {
		String val = "";
		for (int i = 0, j = 0; i < input.length(); ++i) {
			if (input.charAt(i) != ' ') {
				val += input.charAt(i);
			} else {
				arr[j] = Integer.parseInt(val);
				++j;
				val = "";
			}
		}
	}

	public static void main(String[] args) {

		String input = "";
		
		try {
			File inputFile = new File(args[0]);
			Scanner fileReader = new Scanner(inputFile);
			while (fileReader.hasNextLine()) {
				input = fileReader.nextLine();
			}
			input += " ";
			fileReader.close();
		} catch (ArrayIndexOutOfBoundsException aioob) {
			try {
				randomInputVersion();
			} catch (Exception e) {
				System.out.println("Invalid input. Program terminating...");
				System.exit(0);
			}
		} catch (FileNotFoundException fnf) {
			System.out.println("The file provided is not found");
		}
		
		Scanner kb = new Scanner(System.in);
		SortingAlgorithms sa = new SortingAlgorithms();
		int[] arr = new int[10000];
		insertFromFileInt(arr, input);
		
		System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) "
				+ "quick-sort-fp (q) quick-sort-rp (r)");
		
		askForInput(sa, arr, kb);
		
		kb.close();
	}
}
